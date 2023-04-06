package com.assoc.hypers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @NotBlank
    @Size(max = 50)
    private String roleName;

    @NotBlank
    @Size(max = 50)
    private String roleDescription;

}
