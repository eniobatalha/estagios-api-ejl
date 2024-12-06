package com.taesii.estagio_api.api.estagio;

import com.taesii.estagio_api.model.agente_integracao.AgenteIntegracao;
import com.taesii.estagio_api.model.empresa_concedente.EmpresaConcedente;
import com.taesii.estagio_api.model.estagio.Estagio;
import com.taesii.estagio_api.model.estudante.Estudante;
import com.taesii.estagio_api.model.orientador.Orientador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstagioRequest {

    @NotNull(message = "O ID do estudante é de preenchimento obrigatório.")
    private Long estudanteId;

    @NotNull(message = "O ID do orientador é de preenchimento obrigatório.")
    private Long orientadorId;

    @NotNull(message = "O ID da empresa concedente é de preenchimento obrigatório.")
    private Long empresaConcedenteId;

    private Long agenteIntegracaoId;

    @NotNull(message = "A descrição do estágio é de preenchimento obrigatório.")
    @NotBlank(message = "A descrição do estágio é de preenchimento obrigatório.")
    private String descricao;

    @NotNull(message = "O status ativo do estágio é de preenchimento obrigatório.")
    private Boolean ativo;

    public Estagio build(Estudante estudante, Orientador orientador, EmpresaConcedente empresaConcedente, AgenteIntegracao agenteIntegracao) {
        return Estagio.builder()
                .estudante(estudante)
                .orientador(orientador)
                .empresaConcedente(empresaConcedente)
                .agenteIntegracao(agenteIntegracao)
                .descricao(descricao)
                .ativo(ativo)
                .build();
    }
}
