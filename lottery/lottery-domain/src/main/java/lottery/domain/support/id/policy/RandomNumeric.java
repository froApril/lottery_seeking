package lottery.domain.support.id.policy;

import lottery.domain.support.id.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/24
 */
@Component
public class RandomNumeric implements IIdGenerator {
    @Override
    public Long nextId() {
        return  Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
