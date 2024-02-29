package com.kartik.register.service;

import com.kartik.register.dto.UserDto;
import com.kartik.register.model.User;
import com.kartik.register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author {2095949}
 * @Date {29-11-2023}
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private KafkaTemplate<String,UserDto> template;


//    @Autowired
//    private UserDto userDto;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDto saveUser(User user){
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new DataIntegrityViolationException("email already exists");
        }
        if(userRepository.findByUsername(user.getUsername()) != null){
            throw new DataIntegrityViolationException("username already exists");
        }
        if(userRepository.findByMobileNumber(user.getMobileNumber()) != null){
            throw new DataIntegrityViolationException("mobile number already exists");
        }

        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        UserDto userDto=new UserDto();
        user.setPassword(encryptedPassword);
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        template.send("test-topic",userDto);
        userRepository.save(user);

        return userDto;
    }

    public User findByUsername(String username){
       return  userRepository.findByUsername(username);
    }
}
