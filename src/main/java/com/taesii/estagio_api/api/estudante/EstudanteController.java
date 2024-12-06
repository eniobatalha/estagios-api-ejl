package com.taesii.estagio_api.api.estudante;

import org.springframework.web.bind.annotation.*;

import com.taesii.estagio_api.model.estudante.Estudante;
import com.taesii.estagio_api.model.estudante.EstudanteService;

import java.util.List;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {
    private final EstudanteService estudanteService;

    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }

    @GetMapping
    public List<Estudante> listarTodos() {
        return estudanteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Estudante buscarPorId(@PathVariable Long id) {
        return estudanteService.buscarPorId(id);
    }

    @PostMapping
    public Estudante salvar(@RequestBody Estudante estudante) {
        return estudanteService.salvar(estudante);
    }

    @PatchMapping("/{id}")
    public Estudante atualizar(@PathVariable Long id, @RequestBody Estudante estudanteAtualizado) {
        return estudanteService.atualizar(id, estudanteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        estudanteService.excluir(id);
    }
}
