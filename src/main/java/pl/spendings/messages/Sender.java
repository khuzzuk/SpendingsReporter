package pl.spendings.messages;

import org.springframework.stereotype.Component;
import pl.spendings.messages.annot.Message;

@Component
public class Sender {
    @Message
    public Object send(@Message Object object){
        return object;
    }
}
