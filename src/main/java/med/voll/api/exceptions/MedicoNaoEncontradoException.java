package med.voll.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MedicoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MedicoNaoEncontradoException(Long id) {
			super("Dados do medico não foram encontrados com o id: " + id);
	}
	
}
