package pr.patient.tpjpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pr.patient.tpjpa.entities.Patient;
import pr.patient.tpjpa.repositories.PatientRepository;

@Controller
public class PatientController {
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping(path = "/index")
	public String index(Model model){
		return "index";
	}
	
	
	@GetMapping(path = "/patients")
	public String list(Model model,
			@RequestParam(name="page" ,defaultValue = "0") int page, 
			@RequestParam(name="size" ,defaultValue = "10") int size)
	{
		Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(page, size));
		model.addAttribute("patients",pagePatients.getContent());
		model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
		model.addAttribute("currentPage",page);
		return "patients";
	}
	
}
