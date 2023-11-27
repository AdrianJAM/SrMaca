package com.srmaca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.srmaca.model.users.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
    Users findByEmail(@Param("email") String email);
}