package com.example.postgresql.controller;

import com.example.postgresql.request.AppUserRequestRest;
import com.example.postgresql.service.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/app-user")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping()
    public ResponseEntity<String> createAppUser(@RequestBody AppUserRequestRest request) {
        appUserService.createAppUser(request);
        return ResponseEntity.ok("Created");
    }
}
