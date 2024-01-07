package com.example.postgresql.request;

import lombok.Data;

@Data
public class AppUserRequestRest {
    private String userName;
    private String userPassword;
}
