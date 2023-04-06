package com.assoc.hypers.entity;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @NotBlank
    @Size(max = 20)
    private String userName;

    @NotBlank
    @Size(max = 50)
    private String userFirstName;

    @NotBlank
    @Size(max = 50)
    private String userLastName;

    @NotBlank
    @Size(max = 120)
    private String userPassword;


    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();


}
