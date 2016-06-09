package pl.spendings.messages;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
public @interface Subscriber {
    @Message Class<?> message();
}
