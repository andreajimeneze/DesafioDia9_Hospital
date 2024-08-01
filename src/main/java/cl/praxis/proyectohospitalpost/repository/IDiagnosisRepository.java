package cl.praxis.proyectohospitalpost.repository;

import cl.praxis.proyectohospitalpost.entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
