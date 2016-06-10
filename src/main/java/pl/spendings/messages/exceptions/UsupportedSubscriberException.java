package pl.spendings.messages.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsupportedSubscriberException extends Exception {
    public UsupportedSubscriberException(String message) {
        super(message);
    }
}
