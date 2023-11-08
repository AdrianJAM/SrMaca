package com.srmaca.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.srmaca.model.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    //Metodo para buscar por nombre
    Optional<User> findByUsername(String username);
    //Metodo para buscar por ID
    Optional<User> findByidUser(Long idUser);
    //Metodo para obtener todos los usuarios
    List<User> findAll();
    //Borrar usuario
    void deleteByidUser(Long idUser);
    //Verificar si un usuario ya existe
    boolean existsByUsername(String username);
}