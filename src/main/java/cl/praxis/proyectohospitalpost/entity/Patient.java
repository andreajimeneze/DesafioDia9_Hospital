package cl.praxis.proyectohospitalpost.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Entity
@Table(name="Paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private long id;
    @Column(name="nombre", length=50,nullable=false)
    private String name;
    @Column(name="apellido", length=50, nullable=false)
    private String surname;
    @Column(name="fecha_nacimiento", length=14, nullable=false)
    private Date birthDate;
    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Diagnosis diagnosis;
}
