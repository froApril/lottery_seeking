package lottery.domain.activity.model.res;

import lottery.common.Result;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */
public class PartakeResult extends Result {
    private Long strategyId;

    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}
