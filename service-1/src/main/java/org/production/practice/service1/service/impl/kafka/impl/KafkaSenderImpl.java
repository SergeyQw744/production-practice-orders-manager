package org.production.practice.service1.service.impl.kafka.impl;

import com.example.kafka.avro.ReservationOrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.production.practice.service1.service.impl.kafka.KafkaSender;
import org.production.practice.service1.util.KafkaSendException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaSenderImpl implements KafkaSender {

    private final KafkaTemplate<String, ReservationOrderEvent> kafkaTemplate;

    @Value("${app.kafka.topic}")
    private final String reservationTopic;

    @Override
    public void sendReservationOrderEvent(ReservationOrderEvent event) {
        try {
            SendResult<String, ReservationOrderEvent> sendResult = kafkaTemplate.send(reservationTopic, event).get();
            log.info("Сообщение успешно отправлено topic={}, offset={}",
                    sendResult.getProducerRecord().topic(),
                    sendResult.getRecordMetadata().offset()
            );
        } catch (Exception e) {
            log.error("Ошибка при отправке информации о резервировании товара {}", event.getIdProduct());
            throw new KafkaSendException("Fail: send message about order %s to Kafka".formatted(event.getIdProduct()));
        }
    }
}
