package pl.spendings.messages;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
@NoArgsConstructor
public class Channel {
    @Autowired
    private BlockingQueue<@Message Object> channel;
    private Worker worker;

    private void init() {
        worker = new Worker();
        new Thread(worker).start();
    }

    @NoArgsConstructor
    private class Worker implements Runnable {

        @Override
        public void run() {
            while (true) {
                @Message Object message = channel.poll();
                notifyMessage(message, Optional.ofNullable(message.getClass().getAnnotation(Message.class)));
            }
        }

        private void notifyMessage(@Message Object message, Optional messageAnnotation) {}
    }
}
