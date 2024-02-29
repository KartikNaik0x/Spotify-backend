package com.kartik.register.config;

import com.kartik.register.dto.UserDto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

/**
 * @author {2095949}
 * @Date {01-12-2023}
 */
@Service
public class KafkaProducerService {


    @Autowired
    private KafkaTemplate<String,UserDto> template;



}

