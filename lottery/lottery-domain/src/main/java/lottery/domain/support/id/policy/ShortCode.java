package lottery.domain.support.id.policy;

import lottery.domain.support.id.IIdGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/24
 */
@Component
public class ShortCode implements IIdGenerator {
    @Override
    public synchronized Long nextId() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        //random sort year + hour + week + day + random salt
        StringBuilder sb = new StringBuilder();
        sb.append(year - 2000);
        sb.append(hour);
        sb.append(String.format("%02d", week));
        sb.append(day);
        sb.append(String.format("%03d", new Random().nextInt(1000)));

        return Long.parseLong(sb.toString());
    }
}
