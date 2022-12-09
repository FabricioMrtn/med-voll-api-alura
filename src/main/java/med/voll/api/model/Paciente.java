package med.voll.api.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.AtualizaDadosPaciente;
import med.voll.api.dto.PacienteDto;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	@Embedded
	private Endereco endereco;
	private boolean ativo;
	
	public Paciente() {}
	
	public Paciente(PacienteDto dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.cpf = dados.cpf();
		this.endereco = new Endereco(dados.endereco());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void atualizar(@Valid AtualizaDadosPaciente dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		if(dados.endereco() != null) {
			this.endereco.atualizar(dados.endereco());
		}
	}

	public void desativar() {
		this.ativo = false;		
	}
	
}
