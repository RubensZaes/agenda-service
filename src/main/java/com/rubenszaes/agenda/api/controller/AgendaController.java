package com.rubenszaes.agenda.api.controller;

import com.rubenszaes.agenda.api.dto.AgendaRequestDTO;
import com.rubenszaes.agenda.api.dto.AgendaResponseDTO;
import com.rubenszaes.agenda.api.mapper.AgendaMapper;
import com.rubenszaes.agenda.domain.model.Agenda;
import com.rubenszaes.agenda.domain.service.AgendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agenda")
public class AgendaController {

    private final AgendaService agendaService;
    private final AgendaMapper agendaMapper;

    @GetMapping
    public ResponseEntity<List<AgendaResponseDTO>> buscarTodos() {
        List<Agenda> agendaList = agendaService.listarTodos();
        List<AgendaResponseDTO> agendaResponseDTOList = agendaMapper.toAgendaResponseDTOList(agendaList);
        return ResponseEntity.status(HttpStatus.OK).body(agendaResponseDTOList);
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaResponseDTO> buscarPorId(@PathVariable Long id) {
        Optional<Agenda> optionalAgenda = agendaService.buscarPorId(id);
        if (optionalAgenda.isEmpty())
            return ResponseEntity.notFound().build();
        AgendaResponseDTO agendaResponseDTO = agendaMapper.toAgendaResponseDTO(optionalAgenda.get());
        return ResponseEntity.status(HttpStatus.OK).body(agendaResponseDTO);
    }

    @PostMapping
    public ResponseEntity<AgendaResponseDTO> salvar(@Valid @RequestBody AgendaRequestDTO agendaRequestDTO) {
        Agenda agenda = agendaMapper.toAgenda(agendaRequestDTO);
        Agenda agendaSalvar = agendaService.salvar(agenda);
        AgendaResponseDTO agendaResponseDTO = agendaMapper.toAgendaResponseDTO(agendaSalvar);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaResponseDTO);
    }
}
