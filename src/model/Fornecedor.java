package model;

public class Fornecedor {
	private int id;
	private String razao;//razão soccial
	private String fantasia;//noem fantasia
	private String cpf_cnpj;
	private String rg;
	private int telefone;
	
	public Fornecedor(int id, String razao, String fantasia, String cpf_cnpj, String rg, int telefone) {
		super();
		this.id = id;
		this.razao = razao;
		this.fantasia = fantasia;
		this.cpf_cnpj = cpf_cnpj;
		this.rg = rg;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazao() {
		return razao;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
