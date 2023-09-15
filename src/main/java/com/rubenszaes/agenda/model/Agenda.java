package com.rubenszaes.agenda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agendas", schema = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agendas_sq")
    @SequenceGenerator(schema = "agenda", name = "agendas_sq", sequenceName = "agendas_sq", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data_hora")
    private LocalDateTime horario;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    @ManyToOne
    private Paciente paciente;
}
