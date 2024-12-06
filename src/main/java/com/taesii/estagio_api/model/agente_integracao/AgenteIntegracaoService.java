package com.taesii.estagio_api.model.agente_integracao;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenteIntegracaoService {
    private final AgenteIntegracaoRepository agenteIntegracaoRepository;

    public AgenteIntegracaoService(AgenteIntegracaoRepository agenteIntegracaoRepository) {
        this.agenteIntegracaoRepository = agenteIntegracaoRepository;
    }

    public List<AgenteIntegracao> listarTodos() {
        return agenteIntegracaoRepository.findAll();
    }

    public AgenteIntegracao buscarPorId(Long id) {
        return agenteIntegracaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agente de Integração não encontrado com ID: " + id));
    }

    public AgenteIntegracao salvar(AgenteIntegracao agenteIntegracao) {
        return agenteIntegracaoRepository.save(agenteIntegracao);
    }

    public void excluir(Long id) {
        agenteIntegracaoRepository.deleteById(id);
    }

    public AgenteIntegracao atualizar(Long id, AgenteIntegracao agenteAtualizado) {
        return agenteIntegracaoRepository.findById(id).map(agente -> {
            if (agenteAtualizado.getNome() != null) {
                agente.setNome(agenteAtualizado.getNome());
            }
            if (agenteAtualizado.getContato() != null) {
                agente.setContato(agenteAtualizado.getContato());
            }
            return agenteIntegracaoRepository.save(agente);
        }).orElseThrow(() -> new RuntimeException("Agente de integração não encontrado com ID: " + id));
    }
}
