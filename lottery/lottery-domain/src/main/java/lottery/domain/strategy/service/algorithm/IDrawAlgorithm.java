package lottery.domain.strategy.service.algorithm;

import lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

public interface IDrawAlgorithm {


    /**
     * init the rate tuple, which makes the tuple data like (0.2, 0.3, 0.5) distributed into
     * a single area:
     * 0.2 = (0, 0.2]
     * 0.3 = (0.2, 0.5]
     * 0.5 = (0.5, 1]
     *
     * so that with the random value for the award rate, we can get the award name within O(1)
     */
    void initRateTuple(Long strategyId, Integer strategyMode, List<AwardRateInfo> awardRateInfoList);

    String randomDraw(Long strategyId, List<String> excludeAwards);

    boolean isExistRateTuple(Long strategyId);
}
