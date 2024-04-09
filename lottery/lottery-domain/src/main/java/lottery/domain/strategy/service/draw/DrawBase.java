package lottery.domain.strategy.service.draw;

import lottery.domain.strategy.model.vo.AwardRateInfo;
import lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import lottery.infrastructure.po.strategy.StrategyDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DrawBase extends DrawConfig {

    private final Logger logger = LoggerFactory.getLogger(DrawBase.class);

    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetails) {

        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        boolean exists = drawAlgorithm.isExistRateTuple(strategyId);
        if (!exists) {
            logger.info("Strategy mode not exist");
            return;
        }

        List<AwardRateInfo> awardRateInfoList = new ArrayList<AwardRateInfo>();
        for (StrategyDetail strategyDetail : strategyDetails) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);

    }

}
