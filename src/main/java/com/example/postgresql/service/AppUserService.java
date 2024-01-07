package com.example.postgresql.service;

import com.example.postgresql.repository.AppUserRepository;
import com.example.postgresql.request.AppUserRequestRest;
import com.example.postgresql.entity.AppUser;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public void createAppUser(AppUserRequestRest request){
        AppUser appUser = AppUser.builder()
                .userName(request.getUserName())
                .userPassword(request.getUserPassword())
                .createdAt(new Date(System.currentTimeMillis()))
                .build();
        appUserRepository.save(appUser);
    }
}
