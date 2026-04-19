package org.production.practice.service1.mapper;

import com.example.kafka.avro.ReservationOrderEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.production.practice.model.dto.OrderReservationRequest;
import org.production.practice.service1.model.Order;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    @Mapping(target = "idOrder", ignore = true)
    @Mapping(target = "dateCreate", ignore = true)
    @Mapping(target = "count", source = "count", defaultValue = "1")
    Order requestToEntity(OrderReservationRequest request);

    default ReservationOrderEvent requestToKafkaEvent(OrderReservationRequest request) {
        if (request == null) {
            return null;
        }
        return ReservationOrderEvent.newBuilder()
                .setIdProduct(request.getIdProduct())
                .setCount(request.getCount() != null ? request.getCount() : 1)
                .build();
    }
}
