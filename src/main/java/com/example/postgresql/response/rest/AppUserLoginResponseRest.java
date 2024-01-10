package com.example.postgresql.response.rest;

import com.example.postgresql.response.AppUserLoginResponse;
import com.example.postgresql.response.SimpleResponseRest;
import lombok.Data;

@Data
public class AppUserLoginResponseRest extends SimpleResponseRest {
    private AppUserLoginResponse tokenData;
}
