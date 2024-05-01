package lottery.domain.router.strategy;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */
public interface IDBRouterStrategy {

    void doRouter(String dbKeyAttr);

    void setDBKey(int dbIdx);

    void setTBKey(int tbIdx);

    int dbCount();

    int tbCount();

    void clear();

}
