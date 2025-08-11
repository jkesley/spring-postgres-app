package com.alunoskesley.professorkesley.business;

import com.alunoskesley.professorkesley.exceptions.ResourceNotFoundException;
import com.alunoskesley.professorkesley.infrastructure.entitys.Pessoa;
import com.alunoskesley.professorkesley.infrastructure.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    // Criar nova pessoa
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    // Buscar todas as pessoas
    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    // Buscar pessoa por ID
    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    // Atualizar pessoa
    public Pessoa atualizar(Long id, Pessoa novaPessoa) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(novaPessoa.getNome());
                    pessoa.setEmail(novaPessoa.getEmail());
                    pessoa.setCurso(novaPessoa.getCurso());
                    pessoa.setAno(novaPessoa.getAno());
                    return pessoaRepository.save(pessoa);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa com ID " + id + " não encontrada"));
    }


    // Deletar pessoa
    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }
}

