package com.rubenszaes.agenda.api.mapper;

import com.rubenszaes.agenda.api.dto.PacienteRequestDTO;
import com.rubenszaes.agenda.api.dto.PacienteResponseDTO;
import com.rubenszaes.agenda.domain.model.Paciente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    public PacienteResponseDTO toPacienteResponseDTO(Paciente paciente){
        return modelMapper.map(paciente, PacienteResponseDTO.class);
    }

    public List<PacienteResponseDTO> toPacienteResponseDTOList(List<Paciente> pacienteList) {
        return pacienteList.stream()
                .map(this::toPacienteResponseDTO)
                .collect(Collectors.toList());
    }

//    public static Paciente toPaciente(PacienteRequestDTO pacienteRequestDTO) {
//        Paciente paciente = new Paciente();
//        paciente.setNome(pacienteRequestDTO.getNome());
//        paciente.setSobrenome(pacienteRequestDTO.getSobrenome());
//        paciente.setEmail(pacienteRequestDTO.getEmail());
//        paciente.setCpf(pacienteRequestDTO.getCpf());
//        return paciente;
//    }

//    public static PacienteResponseDTO toPacienteResponseDTO(Paciente paciente) {
//        PacienteResponseDTO pacienteResponseDTO = new PacienteResponseDTO();
//        pacienteResponseDTO.setId(paciente.getId());
//        pacienteResponseDTO.setNome(paciente.getNome());
//        pacienteResponseDTO.setSobrenome(paciente.getSobrenome());
//        pacienteResponseDTO.setEmail(paciente.getEmail());
//        pacienteResponseDTO.setCpf(paciente.getCpf());
//        return pacienteResponseDTO;
//    }

//    public static List<PacienteResponseDTO> toPacienteResponseList(List<Paciente> pacienteList) {
//        List<PacienteResponseDTO> pacienteResponseDTOS = new ArrayList<>();
//
//        for (Paciente paciente : pacienteList)
//            pacienteResponseDTOS.add(toPacienteResponseDTO(paciente));
//
//        return pacienteResponseDTOS;
//    }
}
