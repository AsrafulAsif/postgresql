package com.example.postgresql.response.rest;

import com.example.postgresql.response.SimpleResponseRest;
import lombok.Data;

@Data
public class AppUserDetailsInternalResponse extends SimpleResponseRest {
    private String data;
}
