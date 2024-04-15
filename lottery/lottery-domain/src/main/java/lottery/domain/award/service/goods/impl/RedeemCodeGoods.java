package lottery.domain.award.service.goods.impl;

import lottery.common.Constants;
import lottery.domain.award.model.req.GoodsReq;
import lottery.domain.award.model.res.DistributionRes;
import lottery.domain.award.service.goods.DistributionBase;
import lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/15
 */
@Component
public class RedeemCodeGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq goodsReq) {

        // simulate the interface
        logger.info("simulate redeemCodeGoods: uId: {}, awardContent： {}", goodsReq.getUId(), goodsReq.getAwardContent());

        super.updateUserAwardState(goodsReq.getUId(), goodsReq.getOrderId(), goodsReq.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(goodsReq.getUId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.RedeemCodeGoods.getCode();
    }
}
