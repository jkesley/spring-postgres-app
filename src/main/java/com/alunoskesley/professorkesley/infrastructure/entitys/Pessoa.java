package com.alunoskesley.professorkesley.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="pessoa")
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name="email",unique = true)
    private String email;
    @Column(name = "curso")
    private String curso;
    @Column(name = "ano")
    private Integer ano;

}
