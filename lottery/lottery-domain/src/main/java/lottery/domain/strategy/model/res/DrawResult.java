package lottery.domain.strategy.model.res;

import lottery.common.Constants;
import lottery.domain.strategy.model.vo.DrawAwardInfo;

public class DrawResult {

    private String uId;

    private Long strategyId;

    private Integer drawState = Constants.DrawState.FAIL.getCode();

    private DrawAwardInfo drawAwardInfo;

    public DrawResult(String uid, Long strategyId, int code) {
    }

    public DrawResult(String uId, Long strategyId, Integer drawState, DrawAwardInfo drawAwardInfo) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardInfo = drawAwardInfo;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getDrawState() {
        return drawState;
    }

    public void setDrawState(Integer drawState) {
        this.drawState = drawState;
    }

    public DrawAwardInfo getDrawAwardInfo() {
        return drawAwardInfo;
    }

    public void setDrawAwardInfo(DrawAwardInfo drawAwardInfo) {
        this.drawAwardInfo = drawAwardInfo;
    }

    @Override
    public String toString() {
        return "DrawResult{" +
                "uId='" + uId + '\'' +
                ", strategyId=" + strategyId +
                ", drawState=" + drawState +
                ", drawAwardInfo=" + drawAwardInfo +
                '}';
    }
}
