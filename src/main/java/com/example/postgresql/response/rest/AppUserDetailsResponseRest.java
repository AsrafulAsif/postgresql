package com.example.postgresql.response.rest;

import com.example.postgresql.response.AppUserDetailsResponse;
import com.example.postgresql.response.SimpleResponseRest;
import lombok.Data;

@Data
public class AppUserDetailsResponseRest extends SimpleResponseRest {
    private AppUserDetailsResponse appUserDetails;
}
