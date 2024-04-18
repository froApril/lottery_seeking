package lottery.domain.strategy.service.draw;

import lottery.domain.strategy.model.aggregates.StrategyRich;
import lottery.domain.strategy.model.vo.AwardBriefVO;
import lottery.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/11
 */
public class DrawStrategySupport extends DrawConfig {


    @Resource
    protected IStrategyRepository strategyRepository;

    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    protected AwardBriefVO queryAwardInfoByAwardId(String awardId) {
        return strategyRepository.queryAwardInfo(awardId);
    }
}
