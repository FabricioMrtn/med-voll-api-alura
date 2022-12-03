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

import med.voll.api.dto.PacienteDto;
import med.voll.api.model.Paciente;
import med.voll.api.repository.PacienteRepository;
import med.voll.api.view.PacienteView;

@RestController
@RequestMapping("/pacientes")
public class ControllerPaciente {
	
	@Autowired
	private PacienteRepository pacRep;
	
	@GetMapping
	public Page<PacienteView> listar(Pageable paginacao){
		return pacRep.findAll(paginacao).map(PacienteView::new);
	}
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody PacienteDto dados) {
		pacRep.save(new Paciente(dados));
	}
}
 