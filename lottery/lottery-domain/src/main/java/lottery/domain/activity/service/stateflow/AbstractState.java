package lottery.domain.activity.service.stateflow;

import lottery.common.Constants;
import lottery.common.Result;
import lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/18
 */
public abstract class AbstractState {

    @Resource
    protected IActivityRepository activityRepository;

    public abstract Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result close(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result open(Long activityId, Enum<Constants.ActivityState> currentState);

    public abstract Result doing(Long activityId, Enum<Constants.ActivityState> currentState);

}
