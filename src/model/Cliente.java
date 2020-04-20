package model;

import java.sql.Date;

public class Cliente{
	/*-- Atributos --*/
	private int id;
	private String nome;
	private Date datNascimento;
	private String cpf;
	private String rg;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	/*-- Metódos Esoeciais: constructor, geter e seter --*/
	public Cliente(int id, String nome, Date datNascimento, String cpf, String rg, String endereco,
			String numero, String bairro, String cidade, String estado, String cep){
		this.id=id;
		this.nome=nome;
		this.datNascimento=datNascimento;
		this.cpf=cpf;
		this.rg=rg;
		this.endereco=endereco;
		this.numero=numero;
		this.bairro=bairro;
		this.cidade=cidade;
		this.estado=estado;
		this.cep=cep;
	}
	
	public Cliente(){
		
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public Date getDatNascimento(){
		return this.datNascimento;
	}
	
	public void setDatNascimento(Date datNascimento){
		this.datNascimento=datNascimento;
	}
	
	public String getCpf(){
		return this.cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf=cpf;
	}
	
	public String getRg(){
		return this.rg;
	}
	
	public void setRg(String rg){
		this.rg=rg;
	}
	
	public String getEndereco(){
		return this.endereco;
	}
	
	public void setEndereco(String endereco){
		this.endereco=endereco;
	}
	
	public String getNumero(){
		return this.numero;
	}
	
	public void setNumero(String numero){
		this.numero=numero;
	}
	
	public String getBairro(){
		return this.bairro;
	}
	
	public void setBairro(String bairro){
		this.bairro=bairro;
	}
	
	public String getCidade(){
		return this.cidade;
	}
	
	public void setCidade(String cidade){
		this.cidade=cidade;
	}
	
	public String getEstado(){
		return this.estado;
	}
	
	public void setEstado(String estado){
		this.estado=estado;
	}
	
	public String getCep(){
		return this.cep;
	}
	
	public void setCep(String cep){
		this.cep=cep;
	}
}