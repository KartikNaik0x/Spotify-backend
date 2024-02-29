package com.kartik.authentication.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kartik.authentication.model.UserDto;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Service;

@Service
public class UserDtoDeserializer implements Deserializer<UserDto> {

    
    @Override
    public UserDto deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        UserDto userDto = null;
        try {
            userDto = mapper.readValue(data, UserDto.class);
        } catch (Exception e) {

        }
        return userDto;
    }

}
