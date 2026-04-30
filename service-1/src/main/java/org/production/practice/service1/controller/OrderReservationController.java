package org.production.practice.service1.controller;

import lombok.RequiredArgsConstructor;
import org.production.practice.model.dto.OrderReservationRequest;
import org.production.practice.model.dto.ReservationStatus;
import org.production.practice.service1.service.OrderReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders/reservation")
@RequiredArgsConstructor
public class OrderReservationController {

    private final OrderReservationService orderReservationService;

    @PostMapping
    public ReservationStatus orderReserve(@RequestBody OrderReservationRequest request) {
        return orderReservationService.reserveOrder(request);
    }
}
