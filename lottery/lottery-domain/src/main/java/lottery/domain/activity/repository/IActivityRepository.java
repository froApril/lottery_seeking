package lottery.domain.activity.repository;

import lottery.common.Constants;
import lottery.domain.activity.model.req.PartakeReq;
import lottery.domain.activity.model.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/18
 */

public interface IActivityRepository {

    void addActivity(ActivityVO activity);

    void addAward(List<AwardVO> awardVOList);

    void addStrategy(StrategyVO strategyVO);

    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailVOList);

    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> before, Enum<Constants.ActivityState> after);

    ActivityBillVO queryActivityBill(PartakeReq req);

    int subtractionActivityStock(Long activityId);
}
