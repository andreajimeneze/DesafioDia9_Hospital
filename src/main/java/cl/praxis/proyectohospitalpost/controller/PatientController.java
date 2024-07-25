package cl.praxis.proyectohospitalpost.controller;

import cl.praxis.proyectohospitalpost.service.impl.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("PatientController")
@RequestMapping("/patients")
public class PatientController {
    private final static Logger LOG = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/allpatients")
    public String getAllPatientsWhitDiagnosis(Model model) {
        model.addAttribute("patients", patientService.findAllPatientsWithDiagnosis());
        LOG.info("Se muestra la lista de pacientes con sus respectivos diagnósticos");
        return "patients";
    }


}
