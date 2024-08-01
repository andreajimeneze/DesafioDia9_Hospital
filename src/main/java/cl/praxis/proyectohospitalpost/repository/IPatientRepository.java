package cl.praxis.proyectohospitalpost.repository;

import cl.praxis.proyectohospitalpost.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.diagnosis WHERE p.id = :id")
    Patient findPatientWithDiagnosis(@Param("id") Long id);

    @Query("SELECT DISTINCT p FROM Patient p LEFT JOIN FETCH p.diagnosis")
    List<Patient> findAllPatientsWithDiagnosis();

    @Query("SELECT COUNT(id) FROM Patient WHERE run = :run")
    Boolean findByRun(String run);
}
