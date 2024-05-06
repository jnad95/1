package com.adityaja.amqp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String rountingKey) {
        log.info("publishing to exchange: {} using routing key: {}. Payload: {}", exchange, rountingKey, payload);
        amqpTemplate.convertAndSend(exchange, rountingKey, payload);
        log.info("published to exchange: {} using routing key: {}. Payload: {}", exchange, rountingKey, payload);
    }
}
