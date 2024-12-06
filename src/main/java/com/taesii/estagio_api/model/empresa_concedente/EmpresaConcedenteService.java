package com.taesii.estagio_api.model.empresa_concedente;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaConcedenteService {
    private final EmpresaConcedenteRepository empresaConcedenteRepository;

    public EmpresaConcedenteService(EmpresaConcedenteRepository empresaConcedenteRepository) {
        this.empresaConcedenteRepository = empresaConcedenteRepository;
    }

    public List<EmpresaConcedente> listarTodos() {
        return empresaConcedenteRepository.findAll();
    }

    public EmpresaConcedente buscarPorId(Long id) {
        return empresaConcedenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa Concedente não encontrado com ID: " + id));
    }

    public EmpresaConcedente salvar(EmpresaConcedente empresaConcedente) {
        return empresaConcedenteRepository.save(empresaConcedente);
    }

    public void excluir(Long id) {
        empresaConcedenteRepository.deleteById(id);
    }

    public EmpresaConcedente atualizar(Long id, EmpresaConcedente empresaAtualizada) {
        return empresaConcedenteRepository.findById(id).map(empresa -> {
            if (empresaAtualizada.getNome() != null) {
                empresa.setNome(empresaAtualizada.getNome());
            }
            if (empresaAtualizada.getCnpj() != null) {
                empresa.setCnpj(empresaAtualizada.getCnpj());
            }
            return empresaConcedenteRepository.save(empresa);
        }).orElseThrow(() -> new RuntimeException("Empresa concedente não encontrada com ID: " + id));
    }
}

