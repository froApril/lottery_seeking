package lottery.domain.strategy.service.draw;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import lottery.common.Constants;
import lottery.domain.strategy.model.aggregates.StrategyRich;
import lottery.domain.strategy.model.req.DrawReq;
import lottery.domain.strategy.model.res.DrawResult;
import lottery.domain.strategy.model.vo.AwardRateInfo;
import lottery.domain.strategy.model.vo.DrawAwardInfo;
import lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import lottery.infrastructure.po.award.Award;
import lottery.infrastructure.po.strategy.Strategy;
import lottery.infrastructure.po.strategy.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/11
 */
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec {
    private Logger logger = LoggerFactory.getLogger(AbstractDrawBase.class);



    public DrawResult doDrawExec(DrawReq req) {

        // get the draw strategy
        StrategyRich strategyRich = super.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();

        // check whether the strategy has been injected
        this.checkAndInitRateData(strategy.getStrategyId(), strategy.getStrategyMode(), strategyRich.getStrategyDetailList());

        // get the exclude award data list
        List<String> excludeAward = this.queryExcludeAwardIds(req.getStrategyId());

        // do draw algorithm
        String awardId = this.drawAlgorithm(req.getStrategyId(), drawAlgorithmMap.get(strategy.getStrategyMode()), excludeAward);

        // return the packaged result
        return buildDrawResult(req.getUid(), req.getStrategyId(), awardId);

    }


    /**
     *
     * get the list of excluded awards, including stock is empty, risk control, needs to depend on the actual implementation
     *
     * @param strategyId
     * @return
     */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);


    /**
     * execute draw algorithm
     *
     * @param strategyId
     * @param drawAlgorithm
     * @param excludeAwardIds
     * @return award id
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);

    /**
     * check whether the strategy has been injected
     *
     * @param strategyId
     * @param strategyMode
     * @param strategyDetailList
     */
    private void checkAndInitRateData(Long strategyId, Integer strategyMode,  List<StrategyDetail> strategyDetailList) {

        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        if (drawAlgorithm.isExistRateTuple(strategyId)) return;

        // 解析并初始化中奖概率数据到散列表
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, strategyMode, awardRateInfoList);

    }


    /**
     * construct draw result
     *
     * @param uid        user id
     * @param strategyId strategy ID
     * @param awardId    award id, can be null
     * @return result
     */
    private DrawResult buildDrawResult(String uid, Long strategyId, String awardId) {
        if (awardId == null) {
            logger.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}", uid, strategyId);
            return new DrawResult(uid, strategyId, Constants.DrawState.FAIL.getCode());
        }

        Award award = super.queryAwardInfoByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(award.getAwardId(), award.getAwardName());
        logger.info("执行策略抽奖完成【已中奖】，用户：{} 策略ID：{} 奖品ID：{} 奖品名称：{}", uid, strategyId, awardId, award.getAwardName());

        return new DrawResult(uid, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }

}
