package com.taesii.estagio_api.api.orientador;

import com.taesii.estagio_api.model.orientador.Orientador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrientadorRequest {

    @NotNull(message = "O nome do orientador é de preenchimento obrigatório.")
    @NotBlank(message = "O nome do orientador é de preenchimento obrigatório.")
    @Length(max = 100, message = "O nome do orientador deve ter no máximo {max} caracteres.")
    private String nome;

    @NotNull(message = "O departamento do orientador é de preenchimento obrigatório.")
    @NotBlank(message = "O departamento do orientador é de preenchimento obrigatório.")
    private String departamento;

    public Orientador build() {
        return Orientador.builder()
                .nome(nome)
                .departamento(departamento)
                .build();
    }
}
