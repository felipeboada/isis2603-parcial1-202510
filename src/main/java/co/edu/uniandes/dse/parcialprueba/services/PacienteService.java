package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.repositories.HistoriaClinicaRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PacienteService {

    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Transactional
    public PacienteEntity createPaciente(PacienteEntity paciente) throws EntityNotFoundException {
        log.info("Creando un paciente nuevo");

        if (pacienteRepository.findByNombre(paciente.getNombre()) != null) {
            throw new EntityNotFoundException("Ya existe un paciente con ese nombre");
        }

        if (pacienteRepository.findByCorreo(paciente.getCorreo()) != null) {
            throw new EntityNotFoundException("Ya existe un paciente con ese correo");
        }

        if (pacienteRepository.findByTelefono(paciente.getTelefono()) != null) {
            throw new EntityNotFoundException("Ya existe un paciente con ese teléfono");
        }

        String telefono = paciente.getTelefono();
        if (!telefono.matches("^(311|601)\\d{8}$")) {
            throw new EntityNotFoundException("El teléfono debe tener 11 dígitos y comenzar con 311 o 601");
        }

        return pacienteRepository.save(paciente);
    }

    @Transactional
    public PacienteEntity asociaracudiente(Long pacienteId, Long acudienteId) throws EntityNotFoundException {
        PacienteEntity paciente = pacienteRepository.findById(pacienteId).orElse(null);
        PacienteEntity acudiente = pacienteRepository.findById(acudienteId).orElse(null);

        if (paciente == null) {
            throw new EntityNotFoundException("No existe un paciente con ese id");
        }

        if (acudiente == null) {
            throw new EntityNotFoundException("No existe un acudiente con ese id");
        }

        paciente.setAcudiente(acudiente);
        return pacienteRepository.save(paciente);
    }

    
}
