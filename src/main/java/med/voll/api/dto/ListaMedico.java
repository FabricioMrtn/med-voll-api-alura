package med.voll.api.dto;

import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record ListaMedico(Long id, String nome, String crm, String email, Especialidade especialidade) {
	
	public ListaMedico(Medico medico) {
		this(medico.getId(),  medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade());
	}
}
