package com.rubenszaes.agenda.domain.service;

import com.rubenszaes.agenda.domain.model.Agenda;
import com.rubenszaes.agenda.domain.model.Paciente;
import com.rubenszaes.agenda.domain.repository.AgendaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AgendaServiceTest {
    @InjectMocks
    AgendaService agendaService;
    @Mock
    PacienteService pacienteService;
    @Mock
    AgendaRepository agendaRepository;

    @Captor
    ArgumentCaptor<Agenda> agendaArgumentCaptor;

    @Test
    @DisplayName("Deve salvar agendamento com sucesso.")
    void salvarComSucesso() {

        // ARRANGE
        LocalDateTime now = LocalDateTime.now();
        Agenda agenda = new Agenda();
        agenda.setDescricao("Teste Descricao Agendamento");
        agenda.setHorario(now);

        Paciente paciente = new Paciente();
        paciente.setId(1L);
        paciente.setNome("TESTE Paciente");

        agenda.setPaciente(paciente);

        Mockito.when(pacienteService.buscarPorId(agenda.getPaciente().getId())).thenReturn(Optional.of(paciente));
        Mockito.when(agendaRepository.findByHorario(now)).thenReturn(Optional.empty());

        // ACTION
        agendaService.salvar(agenda);

        // ASSERTIONS
        Mockito.verify(pacienteService).buscarPorId(agenda.getPaciente().getId());
        Mockito.verify(agendaRepository).findByHorario(now);
        Mockito.verify(agendaRepository).save(agendaArgumentCaptor.capture());
        Agenda agendaSalva = agendaArgumentCaptor.getValue();

        Assertions.assertThat(agendaSalva.getPaciente()).isNotNull();
        Assertions.assertThat(agendaSalva.getDataCriacao()).isNotNull();

    }
}