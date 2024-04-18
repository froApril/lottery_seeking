package lottery.domain.activity.service.deploy.impl;

import lottery.domain.activity.model.aggregates.ActivityRichConfig;
import lottery.domain.activity.model.req.ActivityConfigReq;
import lottery.domain.activity.model.vo.ActivityVO;
import lottery.domain.activity.model.vo.AwardVO;
import lottery.domain.activity.model.vo.StrategyDetailVO;
import lottery.domain.activity.model.vo.StrategyVO;
import lottery.domain.activity.repository.IActivityRepository;
import lottery.domain.activity.service.deploy.IActivityDeploy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/18
 */
@Service
public class ActivityDeployImpl implements IActivityDeploy {

    Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq activityConfigReq) {
        logger.info("ActivityDeployImpl createActivity start, activityId: {}", activityConfigReq.getActivityId());
        ActivityRichConfig activityRichConfig = activityConfigReq.getActivityRichConfig();
        try {
            // add activity config
            ActivityVO activityVO = activityRichConfig.getActivity();
            activityRepository.addActivity(activityVO);

            // add award
            List<AwardVO> awardVOList = activityRichConfig.getAwardList();
            activityRepository.addAward(awardVOList);

            // add strategy
            StrategyVO strategyVO = activityRichConfig.getStrategy();
            activityRepository.addStrategy(strategyVO);

            // add detail list
            List<StrategyDetailVO> strategyDetailVOList = activityRichConfig.getStrategy().getStrategyDetailList();
            activityRepository.addStrategyDetailList(strategyDetailVOList);

            logger.info("ActivityDeployImpl createActivity end, activityId: {}", activityConfigReq.getActivityId());

        }catch (DuplicateKeyException e) {
            logger.error("create activity config fail, activityId: {}", activityConfigReq.getActivityId());
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq activityConfigReq) {
        // todo
    }
}
