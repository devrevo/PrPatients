package pr.patient.tpjpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pr.patient.tpjpa.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	public List<Patient> findByNameContains(String name);
	public List<Patient> findByMalade(boolean malade);
	public List<Patient> findByNameContainsAndMalade(String name,boolean malade);
	
}
