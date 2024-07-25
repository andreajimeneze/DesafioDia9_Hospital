package cl.praxis.proyectohospitalpost.service.impl;
import cl.praxis.proyectohospitalpost.entity.Patient;
import cl.praxis.proyectohospitalpost.repository.IDiagnosisRepository;
import cl.praxis.proyectohospitalpost.repository.IPatientRepository;
import cl.praxis.proyectohospitalpost.service.IBasedCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PatientService")
public class PatientService implements IBasedCRUD<Patient> {

    @Autowired
    private IPatientRepository patientRepository;
    private IDiagnosisRepository diagnosisRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient insertPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient, Long id) {
        Patient result = null;
        if(patient.getId() == id) {
            result = patientRepository.save(patient);
        }
        return result;
    }

    @Override
    public void DeletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient findPatientWithDiagnosis(Long id) {
        return patientRepository.findPatientWithDiagnosis(id);
    }

    @Override
    public List<Patient> findAllPatientsWithDiagnosis() {
        return patientRepository.findAllPatientsWithDiagnosis();
    }
}
