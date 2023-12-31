package com.rubenszaes.agenda.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequestDTO {
    @NotBlank(message = "Nome do paciente é obrigatório.")
    private String nome;
    @NotBlank(message = "Sobrenome do paciente é obrigatório.")
    private String sobrenome;
    private String email;
    @NotBlank(message = "CPF do paciente é obrigatório.")
    private String cpf;
}
