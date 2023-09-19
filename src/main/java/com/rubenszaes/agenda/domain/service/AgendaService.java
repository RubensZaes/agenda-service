package com.rubenszaes.agenda.domain.service;

import com.rubenszaes.agenda.domain.model.Agenda;
import com.rubenszaes.agenda.domain.model.Paciente;
import com.rubenszaes.agenda.domain.repository.AgendaRepository;
import com.rubenszaes.agenda.exception.BusinessExcepition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final PacienteService pacienteService;


    public List<Agenda> listarTodos() {
        return agendaRepository.findAll();
    }

    public Optional<Agenda> buscarPorId(Long id) {
        return agendaRepository.findById(id);
    }

    public Agenda salvar(Agenda agenda) {
        Optional<Paciente> optionalPaciente = pacienteService.buscarPorId(agenda.getPaciente().getId());
        if (optionalPaciente.isEmpty())
            throw new BusinessExcepition("Paciente não encontrado");

        Optional<Agenda> byHorario = agendaRepository.findByHorario(agenda.getHorario());
        if (byHorario.isPresent())
            throw new BusinessExcepition("Já existe agendamento pra este horário");

        agenda.setPaciente(optionalPaciente.get());
        agenda.setDataCriacao(LocalDateTime.now());
        return agendaRepository.save(agenda);
    }
}
