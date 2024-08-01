package cl.praxis.proyectohospitalpost.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="diagnosticos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "fecha_atencion", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate attention;
    @Column(name="nombre_diagnostico", length=100, nullable=false)
    private String diagnosis;
    @Column(name="estado_paciente", length=50, nullable=false)
    private String state;
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Patient patient;
}
