package med.voll.api.model;

public class Endereco {
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro; 
	private String cidade; 
	private String uf;
	private String cep;
	
	public Endereco(String logradouro, String bairro, String cidade, String uf, String cep) {
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}
	
	
}
