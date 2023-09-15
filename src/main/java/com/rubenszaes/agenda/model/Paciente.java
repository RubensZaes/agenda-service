package com.rubenszaes.agenda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pacientes", schema = "agenda")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacientes_sq")
    @SequenceGenerator(schema = "agenda", name = "pacientes_sq", sequenceName = "pacientes_sq", initialValue = 1, allocationSize = 1)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
}
