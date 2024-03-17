package lottery.infrastructure.dao.activity;

import lottery.infrastructure.po.activity.Activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IActivityDao {
    void insert(Activity req);

    Activity queryActivityById(Long activityId);
}
