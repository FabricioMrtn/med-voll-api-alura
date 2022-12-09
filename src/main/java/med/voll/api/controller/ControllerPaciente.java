package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.AtualizaDadosMedico;
import med.voll.api.dto.AtualizaDadosPaciente;
import med.voll.api.dto.ListaPaciente;
import med.voll.api.dto.PacienteDto;
import med.voll.api.model.Paciente;
import med.voll.api.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class ControllerPaciente {
	
	@Autowired
	private PacienteRepository pacRep;
	
	@GetMapping
	public Page<ListaPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
		return pacRep.findAll(paginacao).map(ListaPaciente::new);
	}
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody PacienteDto dados) {
		pacRep.save(new Paciente(dados));
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid AtualizaDadosPaciente dados) {
		var paciente = pacRep.getReferenceById(dados.id());
		paciente.atualizar(dados);
	}
	
	@DeleteMapping
	@Transactional
	public void deletar(@RequestBody @Valid AtualizaDadosPaciente dados) {
		pacRep.deleteById(dados.id());
	}
}
 