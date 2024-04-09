package lottery.domain.strategy.repository;

import lottery.domain.strategy.model.aggregates.StrategyRich;
import lottery.infrastructure.po.award.Award;

public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);
}
