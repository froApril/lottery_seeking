package lottery.infrastructure.dao.user;

import lottery.infrastructure.po.user.UserTakeActivity;
import lottery.domain.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */

@Mapper
public interface IUserTakeActivityDao {

    /**
     * 插入用户领取活动信息
     *
     * @param userTakeActivity 入参
     */
    @DBRouter(key = "uId")
    void insert(UserTakeActivity userTakeActivity);

}