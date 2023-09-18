package com.rubenszaes.agenda.api.controller;

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
    public ResponseEntity<List<Paciente>> listarTodos() {
        List<Paciente> pacientes = pacienteService.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable("id") Long id) {
        Optional<Paciente> optionalPaciente = pacienteService.buscarPorId(id);

        if (optionalPaciente.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.OK).body(optionalPaciente.get());
    }

    @PostMapping
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente) {
        Paciente pacienteSalvar = pacienteService.salvar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvar);
    }
}
