package lottery.domain.strategy.model.vo;

import lombok.Data;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/11
 */
@Data
public class DrawAwardInfo {

    private String awardId;

    private Integer awardType;

    private String awardName;

    private String awardContent;


    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String awardId, Integer awardType, String awardName,String awardContent) {
        this.awardId = awardId;
        this.awardType = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }
}
