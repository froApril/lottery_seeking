package lottery.interfaces.daoTests;


import lottery.infrastructure.dao.award.IAwardDao;
import lottery.infrastructure.dao.strategy.IStrategyDao;
import lottery.infrastructure.dao.strategy.IStrategyDetailDao;
import lottery.infrastructure.po.award.Award;
import lottery.infrastructure.po.strategy.Strategy;
import lottery.infrastructure.po.strategy.StrategyDetail;
import lottery.interfaces.test.ApiTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    IAwardDao awardDao;

    @Resource
    IStrategyDao strategyDao;

    @Resource
    IStrategyDetailDao strategyDetailDao;

    @Test
    public void test_getAward() {

        // pre insert a data into database with
        // 	1	10000	1	1	IPhone	IPhone	2024-04-08 00:00:00	2024-04-08 00:00:00
        Award res = awardDao.queryAwardInfo("1");
        logger.info(res.toString());
        assertNotNull(res);
        assertEquals(res.getId(), 1);
    }

    @Test
    public void test_getStrategy() {

        Strategy strategy = strategyDao.queryStrategy(10000L);
        logger.info(strategy.toString());
        assertNotNull(strategy);
        assertEquals(strategy.getId(), 1);
    }

    @Test
    public void test_getStrategyDetail() {

        List<StrategyDetail> strategyDetail = strategyDetailDao.queryStrategyDetailList(10000L);
        String res = strategyDetail.stream().map(n -> strategyDetail.toString()).collect(Collectors.joining("\n"));
        logger.info(res);
        assertEquals(strategyDetail.size(), 2);
    }

}
