package model;

import java.sql.Date;

public class Produto {
	private int id;
	private String nome;
	private int estoque;
	private double precoVenda;
	private double precoCusto;
	private Date dataCompra;
	private Date dataVenda;
	
	private Marca marca;
	
	/*-- Metódos Esoeciais: constructor, geter e seter --*/
	public Produto(int id, String nome, int estoque, double precoVenda, double precoCusto, Date dataCompra, Date dataVenda, Marca marca)
	{
		this.id=id;
		this.nome=nome;
		this.estoque=estoque;
		this.precoVenda=precoVenda;
		this.precoCusto=precoCusto;
		this.dataCompra=dataCompra;
		this.dataVenda=dataVenda;
		this.marca=marca;
	}
	
	public Produto()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
	
	
}
