package org.production.practice.service2.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.production.practice.service2.model.Product;
import org.production.practice.service2.repository.ProductRepository;
import org.production.practice.service2.service.ProductCountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductCountServiceImpl implements ProductCountService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void reduceCountOfProduct(int count, String id) {
        Product product = productRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> {
                    log.error("Товар id={} не найден", id);
                    return new EntityNotFoundException("Товар не обнаружен на складе");
                });
        int reducedCount = product.getCount() - count;
        product.setCount(reducedCount);
        log.info("Количество товара id={} успешно изменено: было {}, стало {}", id, product.getCount(), reducedCount);
    }
}
