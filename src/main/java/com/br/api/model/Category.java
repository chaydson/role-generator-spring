package com.br.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Option> options = new ArrayList<>();
}
