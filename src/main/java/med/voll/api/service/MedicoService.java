package med.voll.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;

@Service
public class MedicoService {
	private final MedicoRepository medRepository;

	public MedicoService(MedicoRepository medRepository) {
		this.medRepository = medRepository;
	}
	
	public List<Medico> findAll(){
		return medRepository.findAll();
	}
	
	
	
}
