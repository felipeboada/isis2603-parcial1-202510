package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class HistoriaClinicaEntity extends BaseEntity{

    private Long id;

    private String diagnostico;

    private String tratamiento;

    private String fechaDeCreacion;
    
    @PodamExclude
    @OneToMany(mappedBy = "historiaClinica")
    private List<PacienteEntity> pacientes = new ArrayList<>();
    
}
