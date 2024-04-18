package lottery.domain.activity.model.req;

import lombok.Data;
import lottery.domain.activity.model.aggregates.ActivityRichConfig;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/18
 */

@Data
public class ActivityConfigReq {
    /** 活动ID */
    private Long activityId;

    /** 活动配置信息 */
    private ActivityRichConfig activityRichConfig;

    public ActivityConfigReq() {
    }

    public ActivityConfigReq(Long activityId, ActivityRichConfig activityRichConfig) {
        this.activityId = activityId;
        this.activityRichConfig = activityRichConfig;
    }
}
