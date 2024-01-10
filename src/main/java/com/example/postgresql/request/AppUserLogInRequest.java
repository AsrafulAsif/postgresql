package com.example.postgresql.request;

import lombok.Data;

@Data
public class AppUserLogInRequest {
    private String userName;
    private String userPassword;
}
