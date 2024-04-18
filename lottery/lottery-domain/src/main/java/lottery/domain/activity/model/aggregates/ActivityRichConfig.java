package lottery.domain.activity.model.aggregates;

import lombok.Data;
import lottery.domain.activity.model.vo.ActivityVO;
import lottery.domain.activity.model.vo.AwardVO;
import lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/18
 */

@Data
public class ActivityRichConfig {

    /** 活动配置 */
    private ActivityVO activity;

    /** 策略配置(含策略明细) */
    private StrategyVO strategy;

    /** 奖品配置 */
    private List<AwardVO> awardList;

    public ActivityRichConfig() {
    }

    public ActivityRichConfig(ActivityVO activity, StrategyVO strategy, List<AwardVO> awardList) {
        this.activity = activity;
        this.strategy = strategy;
        this.awardList = awardList;
    }
}
