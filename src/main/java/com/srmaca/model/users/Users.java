package com.srmaca.model.users;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")

@Entity
@Table(name = "users", schema = "admin")
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    
    private String username;

    private String password;

    private String email;
    
    private String telephone;

    private String status;

    private String role;
}