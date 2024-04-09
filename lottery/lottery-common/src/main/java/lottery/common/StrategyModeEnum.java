package lottery.common;

public enum StrategyModeEnum {

    DEFAULT_RATE_RANDOM_DRAW_ALGORITHM(1, "Always awarded, exclude the existing rate"),

    SINGLE_RATE_RANDOM_DRAW_ALGORITHM(2, "Single award rate, maybe not be rewarded");

    private int id;

    private String description;

    private StrategyModeEnum(int id, String description){
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
