package lottery.domain.activity.model.vo;

import lombok.Data;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/18
 */
@Data
public class AlterStateVO {

    public Long activityId;

    private Integer beforeState;

    private Integer afterState;

    public AlterStateVO() {}

    public AlterStateVO(Long activityId, Integer beforeState, Integer afterState) {
        this.activityId = activityId;
        this.beforeState = beforeState;
        this.afterState = afterState;
    }

}
