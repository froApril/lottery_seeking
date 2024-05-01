package lottery.router;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */
public class DBRouterConfig {

    private int dbCount;

    private int tbCount;

    private String routeKey;

    public DBRouterConfig() {}

    public DBRouterConfig(int dbCount, int tbCount, String routeKey) {
        this.dbCount = dbCount;
        this.tbCount = tbCount;
        this.routeKey = routeKey;
    }

    public int getDbCount() {
        return dbCount;
    }

    public void setDbCount(int dbCount) {
        this.dbCount = dbCount;
    }

    public int getTbCount() {
        return tbCount;
    }

    public void setTbCount(int tbCount) {
        this.tbCount = tbCount;
    }

    public String getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(String routeKey) {
        this.routeKey = routeKey;
    }
}
