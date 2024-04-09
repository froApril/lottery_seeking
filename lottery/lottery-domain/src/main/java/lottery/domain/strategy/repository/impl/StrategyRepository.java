package lottery.domain.strategy.repository.impl;

import lottery.domain.strategy.model.aggregates.StrategyRich;
import lottery.domain.strategy.repository.IStrategyRepository;
import lottery.infrastructure.dao.award.IAwardDao;
import lottery.infrastructure.dao.strategy.IStrategyDao;
import lottery.infrastructure.dao.strategy.IStrategyDetailDao;
import lottery.infrastructure.po.award.Award;
import lottery.infrastructure.po.strategy.Strategy;
import lottery.infrastructure.po.strategy.StrategyDetail;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetail = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetail);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }
}
