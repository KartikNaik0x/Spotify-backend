package com.kartik.authentication.kafkaconsumer;

import com.kartik.authentication.model.UserDto;
import com.kartik.authentication.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author {2095949}
 * @Date {02-12-2023}
 */

@Service
public class KafkaConsumer {

    @Autowired
    LoginRepository loginRepository;
    @KafkaListener(topics = "test-topic", containerGroup = "product-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload UserDto userDto) {
        loginRepository.save(userDto);
        System.out.println(userDto);
    }


}
