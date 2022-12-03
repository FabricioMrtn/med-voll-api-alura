package med.voll.api.dto;

import med.voll.api.model.Paciente;

public record ListaPaciente(String nome, String email, String cpf) {

	public ListaPaciente(Paciente paciente) {
		this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
	}
}
