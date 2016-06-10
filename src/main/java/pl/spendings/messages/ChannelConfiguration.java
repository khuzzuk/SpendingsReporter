package pl.spendings.messages;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.spendings.messages.annot.Message;

import java.util.concurrent.LinkedBlockingQueue;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ChannelConfiguration {
    @Bean(name = "channelBlockingQueue")
    public LinkedBlockingQueue<@Message Object> configureChannelQueue(){
        return new LinkedBlockingQueue<>();
    }
}
