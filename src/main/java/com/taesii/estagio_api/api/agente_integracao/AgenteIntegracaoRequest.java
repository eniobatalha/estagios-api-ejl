package com.taesii.estagio_api.api.agente_integracao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import com.taesii.estagio_api.model.agente_integracao.AgenteIntegracao;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgenteIntegracaoRequest {

    @NotNull(message = "O nome do agente de integração é de preenchimento obrigatório.")
    @NotBlank(message = "O nome do agente de integração é de preenchimento obrigatório.")
    @Length(max = 100, message = "O nome do agente de integração deve ter no máximo {max} caracteres.")
    private String nome;

    @NotNull(message = "O contato do agente de integração é de preenchimento obrigatório.")
    @NotBlank(message = "O contato do agente de integração é de preenchimento obrigatório.")
    private String contato;

    public AgenteIntegracao build() {
        return AgenteIntegracao.builder()
                .nome(nome)
                .contato(contato)
                .build();
    }
}
