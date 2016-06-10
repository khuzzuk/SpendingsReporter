package pl.spendings.messages;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.spendings.messages.annot.Message;
import pl.spendings.messages.exceptions.UnsopportedMessageObjectException;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Channel {
    @Autowired
    @Named("channelBlockingQueue")
    private LinkedBlockingQueue<@Message Object> channelQueue;

    @PostConstruct
    void init() {
        new Thread(new Worker()).start();
    }

    void offer(@Message Object message) {
        channelQueue.offer(message);
    }

    public void notifyMessage(Object message) {
        if (!message.getClass().isAnnotationPresent(Message.class)) throw new UnsopportedMessageObjectException();
    }

    @NoArgsConstructor
    public class Worker implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    @Message Object message = channelQueue.take();
                    notifyMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
