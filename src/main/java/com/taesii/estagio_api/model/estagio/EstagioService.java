package com.taesii.estagio_api.model.estagio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstagioService {
    private final EstagioRepository estagioRepository;

    public EstagioService(EstagioRepository estagioRepository) {
        this.estagioRepository = estagioRepository;
    }

    public List<Estagio> listarTodos() {
        return estagioRepository.findAll();
    }

    public Estagio salvar(Estagio estagio) {
        return estagioRepository.save(estagio);
    }

    public void excluir(Long id) {
        estagioRepository.deleteById(id);
    }

    public Estagio atualizar(Long id, Estagio estagioAtualizado) {
        return estagioRepository.findById(id).map(estagio -> {
            if (estagioAtualizado.getDescricao() != null) {
                estagio.setDescricao(estagioAtualizado.getDescricao());
            }
            if (estagioAtualizado.getEstudante() != null) {
                estagio.setEstudante(estagioAtualizado.getEstudante());
            }
            if (estagioAtualizado.getOrientador() != null) {
                estagio.setOrientador(estagioAtualizado.getOrientador());
            }
            if (estagioAtualizado.getEmpresaConcedente() != null) {
                estagio.setEmpresaConcedente(estagioAtualizado.getEmpresaConcedente());
            }
            if (estagioAtualizado.getAgenteIntegracao() != null) {
                estagio.setAgenteIntegracao(estagioAtualizado.getAgenteIntegracao());
            }
            if (estagioAtualizado.getAtivo() != null) {
                estagio.setAtivo(estagioAtualizado.getAtivo());
            }
            return estagioRepository.save(estagio);
        }).orElseThrow(() -> new RuntimeException("Estágio não encontrado com ID: " + id));
    }
}
