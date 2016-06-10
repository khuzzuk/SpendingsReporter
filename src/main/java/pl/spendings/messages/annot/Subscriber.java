package pl.spendings.messages.annot;

import pl.spendings.messages.annot.Message;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Subscriber {
    @Message Class<?> message();
}
