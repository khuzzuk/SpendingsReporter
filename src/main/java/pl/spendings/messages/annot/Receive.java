package pl.spendings.messages.annot;

import pl.spendings.messages.annot.Message;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Receive {
    Class<@Message ?> messageType();
}
