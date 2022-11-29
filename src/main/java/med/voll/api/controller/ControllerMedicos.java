package med.voll.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.model.Medico;

@RestController
@RequestMapping("/medicos")
public class ControllerMedicos {

//	private final service
	
	public ControllerMedicos(/**Service service**/) {
//		service
	}
	
	@GetMapping
	public ResponseEntity<Medico> findAll(){
		//List<Medico> result = service.findAll
		return null;//ResponseEntity.ok(result)
		
	}
	
	@PostMapping
	public ResponseEntity<Medico> create() {
//		service.create
		return null;
		
	}
	
}
