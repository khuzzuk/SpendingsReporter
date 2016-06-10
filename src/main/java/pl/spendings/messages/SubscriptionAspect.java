package pl.spendings.messages;

import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import pl.spendings.AspectComponent;
import pl.spendings.messages.annot.Message;
import pl.spendings.messages.annot.Subscriber;
import pl.spendings.messages.exceptions.NoSubscriberException;

import java.util.HashMap;
import java.util.Map;

@Aspect
@AspectComponent
@NoArgsConstructor
public class SubscriptionAspect implements BeanPostProcessor {
    private Map<Class<@Message ?>, Subscribable> subscribers = new HashMap<>();

    /*@DeclareParents(value = "@pl.spendings.messages.annot.Subscriber *", defaultImpl = Subscribable.SubscribableImpl.class)
    private Subscribable subscribable;*/


    private void addSubscriber(Subscribable subscriber){
        subscribers.put(subscriber.getClass().getAnnotation(Subscriber.class).message(), subscriber);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Subscriber.class)) {
            addSubscriber((Subscribable) bean);
        }
        return bean;
    }

    public Subscribable getSubscriber(Class<?> aClass) throws NoSubscriberException {
        Subscribable subscriber = subscribers.get(aClass);
        if (subscriber==null) throw new NoSubscriberException();
        return subscriber;
    }
}
