package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.dto.MedicoDto;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import med.voll.api.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class ControllerMedicos {

	@Autowired
	private MedicoRepository medRep;
//	private final MedicoService medService;

	
	@GetMapping
	public String hello() {
		return "pagina inicial";
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<Medico>> findAll(){
		List<Medico> result = medRep.findAll();
		return ResponseEntity.ok(result);		
	}
	
	@PostMapping
	public void create(@RequestBody MedicoDto dados) {
		medRep.save(new Medico(dados));
	}
	
}
