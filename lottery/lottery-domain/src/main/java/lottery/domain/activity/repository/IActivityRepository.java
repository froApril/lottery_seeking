package lottery.domain.activity.repository;

import lottery.common.Constants;
import lottery.domain.activity.model.vo.ActivityVO;
import lottery.domain.activity.model.vo.AwardVO;
import lottery.domain.activity.model.vo.StrategyDetailVO;
import lottery.domain.activity.model.vo.StrategyVO;
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
}
