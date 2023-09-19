package com.rubenszaes.agenda.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequestDTO {
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
}
