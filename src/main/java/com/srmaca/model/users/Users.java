package com.srmaca.model.users;

import java.util.ArrayList;
import java.util.List;
import com.srmaca.model.admin.Roles;
import com.srmaca.model.ecommerce.Order;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users", schema = "admin")
public class Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    
    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id_user"), inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id_role"))
    private List<Roles> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}