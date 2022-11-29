package med.voll.api.dto;

import med.voll.api.model.Endereco;

public record PacienteDto(String nome, String email, String telefone, String cpf, Endereco endereco) {

}
