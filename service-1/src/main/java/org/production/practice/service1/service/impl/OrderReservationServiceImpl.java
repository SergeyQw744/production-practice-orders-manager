package org.production.practice.service1.service.impl;

import com.example.kafka.avro.ReservationOrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.production.practice.model.dto.OrderReservationRequest;
import org.production.practice.model.dto.ReservationStatus;
import org.production.practice.service1.mapper.OrderMapper;
import org.production.practice.service1.model.Order;
import org.production.practice.service1.repository.OrderRepository;
import org.production.practice.service1.service.OrderReservationService;
import org.production.practice.service1.service.impl.kafka.KafkaSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderReservationServiceImpl implements OrderReservationService {

    private final OrderRepository orderRepository;
    private final KafkaSender kafkaSender;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public ReservationStatus reserveOrder(OrderReservationRequest request) {
        try {
            ReservationOrderEvent event = orderMapper.requestToKafkaEvent(request);
            kafkaSender.sendReservationOrderEvent(event);
            Order entity = orderMapper.requestToEntity(request);
            entity.setIdOrder(UUID.randomUUID());
            orderRepository.save(entity);
            log.info("Товар idProduct={}, idOrder={} был успешно зарезервирован", entity.getIdProduct(), entity.getIdOrder().toString());
            return ReservationStatus.SUCCESS;
        } catch (RuntimeException e) {
            log.error("Возникла проблема при резервировании товара idProduct={}", request.getIdProduct());
            return ReservationStatus.FAIL;
        }
    }
}
