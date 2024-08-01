package cl.praxis.proyectohospitalpost.service.impl;

import cl.praxis.proyectohospitalpost.entity.Diagnosis;
import cl.praxis.proyectohospitalpost.entity.Patient;
import cl.praxis.proyectohospitalpost.repository.IDiagnosisRepository;
import cl.praxis.proyectohospitalpost.service.IBasedCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DiagnosisService")
public class DiagnosisService implements IBasedCRUD<Diagnosis> {

    @Autowired
    private IDiagnosisRepository diagnosisRepo;

    public DiagnosisService(IDiagnosisRepository diagnosisRepo) {
        this.diagnosisRepo = diagnosisRepo;
    }

    @Override
    public List<Diagnosis> getAll() {
        return diagnosisRepo.findAll();
    }

    @Override
    public Diagnosis getById(Long id) {
        return diagnosisRepo.findById(id).orElse(null);
    }

    @Override
    public Diagnosis insert(Diagnosis diagnosis) {
        return diagnosisRepo.save(diagnosis);
    }

    @Override
    public Diagnosis update(Diagnosis diagnosis) {
        Patient patient = diagnosis.getPatient();
        if(patient == null) {
            return null;
        }
        return diagnosisRepo.save(diagnosis);
    }

    @Override
    public void delete(Long id) {
        diagnosisRepo.deleteById(id);
    }


    public void deleteDiagnosis(Diagnosis diagnosis) {

        diagnosisRepo.delete(diagnosis);
    }
}