package med.voll.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.EnderecoDto;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Endereco {
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro; 
	private String cidade; 
	private String uf;
	private String cep;

	public Endereco(EnderecoDto dados) {
		this.logradouro = dados.logradouro();
		this.bairro = dados.bairro();
		this.cidade = dados.cidade();
		this.cep = dados.cep();
		this.uf = dados.uf();
		this.complemento = dados.complemento();
		this.numero = dados.numero();		
	}
	
}
