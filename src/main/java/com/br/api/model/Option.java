package com.br.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String optionName;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Category category;
}
