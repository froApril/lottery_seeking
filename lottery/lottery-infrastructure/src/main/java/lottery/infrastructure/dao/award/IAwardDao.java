package lottery.infrastructure.dao.award;

import lottery.infrastructure.po.award.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IAwardDao {
    Award queryAwardInfo(String awardId);

    void insertList(List<Award> list);
}
