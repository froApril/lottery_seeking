package lottery.domain.strategy.service.draw.impl;

import lottery.domain.strategy.model.aggregates.StrategyRich;
import lottery.domain.strategy.model.req.DrawReq;
import lottery.domain.strategy.model.res.DrawResult;
import lottery.domain.strategy.model.vo.AwardRateInfo;
import lottery.domain.strategy.repository.IStrategyRepository;
import lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import lottery.domain.strategy.service.draw.DrawBase;
import lottery.domain.strategy.service.draw.IDrawExec;
import lottery.infrastructure.po.award.Award;
import lottery.infrastructure.po.strategy.Strategy;
import lottery.infrastructure.po.strategy.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DrawExecImpl extends DrawBase implements IDrawExec {


    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DrawResult doDrawExec(DrawReq req) throws Exception {

        logger.info("start the strategy for lottery, strategyId: {}", req.getStrategyId());

        // get all the config data
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        // check and init data
        checkAndInitRateData(strategy.getId(), strategy.getStrategyMode(), strategyDetailList);

        // get the strategy
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(req.getStrategyId(), new ArrayList<>());

        Award award = strategyRepository.queryAwardInfo(awardId);

        logger.info("lottery finish, userid: {}, awardId: {}, awardName: {}", req.getUid(), awardId, award.getAwardName());


        return new DrawResult(req.getUid(), req.getStrategyId(), awardId, award.getAwardName());
    }
}
