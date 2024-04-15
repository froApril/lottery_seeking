package lottery.domain.award.service.goods;

import lottery.domain.award.model.req.GoodsReq;
import lottery.domain.award.model.res.DistributionRes;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/15
 */
public interface IDistributionGoods {

    DistributionRes doDistribution(GoodsReq goodsReq);

    Integer getDistributionGoodsName();

}
