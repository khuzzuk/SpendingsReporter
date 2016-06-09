package pl.spendings.messages;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class ChannelConfiguration {
    @Bean
    public BlockingQueue<@Message Object> configureChannelQueue(){
        return new LinkedBlockingQueue<>();
    }
}
