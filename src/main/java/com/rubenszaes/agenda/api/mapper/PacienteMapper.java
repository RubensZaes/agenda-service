package com.rubenszaes.agenda.api.mapper;

import com.rubenszaes.agenda.api.dto.PacienteRequestDTO;
import com.rubenszaes.agenda.api.dto.PacienteResponseDTO;
import com.rubenszaes.agenda.domain.model.Paciente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PacienteMapper {

    private final ModelMapper modelMapper;

    public Paciente toPaciente(PacienteRequestDTO pacienteRequestDTO) {
        Paciente pacienteMap = modelMapper.map(pacienteRequestDTO, Paciente.class);
        return pacienteMap;
    }

    public PacienteResponseDTO toPacienteResponseDTO(Paciente paciente) {
        return modelMapper.map(paciente, PacienteResponseDTO.class);
    }

    public List<PacienteResponseDTO> toPacienteResponseDTOList(List<Paciente> pacienteList) {
        return pacienteList.stream()
                .map(this::toPacienteResponseDTO)
                .collect(Collectors.toList());
    }
}
