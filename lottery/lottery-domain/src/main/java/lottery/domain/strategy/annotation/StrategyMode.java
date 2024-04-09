package lottery.domain.strategy.annotation;

import lottery.common.StrategyModeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategyMode {

    StrategyModeEnum strategyMode();
}
