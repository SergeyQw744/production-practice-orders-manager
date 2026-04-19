package org.production.practice.service1.service;

import com.example.kafka.avro.ReservationOrderEvent;

public interface KafkaSender {
    void sendReservationOrderEvent(ReservationOrderEvent event);
}
