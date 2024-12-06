package com.taesii.estagio_api.api.estudante;

import com.taesii.estagio_api.model.estudante.Estudante;
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
public class EstudanteRequest {

    @NotNull(message = "O nome do estudante é de preenchimento obrigatório.")
    @NotBlank(message = "O nome do estudante é de preenchimento obrigatório.")
    @Length(max = 100, message = "O nome do estudante deve ter no máximo {max} caracteres.")
    private String nome;

    @NotNull(message = "A matrícula do estudante é de preenchimento obrigatório.")
    @NotBlank(message = "A matrícula do estudante é de preenchimento obrigatório.")
    @Length(max = 20, message = "A matrícula do estudante deve ter no máximo {max} caracteres.")
    private String matricula;

    @NotNull(message = "O curso do estudante é de preenchimento obrigatório.")
    @NotBlank(message = "O curso do estudante é de preenchimento obrigatório.")
    private String curso;

    public Estudante build() {
        return Estudante.builder()
                .nome(nome)
                .matricula(matricula)
                .curso(curso)
                .build();
    }
}
