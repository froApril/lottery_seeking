package lottery.rpc.req;

import java.io.Serializable;

public class ActivityReq implements Serializable {
    private long activityId;

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }
}
