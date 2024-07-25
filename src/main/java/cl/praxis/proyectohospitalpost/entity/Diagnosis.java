package cl.praxis.proyectohospitalpost.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="diagnostico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="fecha_atencion", nullable=false)
    private Date attention;
    @Column(name="nombre_diagnostico", length=100, nullable=false)
    private String diagnosis;
    @Column(name="estado_paciente", length=50, nullable=false)
    private String state;
    @OneToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id")
    private Patient patient;
}
