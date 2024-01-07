package com.example.postgresql.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimpleResponseRest {
    public String message;
    public int statusCode;
}
