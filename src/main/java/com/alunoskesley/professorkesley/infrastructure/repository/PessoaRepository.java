package com.alunoskesley.professorkesley.infrastructure.repository;

import com.alunoskesley.professorkesley.infrastructure.entitys.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Optional<Pessoa> findByEmail(String email);

}
