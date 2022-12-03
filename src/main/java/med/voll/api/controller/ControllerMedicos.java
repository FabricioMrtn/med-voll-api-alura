package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoDto;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class ControllerMedicos {

	@Autowired
	private MedicoRepository medRep;
	
	@GetMapping
	public Page<MedicoView> listar(Pageable paginacao) {
		return medRep.findAll(paginacao).map(MedicoView::new);
	}
	
	@PostMapping
	@Transactional
	public void create(@RequestBody @Valid MedicoDto dados) {
		medRep.save(new Medico(dados));
	}
	
}
