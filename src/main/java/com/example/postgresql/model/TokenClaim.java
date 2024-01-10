package com.example.postgresql.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenClaim {
    private String userName;
    private String mobileName;
    private String gender;
}
