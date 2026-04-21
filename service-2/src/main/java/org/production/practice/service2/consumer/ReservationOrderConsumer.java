package org.production.practice.service2.consumer;

import com.example.kafka.avro.ReservationOrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.production.practice.service2.service.EventProcessor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReservationOrderConsumer {

    private final EventProcessor eventProcessor;

    @KafkaListener(topics = "${app.kafka.consumer.topics.reservation-topic}", groupId = "${app.kafka.consumer.group-id}")
    public void handle(
            @Payload ReservationOrderEvent event,
            @Header(KafkaHeaders.TOPIC) String topic, Acknowledgment ack
    ) {
        eventProcessor.process(event);
        ack.acknowledge();
        log.info("Сообщение получено из топика {}", topic);
    }
}
