package pl.spendings.messages;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pl.spendings.messages.annot.Receive;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@NoArgsConstructor
public class MessageMethodProcessor {
    Optional<Method> getReceivingMethod(Class<?> aClass){
        Optional<Method> method = Optional.empty();
        Class<?> bClass = aClass;
        List<Method> methods;
        while (aClass != Object.class) {
            methods = Arrays.asList(aClass.getMethods());
            method = methods.stream().filter(m -> m.isAnnotationPresent(Receive.class)).findAny();
            if (method.isPresent()) break;
            aClass = aClass.getSuperclass();
        }
        return method;
    }
}
