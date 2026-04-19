package org.production.practice.service1.service;

import org.production.practice.model.dto.OrderReservationRequest;
import org.production.practice.model.dto.ReservationStatus;

public interface OrderReservationService {
    ReservationStatus reserveOrder(OrderReservationRequest request);
}
