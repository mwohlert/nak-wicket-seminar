package de.nordakademie.business.message;

public class Message {

    private final String messageKey;

    public Message(final String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
