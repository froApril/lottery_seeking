package lottery.router.annotation;

import java.lang.annotation.*;

/**
 * @description:
 * @author：freddie
 * @date: 2024/4/26
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DBRouter {

    String key() default "";
}
