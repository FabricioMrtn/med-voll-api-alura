package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.dto.PacienteDto;

@RestController
@RequestMapping("/paciente")
public class ControllerPaciente {
	
	@PostMapping
	public void create(@RequestBody PacienteDto paciente) {
		System.out.println(paciente);
	}
	
}
