package com.rubenszaes.agenda.api.mapper;

import com.rubenszaes.agenda.api.dto.PacienteRequestDTO;
import com.rubenszaes.agenda.api.dto.PacienteResponseDTO;
import com.rubenszaes.agenda.domain.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteMapper {

    public static Paciente toPaciente(PacienteRequestDTO pacienteRequestDTO) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteRequestDTO.getNome());
        paciente.setSobrenome(pacienteRequestDTO.getSobrenome());
        paciente.setEmail(pacienteRequestDTO.getEmail());
        paciente.setCpf(pacienteRequestDTO.getCpf());
        return paciente;
    }

    public static PacienteResponseDTO toPacienteResponseDTO(Paciente paciente) {
        PacienteResponseDTO pacienteResponseDTO = new PacienteResponseDTO();
        pacienteResponseDTO.setId(paciente.getId());
        pacienteResponseDTO.setNome(paciente.getNome());
        pacienteResponseDTO.setSobrenome(paciente.getSobrenome());
        pacienteResponseDTO.setEmail(paciente.getEmail());
        pacienteResponseDTO.setCpf(paciente.getCpf());
        return pacienteResponseDTO;
    }

    public static List<PacienteResponseDTO> toPacienteResponseList(List<Paciente> pacienteList) {
        List<PacienteResponseDTO> pacienteResponseDTOS = new ArrayList<>();

        for (Paciente paciente : pacienteList)
            pacienteResponseDTOS.add(toPacienteResponseDTO(paciente));

        return pacienteResponseDTOS;
    }
}
