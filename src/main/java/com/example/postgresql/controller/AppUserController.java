package com.example.postgresql.controller;

import com.example.postgresql.request.*;
import com.example.postgresql.response.SimpleResponseRest;
import com.example.postgresql.service.AppUserService;
import com.example.postgresql.util.MakingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/app-user")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping()
    public ResponseEntity<SimpleResponseRest> addAppUser(@RequestBody AppUserRequestRest request) {
        appUserService.addAppUser(request);
        return MakingResponse.makingResponse(new SimpleResponseRest());
    }

    @PutMapping("/{userId}")
    public ResponseEntity<SimpleResponseRest> updatePassword(
            @PathVariable(name = "userId") String userId,
            @RequestBody UpdatePasswordRequest request
    ){
        appUserService.updatePassword(userId,request);
        return MakingResponse.makingResponse(new SimpleResponseRest());
    }

    @PostMapping("/add-user-details")
    public ResponseEntity<SimpleResponseRest> addUserDetails(
            @RequestBody AddAppUserDetails request
    ){
       appUserService.addUserDetails(request);
       return MakingResponse.makingResponse(new SimpleResponseRest());
    }

    @PutMapping("/details/{appUserId}")
    public ResponseEntity<SimpleResponseRest> updateAppUserDetails(
            @PathVariable(name = "appUserId") String appUserId,
            @RequestBody UpdateAppUserDetails request
            ){
        appUserService.updateAppUserDetails(appUserId,request);
        return MakingResponse.makingResponse(new SimpleResponseRest());
    }
    @GetMapping("/details")
    public ResponseEntity<SimpleResponseRest> getAppUserDetails(@RequestParam(name = "appUserId") String appUserId){
        return MakingResponse.makingResponse(appUserService.getUserDetails(appUserId));
    }

    @PostMapping("/login")
    public ResponseEntity<SimpleResponseRest>login(
            @RequestBody AppUserLogInRequest request
    ){
        return MakingResponse.makingResponse(appUserService.login(request));
    }
}
