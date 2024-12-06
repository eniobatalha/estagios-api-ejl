package com.taesii.estagio_api.api.agente_integracao;

import org.springframework.web.bind.annotation.*;

import com.taesii.estagio_api.model.agente_integracao.AgenteIntegracao;
import com.taesii.estagio_api.model.agente_integracao.AgenteIntegracaoService;

import java.util.List;

@RestController
@RequestMapping("/api/agentes-integracao")
public class AgenteIntegracaoController {
    private final AgenteIntegracaoService agenteIntegracaoService;

    public AgenteIntegracaoController(AgenteIntegracaoService agenteIntegracaoService) {
        this.agenteIntegracaoService = agenteIntegracaoService;
    }

    @GetMapping
    public List<AgenteIntegracao> listarTodos() {
        return agenteIntegracaoService.listarTodos();
    }

    @PostMapping
    public AgenteIntegracao salvar(@RequestBody AgenteIntegracao agenteIntegracao) {
        return agenteIntegracaoService.salvar(agenteIntegracao);
    }

    @PatchMapping("/{id}")
    public AgenteIntegracao atualizar(@PathVariable Long id,
            @RequestBody AgenteIntegracao agenteIntegracaoAtualizado) {
        return agenteIntegracaoService.atualizar(id, agenteIntegracaoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        agenteIntegracaoService.excluir(id);
    }
}
