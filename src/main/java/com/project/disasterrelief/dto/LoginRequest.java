package com.project.disasterrelief.dto;



import lombok.Data;

@Data
public class LoginRequest {
    private String usernameOrEmail;
    private String password;
}
