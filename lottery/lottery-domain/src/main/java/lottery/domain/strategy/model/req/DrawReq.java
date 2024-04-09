package lottery.domain.strategy.model.req;

public class DrawReq {

    // user id
    private String uid;

    private Long strategyId;

    public DrawReq(){}

    public DrawReq(String uid, Long strategyId) {
        this.uid = uid;
        this.strategyId = strategyId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}
