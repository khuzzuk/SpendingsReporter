package pl.spendings.messages;

import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import pl.spendings.AspectComponent;
import pl.spendings.messages.annot.Message;

@Aspect
@AspectComponent
@NoArgsConstructor
public class SendingAspect {
    @Autowired
    private MessageMethodProcessor processor;
    @Autowired
    private SubscriptionAspect subscriptions;
    @Autowired
    Channel channel;

    @After("execution(* pl.spendings.messages.Sender.send(..)) && args(message)")
    public void sendingMessageAdvise(@Message Object message) {
        channel.offer(message);
    }

    @Before("execution(* pl.spendings.messages.Channel.notifyMessage(..)) && args(message)")
    public void deliverMessage(Object message) {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        /*try {
            Subscribable subscriber = subscriptions.getSubscriber(message.getClass());
            Optional<Method> method = processor.getReceivingMethod(subscriber.getClass());
            if (method.isPresent()) {
                method.get().invoke(subscriber, message);
            } else {
                throw new UsupportedSubscriberException();
            }
        } catch (NoSubscriberException | UsupportedSubscriberException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }*/
    }
}
