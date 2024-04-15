package lottery.domain.award.service.goods;

import lottery.domain.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @description: Inside this class, user data and info will be updated
 * @author：freddie
 * @date: 2024/4/15
 */
public class DistributionBase {

    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo) {
        logger.info("Todo, add into the database, user personal draw table award stats uid : {}", uId);
    }
}
