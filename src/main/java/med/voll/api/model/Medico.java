package med.voll.api.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Medico")
@Table(name="medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String crm;
	@Enumerated
	private Especialidade especialidade;
	@Embedded
	private Endereco endereco;
		
	@Override
	public String toString() {
		return "/n-------------------------------" 
				+ "/nNome: "+ this.nome 
				+ "/nE-mail: " + this.email 
				+ "/nCRM: " + this.crm 
				+ "/nEspecialidade: " + this.especialidade 
				+ "/n-------------------------------" ;
	}
	
}
