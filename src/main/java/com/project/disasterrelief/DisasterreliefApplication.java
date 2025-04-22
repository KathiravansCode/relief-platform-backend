package com.project.disasterrelief;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Encoders;

import javax.crypto.SecretKey;
@SpringBootApplication
public class DisasterreliefApplication {

	public static void main(String[] args) {

		SpringApplication.run(DisasterreliefApplication.class, args);

	}

}
