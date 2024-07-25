package cl.praxis.proyectohospitalpost.service;

import cl.praxis.proyectohospitalpost.entity.Patient;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBasedCRUD<T> {
    List<T> getAllPatients();
    T getPatientById(Long id);
    T insertPatient(T t);

    T updatePatient(T t, Long id);
    void DeletePatient(Long id);
    T findPatientWithDiagnosis(Long id);
    List<T> findAllPatientsWithDiagnosis();
}
