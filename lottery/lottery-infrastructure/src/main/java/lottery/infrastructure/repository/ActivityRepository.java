package lottery.infrastructure.repository;

import lottery.common.Constants;
import lottery.domain.activity.model.req.PartakeReq;
import lottery.domain.activity.model.vo.*;
import lottery.domain.activity.repository.IActivityRepository;
import lottery.infrastructure.dao.activity.IActivityDao;
import lottery.infrastructure.dao.award.IAwardDao;
import lottery.infrastructure.dao.strategy.IStrategyDao;
import lottery.infrastructure.dao.strategy.IStrategyDetailDao;
import lottery.infrastructure.dao.user.IUserTakeActivityCountDao;
import lottery.infrastructure.po.activity.Activity;
import lottery.infrastructure.po.award.Award;
import lottery.infrastructure.po.strategy.Strategy;
import lottery.infrastructure.po.strategy.StrategyDetail;
import lottery.infrastructure.po.user.UserTakeActivityCount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/18
 */
@Component
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;

    @Resource
    private IAwardDao awardDao;

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IUserTakeActivityCountDao userTakeActivityCountDao;


    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardVOList) {
        List<Award> awards = new ArrayList<Award>();
        for (AwardVO awardVO : awardVOList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            awards.add(award);
        }
        awardDao.insertList(awards);
    }

    @Override
    public void addStrategy(StrategyVO strategyVO) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategyVO, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailVOList) {
        List<StrategyDetail> strategyDetails = new ArrayList<StrategyDetail>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailVOList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            strategyDetails.add(strategyDetail);
        }
        strategyDetailDao.insertList(strategyDetails);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> before, Enum<Constants.ActivityState> after) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId,
                                                    ((Constants.ActivityState) before).getCode(),
                                                    ((Constants.ActivityState) after).getCode());

        return 1 == activityDao.alterState(alterStateVO);
    }

    @Override
    public ActivityBillVO queryActivityBill(PartakeReq req) {
        // 查询活动信息
        Activity activity = activityDao.queryActivityById(req.getActivityId());

        // 查询领取次数
        UserTakeActivityCount userTakeActivityCountReq = new UserTakeActivityCount();
        userTakeActivityCountReq.setUId(req.getuId());
        userTakeActivityCountReq.setActivityId(req.getActivityId());
        UserTakeActivityCount userTakeActivityCount = userTakeActivityCountDao.queryUserTakeActivityCount(userTakeActivityCountReq);

        // 封装结果信息
        ActivityBillVO activityBillVO = new ActivityBillVO();
        activityBillVO.setUId(req.getuId());
        activityBillVO.setActivityId(req.getActivityId());
        activityBillVO.setActivityName(activity.getActivityName());
        activityBillVO.setBeginDateTime(activity.getBeginDateTime());
        activityBillVO.setEndDateTime(activity.getEndDateTime());
        activityBillVO.setTakeCount(activity.getTakeCount());
        activityBillVO.setStockSurplusCount(activity.getStockSurplusCount());
        activityBillVO.setStrategyId(activity.getStrategyId());
        activityBillVO.setState(activity.getState());
        activityBillVO.setUserTakeLeftCount(null == userTakeActivityCount ? null : userTakeActivityCount.getLeftCount());

        return activityBillVO;
    }

    @Override
    public int subtractionActivityStock(Long activityId) {
        return activityDao.subtractionActivityStock(activityId);
    }
}
