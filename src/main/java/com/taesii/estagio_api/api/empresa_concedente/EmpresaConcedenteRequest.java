package com.taesii.estagio_api.api.empresa_concedente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import com.taesii.estagio_api.model.empresa_concedente.EmpresaConcedente;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaConcedenteRequest {

    @NotNull(message = "O nome da empresa concedente é de preenchimento obrigatório.")
    @NotBlank(message = "O nome da empresa concedente é de preenchimento obrigatório.")
    @Length(max = 100, message = "O nome da empresa concedente deve ter no máximo {max} caracteres.")
    private String nome;

    @NotNull(message = "O CNPJ da empresa concedente é de preenchimento obrigatório.")
    @NotBlank(message = "O CNPJ da empresa concedente é de preenchimento obrigatório.")
    @CNPJ(message = "O CNPJ informado é inválido.")
    private String cnpj;

    public EmpresaConcedente build() {
        return EmpresaConcedente.builder()
                .nome(nome)
                .cnpj(cnpj)
                .build();
    }
}
