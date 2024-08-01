package cl.praxis.proyectohospitalpost.service;
import cl.praxis.proyectohospitalpost.entity.Diagnosis;
import cl.praxis.proyectohospitalpost.entity.Patient;
import java.util.List;

public interface IPatientService {

    Boolean findBy(String run);
    Patient findPatientWithDiagnosis(Long id);
    List<Patient> findAllPatientsWithDiagnosis();

}
