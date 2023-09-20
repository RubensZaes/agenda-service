package com.rubenszaes.agenda.api.dto;

import com.rubenszaes.agenda.domain.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AgendaResponseDTO {
    private Long id;
    private String descricao;
    private LocalDateTime horario;
    private LocalDateTime dataCriacao;
    private PacienteResponseDTO paciente;
}
