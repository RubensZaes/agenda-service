package com.rubenszaes.agenda.api.controller;

import com.rubenszaes.agenda.api.dto.PacienteRequestDTO;
import com.rubenszaes.agenda.api.dto.PacienteResponseDTO;
import com.rubenszaes.agenda.api.mapper.PacienteMapper;
import com.rubenszaes.agenda.domain.model.Paciente;
import com.rubenszaes.agenda.domain.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listarTodos() {
        List<Paciente> pacientes = pacienteService.listarTodos();
        List<PacienteResponseDTO> pacienteResponseDTOS = PacienteMapper.toPacienteResponseList(pacientes);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPorId(@PathVariable("id") Long id) {
        Optional<Paciente> optionalPaciente = pacienteService.buscarPorId(id);
        if (optionalPaciente.isEmpty())
            return ResponseEntity.notFound().build();
        PacienteResponseDTO pacienteResponseDTO = PacienteMapper.toPacienteResponseDTO(optionalPaciente.get());
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponseDTO);
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> salvar(@RequestBody PacienteRequestDTO pacienteRequestDTO) {
        Paciente paciente = PacienteMapper.toPaciente(pacienteRequestDTO);
        Paciente pacienteSalvar = pacienteService.salvar(paciente);
        PacienteResponseDTO pacienteResponseDTO = PacienteMapper.toPacienteResponseDTO(pacienteSalvar);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteResponseDTO);
    }

    @PutMapping
    public ResponseEntity<PacienteResponseDTO> update(@RequestBody PacienteRequestDTO pacienteRequestDTO) {
        Paciente paciente = PacienteMapper.toPaciente(pacienteRequestDTO);
        Paciente pacienteSalvar = pacienteService.salvar(paciente);
        PacienteResponseDTO pacienteResponseDTO = PacienteMapper.toPacienteResponseDTO(pacienteSalvar);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        pacienteService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
