package co.edu.uniandes.dse.parcialprueba.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;


@Data
@Entity
public class PacienteEntity extends BaseEntity{

    private Long id;

    private String nombre;

    private String correo;

    private String telefono;

    @PodamExclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private HistoriaClinicaEntity historiaClinica;

    @PodamExclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private PacienteEntity acudiente;




    
}
