package lottery.domain.activity.service.partake;

import lottery.domain.activity.model.req.PartakeReq;
import lottery.domain.activity.model.vo.ActivityBillVO;
import lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req) {return activityRepository.queryActivityBill(req);}
}
