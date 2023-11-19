package com.srmaca.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.srmaca.model.users.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
    //Metodo para buscar por nombre
    Optional<Users> findByUsername(String username);
    //Verificar si un usuario ya existe
    boolean existsByUsername(String username);
}