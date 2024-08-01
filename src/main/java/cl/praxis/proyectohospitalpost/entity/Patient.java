package cl.praxis.proyectohospitalpost.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;
    @Column(name="nombre", length=50,nullable=false)
    private String name;
    @Column(name="apellido", length=50, nullable=false)
    private String surname;
    @Column(name="run", length=15, nullable=false)
    private String run;
    @Column(name="fecha_nacimiento", length=14, nullable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Diagnosis diagnosis;
}
