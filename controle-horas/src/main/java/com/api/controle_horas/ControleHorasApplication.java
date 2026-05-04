package com.api.controle_horas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ControleHorasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleHorasApplication.class, args);
    }
}