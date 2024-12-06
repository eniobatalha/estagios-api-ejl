package com.taesii.estagio_api.model.estagio;

import com.taesii.estagio_api.model.agente_integracao.AgenteIntegracao;
import com.taesii.estagio_api.model.empresa_concedente.EmpresaConcedente;
import com.taesii.estagio_api.model.estudante.Estudante;
import com.taesii.estagio_api.model.orientador.Orientador;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "estagios")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Estagio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudante_id", nullable = false)
    private Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "orientador_id", nullable = false)
    private Orientador orientador;

    @ManyToOne
    @JoinColumn(name = "empresa_concedente_id", nullable = false)
    private EmpresaConcedente empresaConcedente;

    @ManyToOne
    @JoinColumn(name = "agente_integracao_id")
    private AgenteIntegracao agenteIntegracao;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Boolean ativo;
}

