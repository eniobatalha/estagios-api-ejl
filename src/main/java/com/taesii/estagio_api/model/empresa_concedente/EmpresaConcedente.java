package com.taesii.estagio_api.model.empresa_concedente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "empresas_concedentes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaConcedente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cnpj;
}
