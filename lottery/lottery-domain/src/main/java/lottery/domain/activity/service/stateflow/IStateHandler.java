package lottery.domain.activity.service.stateflow;

import lottery.common.Constants;
import lottery.common.Result;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/18
 */
public interface IStateHandler {

    Result arraignment(Long activityId, Enum<Constants.ActivityState> currentStatus);

    Result checkPass(Long activityId, Enum<Constants.ActivityState> currentStatus);

    Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentStatus);

    Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentStatus);

    Result close(Long activityId, Enum<Constants.ActivityState> currentStatus);

    Result open(Long activityId, Enum<Constants.ActivityState> currentStatus);

    Result doing(Long activityId, Enum<Constants.ActivityState> currentStatus);

}
