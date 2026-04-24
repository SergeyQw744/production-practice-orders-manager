package org.production.practice.service2.service;

import com.example.kafka.avro.ReservationOrderEvent;

public interface EventProcessor {
    void process(ReservationOrderEvent event);
}
