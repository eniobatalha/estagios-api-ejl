package com.taesii.estagio_api.model.estudante;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {
    private final EstudanteRepository estudanteRepository;

    public EstudanteService(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    public List<Estudante> listarTodos() {
        return estudanteRepository.findAll();
    }

    public Estudante buscarPorId(Long id) {
        return estudanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudante não encontrado com ID: " + id));
    }

    public Estudante salvar(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public void excluir(Long id) {
        estudanteRepository.deleteById(id);
    }

    public Estudante atualizar(Long id, Estudante estudanteAtualizado) {
        return estudanteRepository.findById(id).map(estudante -> {
            if (estudanteAtualizado.getNome() != null) {
                estudante.setNome(estudanteAtualizado.getNome());
            }
            if (estudanteAtualizado.getMatricula() != null) {
                estudante.setMatricula(estudanteAtualizado.getMatricula());
            }
            if (estudanteAtualizado.getCurso() != null) {
                estudante.setCurso(estudanteAtualizado.getCurso());
            }
            return estudanteRepository.save(estudante);
        }).orElseThrow(() -> new RuntimeException("Estudante não encontrado com ID: " + id));
    }
}
