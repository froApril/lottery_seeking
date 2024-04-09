package lottery.infrastructure.dao.strategy;

import lottery.infrastructure.po.strategy.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyDetailDao {
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);
}
