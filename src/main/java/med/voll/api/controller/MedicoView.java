package med.voll.api.controller;

import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record MedicoView(String nome, String crm, String email, Especialidade especialidade) {
	
	public MedicoView(Medico medico) {
		this(medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade());
	}
}
