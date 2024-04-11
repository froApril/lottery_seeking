package lottery.domain.strategy.service.draw.impl;

import lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import lottery.domain.strategy.service.draw.AbstractDrawBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import com.alibaba.fastjson.JSON;



@Service("drawExec")
public class DrawExecImpl extends AbstractDrawBase {


    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> awardList = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        logger.info("start draw strategy strategyId：{}，exclude the no stock list awardList：{}", strategyId, JSON.toJSON(awardList));
        return awardList;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        // start draw
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);

        if (null == awardId) return null;

        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);

        return isSuccess ? awardId : null;

    }
}

