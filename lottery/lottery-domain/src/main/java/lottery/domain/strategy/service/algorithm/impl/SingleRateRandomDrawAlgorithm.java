package lottery.domain.strategy.service.algorithm.impl;

import lottery.common.StrategyModeEnum;
import lottery.domain.strategy.annotation.StrategyMode;
import lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

@Component("singleRateRandomDrawAlgorithm")
@StrategyMode(strategyMode = StrategyModeEnum.SINGLE_RATE_RANDOM_DRAW_ALGORITHM)
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwards)  {
        String[] rateTuple = super.rateTupleMap.get(strategyId);

        if (rateTuple == null) {
            return null;
        }

        int randomVale = new SecureRandom().nextInt(100) + 1;

        int idx = super.hashIdx(randomVale);

        String awardId = rateTuple[idx];

        if (excludeAwards.contains(awardId)) {return null;}
        return awardId;
    }
}
