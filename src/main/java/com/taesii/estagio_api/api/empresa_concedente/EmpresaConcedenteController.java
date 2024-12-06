package com.taesii.estagio_api.api.empresa_concedente;

import org.springframework.web.bind.annotation.*;

import com.taesii.estagio_api.model.empresa_concedente.EmpresaConcedente;
import com.taesii.estagio_api.model.empresa_concedente.EmpresaConcedenteService;

import java.util.List;

@RestController
@RequestMapping("/api/empresas-concedentes")
public class EmpresaConcedenteController {
    private final EmpresaConcedenteService empresaConcedenteService;

    public EmpresaConcedenteController(EmpresaConcedenteService empresaConcedenteService) {
        this.empresaConcedenteService = empresaConcedenteService;
    }

    @GetMapping
    public List<EmpresaConcedente> listarTodos() {
        return empresaConcedenteService.listarTodos();
    }

    @PostMapping
    public EmpresaConcedente salvar(@RequestBody EmpresaConcedente empresaConcedente) {
        return empresaConcedenteService.salvar(empresaConcedente);
    }

    @PatchMapping("/{id}")
    public EmpresaConcedente atualizar(@PathVariable Long id, @RequestBody EmpresaConcedente empresaAtualizada) {
        return empresaConcedenteService.atualizar(id, empresaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        empresaConcedenteService.excluir(id);
    }
}
