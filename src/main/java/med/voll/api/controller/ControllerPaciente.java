package med.voll.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.dto.PacienteDto;
import med.voll.api.model.Paciente;
import med.voll.api.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class ControllerPaciente {
	private final PacienteService pacServ;
	
	public ControllerPaciente(PacienteService pacServ) {
		this.pacServ = pacServ;
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<Paciente>> findAll(){
		List<Paciente> result = pacServ.findAll();
		return ResponseEntity.ok(result);
	}
		
	@PostMapping
	public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) {
		Paciente result = pacServ.create(paciente);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
}
 