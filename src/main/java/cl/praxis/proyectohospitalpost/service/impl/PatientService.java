package cl.praxis.proyectohospitalpost.service.impl;

import cl.praxis.proyectohospitalpost.entity.Diagnosis;
import cl.praxis.proyectohospitalpost.entity.Patient;
import cl.praxis.proyectohospitalpost.repository.IDiagnosisRepository;
import cl.praxis.proyectohospitalpost.repository.IPatientRepository;
import cl.praxis.proyectohospitalpost.service.IBasedCRUD;
import cl.praxis.proyectohospitalpost.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PatientService")
public class PatientService implements IBasedCRUD<Patient>, IPatientService {

    @Autowired
    private IPatientRepository patientRepo;
    @Autowired
    private IDiagnosisRepository diagnosisRepo;

    public PatientService(IPatientRepository patientRepo, IDiagnosisRepository diagnosisRepo){
        this.patientRepo = patientRepo;
        this.diagnosisRepo = diagnosisRepo;
    }

    @Override
    public List<Patient> getAll() {
        return patientRepo.findAll();
    }

    @Override
    public Patient getById(Long id) {
        return patientRepo.findById(id).orElse(null);
    }

    @Override
    public Patient insert(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        Diagnosis diagnosis = patient.getDiagnosis();
        if(diagnosis == null)  {
            return null;
        }
        return patientRepo.save(patient);
    }


    @Override
    public void delete(Long id) {
        Patient patient = getById(id);
        if(patient != null) {
            patientRepo.delete(patient);
        }
    }

    @Override
    public Boolean findBy(String run) {
        return patientRepo.findByRun(run);
    }

    @Override
    public Patient findPatientWithDiagnosis(Long id) {
        return patientRepo.findPatientWithDiagnosis(id);
    }

    @Override
    public List<Patient> findAllPatientsWithDiagnosis() {
        return patientRepo.findAllPatientsWithDiagnosis();
    }
}