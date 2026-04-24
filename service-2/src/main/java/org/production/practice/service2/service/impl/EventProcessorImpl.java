package org.production.practice.service2.service.impl;

import com.example.kafka.avro.ReservationOrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.production.practice.service2.service.EventProcessor;
import org.production.practice.service2.service.ProductCountService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventProcessorImpl implements EventProcessor {

    private final ProductCountService productCountService;

    @Override
    public void process(ReservationOrderEvent event) {
        try {
            productCountService.reduceCountOfProduct(event.getCount(), event.getIdProduct());
        } catch (RuntimeException e){
            log.error("Ошибка при обработке сообщения");
        }
    }
}
