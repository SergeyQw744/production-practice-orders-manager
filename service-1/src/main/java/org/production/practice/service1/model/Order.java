package org.production.practice.service1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "id_order")
    private UUID idOrder;

    @Column(name = "id_product", length = 255, nullable = false)
    private String idProduct;

    @Column(nullable = false)
    private int count;

    @Column(name = "id_user", length = 255, nullable = false)
    private String idUser;

    @Column(name = "date_create")
    @CreationTimestamp
    private LocalDateTime dateCreate;
}
