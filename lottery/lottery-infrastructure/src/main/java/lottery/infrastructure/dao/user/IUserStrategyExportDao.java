package lottery.infrastructure.dao.user;


import lottery.domain.router.annotation.DBRouter;
import lottery.domain.router.annotation.DBRouterStrategy;
import lottery.infrastructure.po.user.UserStrategyExport;

import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {

    /**
     * 新增数据
     * @param userStrategyExport 用户策略
     */
    @DBRouter(key = "uId")
    void insert(UserStrategyExport userStrategyExport);

    /**
     * 查询数据
     * @param uId 用户ID
     * @return 用户策略
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);

}