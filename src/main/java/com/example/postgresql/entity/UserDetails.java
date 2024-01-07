package com.example.postgresql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_details")
public class UserDetails {
    public enum Gender{MALE,FEMALE}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_details_id")
    private Long id;

    @Column(name = "user_full_name")
    private String userFullName;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "gender")
    private Gender gender;

}
