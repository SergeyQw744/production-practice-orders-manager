package org.production.practice.service1.util;

public class KafkaSendException extends RuntimeException {
    public KafkaSendException(String message) {
        super(message);
    }
}
