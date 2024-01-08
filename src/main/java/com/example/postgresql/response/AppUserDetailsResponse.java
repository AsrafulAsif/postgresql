package com.example.postgresql.response;


import lombok.Data;


@Data
public class AppUserDetailsResponse {
    private String userFullName;
    private String mobileNumber;
    private String gender;
    private String email;
    private String address;
}
