package com.consumer.service;

import com.consumer.entity.PatientDocument;
import com.consumer.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQConsumer {

    private final PatientRepository repository;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receive(PatientDocument patient) {
//        System.out.println("Raw body: " + new String(message.getBody()));

        log.info("Received patient: {}", patient);
        repository.save(patient);
    }


}
