package med.voll.api.model;

public class Medico {
	private String nome;
	private String email;
	private String telefone;
	private String crm;
	private Especialidade especialidade;
	private Endereco endereco;
	
	public Medico(String nome, String email, String telefone, String crm, Especialidade especialidade,
			Endereco endereco) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.crm = crm;
		this.especialidade = especialidade;
		this.endereco = endereco;
	}
	
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
