package com.taesii.estagio_api.model.estagio;

import com.taesii.estagio_api.model.agente_integracao.AgenteIntegracaoRepository;
import com.taesii.estagio_api.model.empresa_concedente.EmpresaConcedenteRepository;
import com.taesii.estagio_api.model.estudante.EstudanteRepository;
import com.taesii.estagio_api.model.orientador.OrientadorRepository;
import com.taesii.estagio_api.api.estagio.EstagioRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstagioService {

    private final EstagioRepository estagioRepository;
    private final EstudanteRepository estudanteRepository;
    private final OrientadorRepository orientadorRepository;
    private final EmpresaConcedenteRepository empresaConcedenteRepository;
    private final AgenteIntegracaoRepository agenteIntegracaoRepository;

    public EstagioService(
            EstagioRepository estagioRepository,
            EstudanteRepository estudanteRepository,
            OrientadorRepository orientadorRepository,
            EmpresaConcedenteRepository empresaConcedenteRepository,
            AgenteIntegracaoRepository agenteIntegracaoRepository) {
        this.estagioRepository = estagioRepository;
        this.estudanteRepository = estudanteRepository;
        this.orientadorRepository = orientadorRepository;
        this.empresaConcedenteRepository = empresaConcedenteRepository;
        this.agenteIntegracaoRepository = agenteIntegracaoRepository;
    }

    // Lista todos os estágios
    public List<Estagio> listarTodos() {
        return estagioRepository.findAll();
    }

    // Busca estágio por ID
    public Estagio buscarPorId(Long id) {
        return estagioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estágio não encontrado com ID: " + id));
    }

    // Salva um novo estágio
    public Estagio salvar(EstagioRequest estagioRequest) {
        System.out.println("Recebendo request para salvar estágio: " + estagioRequest);
        // Busca entidades relacionadas
        var estudante = estudanteRepository.findById(estagioRequest.getIdEstudante())
                .orElseThrow(() -> new RuntimeException(
                        "Estudante não encontrado com ID: " + estagioRequest.getIdEstudante()));
        System.out.println("Estudante encontrado: " + estudante);

        var orientador = orientadorRepository.findById(estagioRequest.getIdOrientador())
                .orElseThrow(() -> new RuntimeException(
                        "Orientador não encontrado com ID: " + estagioRequest.getIdOrientador()));
        System.out.println("Orientador encontrado: " + orientador);

        var empresaConcedente = empresaConcedenteRepository.findById(estagioRequest.getIdEmpresaConcedente())
                .orElseThrow(() -> new RuntimeException(
                        "Empresa Concedente não encontrada com ID: " + estagioRequest.getIdEmpresaConcedente()));
        System.out.println("Empresa Concedente encontrada: " + empresaConcedente);

        var agenteIntegracao = estagioRequest.getIdAgenteIntegracao() != null
                ? agenteIntegracaoRepository.findById(estagioRequest.getIdAgenteIntegracao())
                        .orElseThrow(() -> new RuntimeException("Agente de Integração não encontrado com ID: "
                                + estagioRequest.getIdAgenteIntegracao()))
                : null;
        System.out.println("Agente de Integração encontrado: " + agenteIntegracao);

        // Constrói e salva o estágio
        Estagio estagio = estagioRequest.build(estudante, orientador, empresaConcedente, agenteIntegracao);
        return estagioRepository.save(estagio);
    }

    // Atualiza estágio existente
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

    // Exclui estágio por ID
    public void excluir(Long id) {
        if (!estagioRepository.existsById(id)) {
            throw new RuntimeException("Estágio não encontrado com ID: " + id);
        }
        estagioRepository.deleteById(id);
    }
}
