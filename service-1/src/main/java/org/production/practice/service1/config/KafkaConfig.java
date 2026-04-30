package org.production.practice.service1.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic reservationOrderTopic(@Value("${app.kafka.topic}") String name) {
        return TopicBuilder.name(name).build();
    }
}
