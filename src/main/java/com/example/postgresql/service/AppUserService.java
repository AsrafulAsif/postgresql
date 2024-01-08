package com.example.postgresql.service;

import com.example.postgresql.entity.AppUserDetails;
import com.example.postgresql.exception.BadRequestException;
import com.example.postgresql.repository.AppUserDetailsRepository;
import com.example.postgresql.repository.AppUserRepository;
import com.example.postgresql.request.AddAppUserDetails;
import com.example.postgresql.request.AppUserRequestRest;
import com.example.postgresql.entity.AppUser;
import com.example.postgresql.request.UpdateAppUserDetails;
import com.example.postgresql.request.UpdatePasswordRequest;
import com.example.postgresql.response.AppUserDetailsResponse;
import com.example.postgresql.response.rest.AppUserDetailsResponseRest;
import com.example.postgresql.util.ConvertingClass;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final AppUserDetailsRepository appUserDetailsRepository;

    public AppUserService(AppUserRepository appUserRepository, AppUserDetailsRepository appUserDetailsRepository) {
        this.appUserRepository = appUserRepository;
        this.appUserDetailsRepository = appUserDetailsRepository;
    }

    public void addAppUser(AppUserRequestRest request){
        AppUser appUser = appUserRepository.findByUserName(request.getUserName());
        if (appUser!=null) throw new BadRequestException("User already added.");
        appUser = AppUser.builder()
                .userName(request.getUserName())
                .userPassword(request.getUserPassword())
                .createdAt(new Date(System.currentTimeMillis()))
                .build();
        appUserRepository.save(appUser);
    }

    public void updatePassword(String id, UpdatePasswordRequest request){
        Optional<AppUser> appUserOptional = appUserRepository.findById(Long.valueOf(id));
        if (appUserOptional.isEmpty()) throw new BadRequestException("User not found.");
        AppUser appUser = appUserOptional.get();
        appUser.setUserPassword(request.getNewPassword());
        appUser.setUpdatedAt(new Date(System.currentTimeMillis()));
        appUserRepository.save(appUser);
    }

    public void addUserDetails(AddAppUserDetails request){
        Optional<AppUser> appUserOptional = appUserRepository.findById(Long.valueOf(request.getId()));
        if (appUserOptional.isEmpty()) throw new BadRequestException("User not found");

        AppUser appUser = appUserOptional.get();
        AppUserDetails appUserDetails = AppUserDetails.builder()
                .userFullName(request.getUserFullName())
                .mobileNumber(request.getMobileNumber())
                .gender(request.getGender().name())
                .email(request.getEmail())
                .address(request.getAddress())
                .createdAt(new Date(System.currentTimeMillis()))
                .appUser(appUser)
                .build();
        appUser.setAppUserDetails(appUserDetails);

        appUserRepository.save(appUser);
    }
    public void updateAppUserDetails(String appUserId, UpdateAppUserDetails request){
        AppUserDetails appUserDetails = appUserDetailsRepository.findByAppUser_Id(Long.valueOf(appUserId));
        if (appUserDetails == null) throw new BadRequestException("User details not found");
        appUserDetails.setUpdatedAt(new Date(System.currentTimeMillis()));
        appUserDetails.setUserFullName(request.getUserFullName() == null?appUserDetails.getUserFullName(): request.getUserFullName());
        appUserDetails.setMobileNumber(request.getMobileNumber() == null?appUserDetails.getMobileNumber(): request.getMobileNumber());
        appUserDetails.setGender(request.getGender() == null ? appUserDetails.getGender():request.getGender().name());
        appUserDetails.setEmail(request.getEmail() == null ? appUserDetails.getEmail():request.getEmail());
        appUserDetails.setAddress(request.getAddress() == null ? appUserDetails.getAddress(): request.getAddress());
        appUserDetailsRepository.save(appUserDetails);
    }

    public AppUserDetailsResponseRest getUserDetails(String appUserId){
        AppUserDetailsResponseRest response = new AppUserDetailsResponseRest();
        AppUserDetails appUserDetails = appUserDetailsRepository.findByAppUser_Id(Long.valueOf(appUserId));
        AppUserDetailsResponse appUserDetailsResponse =
                ConvertingClass.convertClass(appUserDetails,AppUserDetailsResponse.class);
        response.setAppUserDetails(appUserDetailsResponse);
        return response;
    }
}
