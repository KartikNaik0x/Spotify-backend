package com.kartik.wishlist.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author {2095949}
 * @Date {06-12-2023}
 */

@FeignClient(name="auth-service",url="http://localhost:8086/auth")
public interface AuthClient {
    @GetMapping("/validateToken")
    public boolean validateUser(@RequestHeader("Authorization") String token);

}
