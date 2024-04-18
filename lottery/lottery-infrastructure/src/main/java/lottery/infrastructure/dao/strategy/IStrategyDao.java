package lottery.infrastructure.dao.strategy;

import lottery.infrastructure.po.strategy.Strategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStrategyDao {

    Strategy queryStrategy(Long strategyId);

    void insert(Strategy strategy);
}
