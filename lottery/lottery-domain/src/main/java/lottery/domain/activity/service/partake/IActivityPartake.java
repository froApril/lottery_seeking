package lottery.domain.activity.service.partake;

import lottery.domain.activity.model.req.PartakeReq;
import lottery.domain.activity.model.res.PartakeResult;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */
public interface IActivityPartake {

    PartakeResult doPartake(PartakeReq req);
}
