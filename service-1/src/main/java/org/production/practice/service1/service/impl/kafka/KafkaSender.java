package org.production.practice.service1.service.impl.kafka;

import com.example.kafka.avro.ReservationOrderEvent;

public interface KafkaSender {
    void sendReservationOrderEvent(ReservationOrderEvent event);
}
