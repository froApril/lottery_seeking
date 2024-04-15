package lottery.domain.award.service.factory;

import lottery.common.Constants;
import lottery.domain.award.service.goods.IDistributionGoods;
import lottery.domain.award.service.goods.impl.CouponGoods;
import lottery.domain.award.service.goods.impl.DescGoods;
import lottery.domain.award.service.goods.impl.PhysicalGoods;
import lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/15
 */
public class GoodsConfig {

    protected static Map<Integer, IDistributionGoods> goodsMap = new HashMap<>();

    @Resource
    private DescGoods descGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @Resource
    private CouponGoods couponGoods;

    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.DESC.getCode(), physicalGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
    }

}
