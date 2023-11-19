package com.srmaca.repository;

import com.srmaca.model.admin.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    //Método para buscar un role por su nombre en nuestra base de datos
    Optional<Roles> findByName(String name);
}
