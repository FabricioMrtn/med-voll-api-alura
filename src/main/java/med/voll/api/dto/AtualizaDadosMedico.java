package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.model.Endereco;

public record AtualizaDadosMedico(
		@NotBlank
		String nome, 
		@NotBlank
		String telefone, 
		@NotNull
		@Valid
		Endereco endereco) {

}
