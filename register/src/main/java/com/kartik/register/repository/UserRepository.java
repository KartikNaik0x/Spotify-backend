package com.kartik.register.repository;

import com.kartik.register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author {2095949}
 * @Date {29-11-2023}
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByMobileNumber(String mobileNo);
}
