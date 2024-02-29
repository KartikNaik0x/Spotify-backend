package com.kartik.authentication.service;


import com.kartik.authentication.model.LoginRequest;
import com.kartik.authentication.model.UserDto;
import com.kartik.authentication.repository.LoginRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author {2095949}
 * @Date {02-12-2023}
 */

@Service
public class LoginServiceImpl implements LoginService {
    String SECRET_KEY = "jlkdfjoeijfwkmkgiworgjijijvs94489eifjkdvdkksdmvkd";

    private final LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRegistration) {
        this.loginRepository = loginRegistration;

    }


    public Optional<UserDto> findByUsername(String username) {
        return loginRepository.findByUsername(username);
    }

    // token generation
    public Map<String, String> generateToken(LoginRequest loginRequest) {
        Map<String, String> jwtTokenMap = new HashMap<>();
        Map<String, Object> claims = new HashMap<>();
        String token = Jwts.builder().setClaims(claims).setSubject(loginRequest.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))// token for 60 min
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        jwtTokenMap.put("token", token);
        jwtTokenMap.put("message", "Login Successful");
        return jwtTokenMap;
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final var claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
