package com.br.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Collection<Category> categories;

    public AppUser(Long id,String name, String username, String email, String password){
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
