package com.rubenszaes.agenda.api.mapper;

import com.rubenszaes.agenda.api.dto.AgendaRequestDTO;
import com.rubenszaes.agenda.api.dto.AgendaResponseDTO;
import com.rubenszaes.agenda.api.dto.PacienteRequestDTO;
import com.rubenszaes.agenda.api.dto.PacienteResponseDTO;
import com.rubenszaes.agenda.domain.model.Agenda;
import com.rubenszaes.agenda.domain.model.Paciente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AgendaMapper {

    private final ModelMapper modelMapper;

    public Agenda toAgenda(AgendaRequestDTO agendaRequestDTO) {
        return modelMapper.map(agendaRequestDTO, Agenda.class);
    }

    public AgendaResponseDTO toAgendaResponseDTO(Agenda agenda){
        return modelMapper.map(agenda, AgendaResponseDTO.class);
    }

    public List<AgendaResponseDTO> toAgendaResponseDTOList(List<Agenda> agendaList) {
        return agendaList.stream()
                .map(this::toAgendaResponseDTO)
                .collect(Collectors.toList());
    }
}
