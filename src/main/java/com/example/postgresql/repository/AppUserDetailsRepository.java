package com.example.postgresql.repository;

import com.example.postgresql.entity.AppUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserDetailsRepository extends JpaRepository<AppUserDetails,Long> {
    AppUserDetails findByAppUser_Id(Long appUser_id);

}
