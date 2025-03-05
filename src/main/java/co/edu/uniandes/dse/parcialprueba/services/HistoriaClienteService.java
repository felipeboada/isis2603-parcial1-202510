package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.HistoriaClinicaEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.repositories.HistoriaClinicaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HistoriaClienteService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    @Transactional
    public HistoriaClinicaEntity createHistoriaClinica(HistoriaClinicaEntity historiaClinica) throws EntityNotFoundException{
        log.info("Creando una historia clinica nueva");

        if (historiaClinicaRepository.findByDiagnostico(historiaClinica.getDiagnostico()) != null) {
            throw new EntityNotFoundException("Ya existe una historia clinica con ese diagnostico");
        }

        if (historiaClinicaRepository.findByTratamiento(historiaClinica.getTratamiento()) != null) {
            throw new EntityNotFoundException("Ya existe una historia clinica con ese tratamiento");
        }

        if (historiaClinicaRepository.findByFechaDeCreacion(historiaClinica.getFechaDeCreacion()) != null) {
            throw new EntityNotFoundException("Ya existe una historia clinica con esa fecha de creacion");
        }
        
        return historiaClinicaRepository.save(historiaClinica);
    }
    
}
