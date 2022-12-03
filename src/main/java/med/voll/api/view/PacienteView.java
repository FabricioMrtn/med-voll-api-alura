package med.voll.api.view;

import med.voll.api.model.Paciente;

public record PacienteView(String nome, String email, String cpf) {

	public PacienteView(Paciente paciente) {
		this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
	}
}
