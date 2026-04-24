package org.production.practice.service2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "id_product", length = 255, nullable = false)
    private UUID idProduct;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(nullable = false)
    private int count;

    @Column(name = "date_time_last_change")
    @UpdateTimestamp
    private LocalDateTime dateTimeLastChange;
}
