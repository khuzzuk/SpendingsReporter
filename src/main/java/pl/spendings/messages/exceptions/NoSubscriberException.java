package pl.spendings.messages.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoSubscriberException extends Exception {

    public NoSubscriberException(String message) {
        super(message);
    }
}
