package lottery.infrastructure.dao.user;

import lottery.domain.router.annotation.DBRouter;
import lottery.infrastructure.po.user.UserTakeActivityCount;
//import lottery.domain.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */
@Mapper
public interface IUserTakeActivityCountDao {

    @DBRouter
    UserTakeActivityCount queryUserTakeActivityCount(UserTakeActivityCount userTackActivityCount);

    void insert(UserTakeActivityCount userTackActivityCount);

    int updateLeftCount(UserTakeActivityCount userTackActivityCount);
}
