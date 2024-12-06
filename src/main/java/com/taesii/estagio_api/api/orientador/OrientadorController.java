package com.taesii.estagio_api.api.orientador;

import org.springframework.web.bind.annotation.*;

import com.taesii.estagio_api.model.orientador.Orientador;
import com.taesii.estagio_api.model.orientador.OrientadorService;

import java.util.List;

@RestController
@RequestMapping("/api/orientadores")
public class OrientadorController {
    private final OrientadorService orientadorService;

    public OrientadorController(OrientadorService orientadorService) {
        this.orientadorService = orientadorService;
    }

    @GetMapping
    public List<Orientador> listarTodos() {
        return orientadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Orientador buscarPorId(@PathVariable Long id) {
        return orientadorService.buscarPorId(id);
    }

    @PostMapping
    public Orientador salvar(@RequestBody Orientador orientador) {
        return orientadorService.salvar(orientador);
    }

    @PatchMapping("/{id}")
    public Orientador atualizar(@PathVariable Long id, @RequestBody Orientador orientadorAtualizado) {
        return orientadorService.atualizar(id, orientadorAtualizado);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        orientadorService.excluir(id);
    }
}
