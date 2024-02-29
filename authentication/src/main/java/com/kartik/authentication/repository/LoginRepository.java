package com.kartik.authentication.repository;

import com.kartik.authentication.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author {2095949}
 * @Date {02-12-2023}
 */

@Repository
public interface LoginRepository extends JpaRepository<UserDto,Integer> {
    Optional<UserDto> findByUsername(String username);

    UserDto findByUsernameAndPassword(String username , String password) throws Exception;
}
