package co.edu.uniandes.dse.parcialprueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;


@Repository
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {

    PacienteEntity findByNombre(String nombre);

    PacienteEntity findByCorreo(String correo);

    PacienteEntity findByTelefono(String telefono);

    PacienteEntity findByAcudiente(PacienteEntity acudienteId);
    
}
