package com.example.postgresql.request;
import com.example.postgresql.enums.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddAppUserDetails {

    @NotNull(message = "Id required.")
    @NotEmpty(message = "Id can not be empty.")
    private String id;
    @NotNull(message = "User full name required.")
    @NotEmpty(message = "User full name can not be empty.")
    private String userFullName;
    @NotNull(message = "User mobile number required.")
    @NotEmpty(message = "User mobile number can not be empty.")
    private String mobileNumber;
    @NotNull(message = "User gender required.")
    @NotEmpty(message = "User gender can not be empty.")
    private Gender gender;
    @NotNull(message = "User email required.")
    @NotEmpty(message = "User email can not be empty.")
    private String email;
    @NotNull(message = "User address required.")
    @NotEmpty(message = "User address can not be empty.")
    private String address;
}
