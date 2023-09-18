package com.rubenszaes.agenda.domain.service;

import com.rubenszaes.agenda.domain.model.Paciente;
import com.rubenszaes.agenda.domain.repository.PacienteRepository;
import com.rubenszaes.agenda.exception.BusinessExcepition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente salvar(Paciente paciente) {
        Optional<Paciente> optionalPaciente = pacienteRepository.findByCpf(paciente.getCpf());

        boolean existeCpf = false;

        if (optionalPaciente.isPresent())
            if (!optionalPaciente.get().getId().equals(paciente.getId())) existeCpf = true;

        if (existeCpf)
            throw new BusinessExcepition("CPF já Cadastrado!");

        return pacienteRepository.save(paciente);
    }

    public void deletar(Long id) {
        pacienteRepository.findById(id);
    }
}
