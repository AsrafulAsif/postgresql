package com.example.postgresql.repository;

import com.example.postgresql.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserNameAndUserPassword(String userName,String userPassword);
}
