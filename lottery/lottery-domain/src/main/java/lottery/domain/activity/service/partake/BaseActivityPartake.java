package lottery.domain.activity.service.partake;

import lottery.common.Constants;
import lottery.common.Result;
import lottery.domain.activity.model.req.PartakeReq;
import lottery.domain.activity.model.res.PartakeResult;
import lottery.domain.activity.model.vo.ActivityBillVO;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */
public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake {
    @Override
    public PartakeResult doPartake(PartakeReq req) {
        ActivityBillVO activityBillVO = super.queryActivityBill(req);

        Result checkResult = this.checkActivityBill(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(checkResult.getCode())) {
            return new PartakeResult(checkResult.getCode(), checkResult.getInfo());
        }

        Result substractionActivityResult = this.subtractionActivityStock(req);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(substractionActivityResult.getCode())) {
            return new PartakeResult(checkResult.getCode(), substractionActivityResult.getInfo());
        }

        Result grabResult = this.grabActivity(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(grabResult.getCode())) {
            return new PartakeResult(checkResult.getCode(), grabResult.getInfo());
        }

        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(activityBillVO.getStrategyId());
        return partakeResult;
    }


    public abstract Result checkActivityBill(PartakeReq partake, ActivityBillVO activityBill);


    protected abstract Result subtractionActivityStock(PartakeReq req);

    protected abstract Result grabActivity(PartakeReq partake, ActivityBillVO bill);

}
