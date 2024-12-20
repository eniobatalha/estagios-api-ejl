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

    @GetMapping("/{id}")
    public Estagio buscarPorId(@PathVariable Long id) {
        return estagioService.buscarPorId(id);
    }

    @PostMapping
    public Estagio salvar(@RequestBody EstagioRequest estagioRequest) {
        System.out.println("Request recebido: " + estagioRequest);
        return estagioService.salvar(estagioRequest);
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
