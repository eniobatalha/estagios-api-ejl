package com.taesii.estagio_api.api.estagio;

import org.springframework.web.bind.annotation.*;

import com.taesii.estagio_api.model.estagio.Estagio;
import com.taesii.estagio_api.model.estagio.EstagioService;

import java.util.List;

@RestController
@RequestMapping("/api/estagios")
public class EstagioController {
    private final EstagioService estagioService;

    public EstagioController(EstagioService estagioService) {
        this.estagioService = estagioService;
    }

    @GetMapping
    public List<Estagio> listarTodos() {
        return estagioService.listarTodos();
    }

    @PostMapping
    public Estagio salvar(@RequestBody Estagio estagio) {
        return estagioService.salvar(estagio);
    }

    @PatchMapping("/{id}")
    public Estagio atualizar(@PathVariable Long id, @RequestBody Estagio estagioAtualizado) {
        return estagioService.atualizar(id, estagioAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        estagioService.excluir(id);
    }
}
