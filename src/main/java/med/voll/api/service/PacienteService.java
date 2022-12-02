package med.voll.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import med.voll.api.model.Paciente;
import med.voll.api.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private final PacienteRepository pacRepository;
	
	public PacienteService(PacienteRepository pacRepository) {
		this.pacRepository = pacRepository;
	}
	
	public List<Paciente> findAll(){
		return pacRepository.findAll();
	}
	
	public Paciente create(Paciente paciente) {
		return pacRepository.save(paciente);
	}
}
