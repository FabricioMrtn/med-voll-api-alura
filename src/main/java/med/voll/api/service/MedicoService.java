package med.voll.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import med.voll.api.dto.AtualizaDadosMedico;
import med.voll.api.exceptions.MedicoNaoEncontradoException;
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
	
	@Transactional
	public Medico update(Long id, AtualizaDadosMedico adm) {
		Medico medico = medRepository.findById(id).orElseThrow(
				()-> new MedicoNaoEncontradoException(id));
		
		medico.setNome(adm.nome());
		medico.setTelefone(adm.telefone());
		medico.setEndereco(adm.endereco());
		medRepository.save(medico);
		return medico;
		
	}
	
	
}
