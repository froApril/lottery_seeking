package lottery.domain.activity.service.deploy;

import lottery.domain.activity.model.aggregates.ActivityRichConfig;
import lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/18
 */

public interface IActivityDeploy {

    void createActivity(ActivityConfigReq activityConfigReq);


    void updateActivity(ActivityConfigReq activityConfigReq);
}
