package lottery.domain.activity.repository;

import java.util.Date;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */
public interface IUserTakeActivityRepository {

    int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date partakeDate);


    void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId);

}
