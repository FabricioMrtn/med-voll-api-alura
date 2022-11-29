package med.voll.api.dto;

import med.voll.api.model.Endereco;
import med.voll.api.model.Especialidade;

public record MedicoDto(String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {

}
