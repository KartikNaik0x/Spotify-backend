package com.kartik.config;

import io.jsonwebtoken.Jwts;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author {2095949}
 * @Date {11-12-2023}
 */
public class CustomGlobalFilter extends AbstractGatewayFilterFactory<Object> implements GlobalFilter{

    // Define paths that should be excluded from token validation
    private static final List<String> EXCLUDED_PATHS = Arrays.asList("/auth/**", "/user/**");

    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    String SECRET_KEY = "jlkdfjoeijfwkmkgiworgjijijvs94489eifjkdvdkksdmvkd";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getPath().value();
        // Exclude paths from validation
        if (shouldExcludePath(path)) {
            System.out.println("excluded");
            return chain.filter(exchange);
        }
        String token = extractToken(exchange.getRequest().getHeaders());
        System.out.println("token is"+token);
        // Perform token validation logic here (e.g., validate JWT token)
        if (token!= null && isValidToken(token)) {
            return chain.filter(exchange);
        } else {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }
    private String extractToken(HttpHeaders headers) {
        return headers.getFirst("Authorization");
    }
    private boolean isValidToken(String token) {
        String authToken = token.substring(7,token.length());
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(authToken).getBody();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private boolean shouldExcludePath(String path) {
        // Check if the path should be excluded from token validation
        return EXCLUDED_PATHS.stream().anyMatch(pattern -> pathMatcher.match(pattern, path));
    }

    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }
}
