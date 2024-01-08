package com.example.postgresql.request;

import lombok.Data;

@Data
public class UpdatePasswordRequest {
    private String newPassword;
}
