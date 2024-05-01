package lottery.router.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author：freddie
 * @date: 2024/5/1
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DBRouterStrategy {
    boolean splitTable() default false;
}
