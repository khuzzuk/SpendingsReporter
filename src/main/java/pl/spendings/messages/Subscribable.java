package pl.spendings.messages;

import pl.spendings.messages.annot.Subscriber;

import javax.annotation.PostConstruct;

@Subscriber(message = Object.class)
public interface Subscribable {
    @PostConstruct
    void subscribe();
    class SubscribableImpl implements Subscribable {

        @Override
        public void subscribe() {
        }
    }
}
