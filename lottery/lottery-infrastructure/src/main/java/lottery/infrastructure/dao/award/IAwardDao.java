package lottery.infrastructure.dao.award;

import lottery.infrastructure.po.award.Award;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAwardDao {
    Award queryAwardInfo(String awardId);
}
