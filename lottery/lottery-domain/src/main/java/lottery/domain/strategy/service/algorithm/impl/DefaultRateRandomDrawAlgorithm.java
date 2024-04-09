package lottery.domain.strategy.service.algorithm.impl;

import lottery.common.StrategyModeEnum;
import lottery.domain.strategy.annotation.StrategyMode;
import lottery.domain.strategy.model.vo.AwardRateInfo;
import lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Component("defaultRateRandomDrawAlgorithm")
@StrategyMode(strategyMode = StrategyModeEnum.DEFAULT_RATE_RANDOM_DRAW_ALGORITHM)
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwards) {

        BigDecimal differenceDenominator = BigDecimal.ZERO;


        List<AwardRateInfo> differentAwards = new ArrayList<>();
        List<AwardRateInfo> awardRateIntervalValList = awardRateInfoMap.get(strategyId);
        for (AwardRateInfo awardRateInfo : awardRateIntervalValList) {
            String awardId = awardRateInfo.getAwardId();
            if (excludeAwards.contains(awardId)) continue;

            differentAwards.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        if (differentAwards.isEmpty()) return "";
        if (differentAwards.size() == 1) return differentAwards.get(0).getAwardId();

        SecureRandom random = new SecureRandom();
        int randomVal = random.nextInt(100) + 1;

        String awardId = "";
        int cursorVal = 0;

        for (AwardRateInfo awardRateInfo : differentAwards) {
            int rateVal = awardRateInfo.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP)
                    .multiply(new BigDecimal(100)).intValue();

            if (randomVal <= (cursorVal + rateVal)) {
                awardId = awardRateInfo.getAwardId();
                break;
            }

            cursorVal += rateVal;
        }

        return awardId;
    }
}
