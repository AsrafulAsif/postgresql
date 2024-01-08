package com.example.postgresql.request;

import com.example.postgresql.enums.Gender;
import lombok.Data;
@Data
public class UpdateAppUserDetails {
    private String userFullName;
    private String mobileNumber;
    private Gender gender;
    private String email;
    private String address;
}
