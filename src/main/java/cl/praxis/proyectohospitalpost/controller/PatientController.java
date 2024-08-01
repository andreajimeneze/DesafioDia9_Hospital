package cl.praxis.proyectohospitalpost.controller;

import cl.praxis.proyectohospitalpost.entity.Diagnosis;
import cl.praxis.proyectohospitalpost.entity.Patient;
import cl.praxis.proyectohospitalpost.service.impl.DiagnosisService;
import cl.praxis.proyectohospitalpost.service.impl.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {


    @Autowired
    private PatientService pService;

    @Autowired
    private DiagnosisService dService;

    private static final Logger LOG = LoggerFactory.getLogger(PatientController.class);
    // Constructor
    public PatientController(PatientService pService, DiagnosisService dService) {
        this.pService = pService;
        this.dService = dService;
    }

    // CRUD: MOSTRAR TODOS LOS PACIENTES CON SUS DIAGNÓSTICOS
    @GetMapping
    public String getAllPatients(Model model) {
        LOG.info("Mostrando listado de pacientes con sus diagnósticos");
        model.addAttribute("patients", pService.getAll());
        return "patients";
    }

    // RUTA FORMULARIO PARA AGREGAR NUEVO PACIENTE CON SU DIAGNÓSTICO
    @GetMapping("/new")
    public String showPatientForm(Model model, Patient patient) {
        Diagnosis diagnosis = new Diagnosis();
        patient.setDiagnosis(diagnosis);
        diagnosis.setPatient(patient);
        model.addAttribute("patient", patient);
        return "patient-form";
    }

    // CRUD CREAR NUEVO PACIENTE CON DIAGNÓSTICO
    @PostMapping("/new")
    public String addPatient(@ModelAttribute Patient patient) {
        try {
            LOG.info("Agregando nuevo paciente con su diagnóstico");
            Diagnosis diagnosis = patient.getDiagnosis();
            diagnosis.setPatient(patient);
            pService.insert(patient);
            return "redirect:/patients";
        } catch(Exception e) {
            LOG.warn("No se pudo agregar al nuevo paciente");
            e.printStackTrace();
            return "patient-form";
        }
    }

    // RUTA FORMULARIO DE EDICIÓN DE PACIENTE
    @PostMapping("/edit")
    public String showFormUpdate(@RequestParam Long id, Model model) {
        Patient patient = pService.getById(id);
        model.addAttribute("patient", patient);
        return "patient-form";
    }

    // CRUD ACTUALIZAR DATOS DEL PACIENTE
    @PutMapping("/edit")
    public String updatePatient(@RequestParam Long id, Patient patient) {
        try {
            LOG.info("Editando datos de un paciente");
            //patient.setId(id);
           patient.setDiagnosis(patient.getDiagnosis());
           //diagnosis.setPatient(patient);
            //dService.update(patient.getDiagnosis());
            pService.update(patient);

            return "redirect:/patients";

        } catch (Exception e) {
            LOG.warn("No se pudieron modificar los datos del paciente");
            e.printStackTrace();
            return "error";
        }
    }


    // CRUD ELIMINAR PACIENTE
    @PostMapping("/delete")
    public String deletePatient(@RequestParam Long id) {

        pService.delete(id);
        return "redirect:/patients";
    }
}
