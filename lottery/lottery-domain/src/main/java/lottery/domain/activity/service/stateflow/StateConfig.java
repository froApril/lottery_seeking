package lottery.domain.activity.service.stateflow;

import lottery.common.Constants;
import lottery.domain.activity.service.stateflow.event.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/18
 */
public class StateConfig {

    @Resource
    private ArraignmentState arraignmentState;

    @Resource
    private CloseState closeState;

    @Resource
    private DoingState doingState;

    @Resource
    private EditingState editingState;

    @Resource
    private OpenState openState;

    @Resource
    private PassState passState;

    @Resource
    private RefuseState refuseState;

    protected Map<Enum<Constants.ActivityState>, AbstractState>stateGroup = new HashMap<Enum<Constants.ActivityState>, AbstractState>();

    @PostConstruct
    public void init(){
        stateGroup.put(Constants.ActivityState.ARRAIGNMENT, arraignmentState);
        stateGroup.put(Constants.ActivityState.CLOSE, closeState);
        stateGroup.put(Constants.ActivityState.DOING, doingState);
        stateGroup.put(Constants.ActivityState.EDIT, editingState);
        stateGroup.put(Constants.ActivityState.OPEN, openState);
        stateGroup.put(Constants.ActivityState.PASS, passState);
        stateGroup.put(Constants.ActivityState.REFUSE, refuseState);
    }
}
