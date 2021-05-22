package pr.patient.tpjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import pr.patient.tpjpa.entities.Patient;
import pr.patient.tpjpa.repositories.PatientRepository;

@SpringBootApplication
public class PrPatientApplication implements CommandLineRunner{

	@Autowired
	private PatientRepository patientRep;
	
	public static void main(String[] args) {
		SpringApplication.run(PrPatientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Page<Patient> pagePatients = patientRep.findAll(PageRequest.of(1, 2));
		System.out.println("Total page : "+pagePatients.getTotalPages());

	}

}
