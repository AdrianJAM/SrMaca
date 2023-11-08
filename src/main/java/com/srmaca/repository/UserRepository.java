package com.srmaca.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.srmaca.model.users.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long>{
    //Metodo para buscar por nombre
    Optional<user> findByUsername(String username);
    //Metodo para buscar por ID
    Optional<user> findByIdUser(Long id);
    //Metodo para obtener todos los usuarios
    List<user> findAll();
    //Borrar usuario
    void deleteByIdUser(Long id);
    //Verificar si un usuario ya existe
    boolean existsByUsername(String username);
}