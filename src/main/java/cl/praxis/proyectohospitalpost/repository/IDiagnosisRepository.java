package cl.praxis.proyectohospitalpost.repository;

import cl.praxis.proyectohospitalpost.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
