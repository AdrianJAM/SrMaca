package com.srmaca.model.users;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class user {
    private Long id_user;
    private String name;
    private String mail;
}
