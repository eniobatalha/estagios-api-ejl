package com.taesii.estagio_api.model.orientador;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrientadorService {
    private final OrientadorRepository orientadorRepository;

    public OrientadorService(OrientadorRepository orientadorRepository) {
        this.orientadorRepository = orientadorRepository;
    }

    public List<Orientador> listarTodos() {
        return orientadorRepository.findAll();
    }

    public Orientador buscarPorId(Long id) {
        return orientadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Orientador não encontrado com ID: " + id));
    }

    public Orientador salvar(Orientador orientador) {
        return orientadorRepository.save(orientador);
    }

    public void excluir(Long id) {
        orientadorRepository.deleteById(id);
    }

    public Orientador atualizar(Long id, Orientador orientadorAtualizado) {
        return orientadorRepository.findById(id).map(orientador -> {
            if (orientadorAtualizado.getNome() != null) {
                orientador.setNome(orientadorAtualizado.getNome());
            }
            if (orientadorAtualizado.getDepartamento() != null) {
                orientador.setDepartamento(orientadorAtualizado.getDepartamento());
            }
            return orientadorRepository.save(orientador);
        }).orElseThrow(() -> new RuntimeException("Orientador não encontrado com ID: " + id));
    }
}

