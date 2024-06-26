package lottery.domain.strategy.service.algorithm;

import lottery.common.Constants;
import lottery.domain.strategy.model.vo.AwardRateInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseAlgorithm implements IDrawAlgorithm{

    private final int HASH_INCREMENT = 0x61c88647;

    private final int RATE_TUPLE_LENGTH = 128;

    protected Map<Long, String[]> rateTupleMap = new ConcurrentHashMap<>();

    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();

    /**
     * Init the awardRateInfoMap
     * @param strategyId
     * @param awardRateInfoList
     */
    private void initAwardRateInfoMap(Long strategyId, List<AwardRateInfo> awardRateInfoList) {
        awardRateInfoMap.put(strategyId, awardRateInfoList);
    }

    @Override
    public void initRateTuple(Long strategyId, Integer strategyMode, List<AwardRateInfo> awardRateInfoList) {

        // whatever which strategy is used, the awards info and rates needs to be initialized
        initAwardRateInfoMap(strategyId, awardRateInfoList);

        // only single strategy needs a fibonacci hash
        if (strategyMode.equals(Constants.Strategy.SINGLE.getCode())) return;

        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, k -> new String[RATE_TUPLE_LENGTH]);

        int cursorVal = 0;
        for (AwardRateInfo awardRateInfo : awardRateInfoList) {
            int rateVal = awardRateInfo.getAwardRate().multiply(new BigDecimal(100)).intValue();
            for (int i = cursorVal; i <= (rateVal + cursorVal); i++) {
                rateTuple[hashIdx(i)] = awardRateInfo.getAwardId();
            }
            cursorVal += rateVal;
        }

    }

    protected int hashIdx(int val) {
        int hashCode = val * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGTH - 1);
    }

    @Override
    public boolean isExistRateTuple(Long strategyId) {
        return rateTupleMap.containsKey(strategyId);
    }
}
