package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.AtualizaDadosMedico;
import med.voll.api.dto.ListaMedico;
import med.voll.api.dto.MedicoDto;
import med.voll.api.exceptions.MedicoNaoEncontradoException;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;

@RestController
@RequestMapping("/medicos")
public class ControllerMedicos {

	@Autowired
	private MedicoRepository medRep;
	
	@GetMapping
	public Page<ListaMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
		return medRep.findAllByAtivoTrue(paginacao).map(ListaMedico::new);
	}
		
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid MedicoDto dados) {
		medRep.save(new Medico(dados));
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid AtualizaDadosMedico dados) {
		if(dados.id() == null) {
			throw new MedicoNaoEncontradoException(dados.id());
		}
		var medico = medRep.getReferenceById(dados.id());
		medico.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		var medico = medRep.getReferenceById(id);
		medico.desativar();
	}
	
}
