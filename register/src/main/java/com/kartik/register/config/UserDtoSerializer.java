package com.kartik.register.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kartik.register.dto.UserDto;
import org.apache.kafka.common.serialization.Serializer;

public class UserDtoSerializer implements Serializer<UserDto> {

    @Override
    public byte[] serialize(String arg0, UserDto arg1) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(arg1).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

}

