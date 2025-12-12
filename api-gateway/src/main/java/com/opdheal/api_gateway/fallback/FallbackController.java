package com.opdheal.api_gateway.fallback;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    
    @GetMapping("/fallback/user-service")
    public Mono<ResponseEntity<String>> userServiceFallback() {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
            .body("User service is temporarily unavailable. Please try again later."));
    }
    
    @GetMapping("/fallback/appointment-service")
    public Mono<ResponseEntity<String>> appointmentServiceFallback() {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
            .body("Appointment service is temporarily unavailable. Please try again later."));
    }
    
    @GetMapping("/fallback/medical-service")
    public Mono<ResponseEntity<String>> medicalServiceFallback() {
        return Mono.just(ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
            .body("Medical service is temporarily unavailable. Please try again later."));
    }
}