package com.taesii.estagio_api.model.agente_integracao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "agentes_integracao")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgenteIntegracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String contato;
}
