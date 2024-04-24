package lottery.domain;

import lottery.common.Constants;
import lottery.domain.support.id.IIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/24
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupportTest {
    private Logger logger = LoggerFactory.getLogger(SupportTest.class);

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGenerators;

    @Test
    public void test() {
        logger.info("雪花算法策略，生成ID：{}", idGenerators.get(Constants.Ids.SnowFlake).nextId());
        logger.info("日期算法策略，生成ID：{}", idGenerators.get(Constants.Ids.ShortCode).nextId());
        logger.info("随机算法策略，生成ID：{}", idGenerators.get(Constants.Ids.RandomNumeric).nextId());
    }

}
