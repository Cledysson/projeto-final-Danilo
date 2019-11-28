package br.usm.locadora.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Clientes {
	
	@Id
	private String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String data_nasc;
	
	@ManyToOne
	private Filmes filmes;
	
	public Clientes() {
		super();
	}
	
	public Clientes(String cpf, String nome, String telefone, String endereco, String data_nasc) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.data_nasc = data_nasc;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Filmes getFilmes() {
		return filmes;
	}

	public void setFilmes(Filmes filmes) {
		this.filmes = filmes;
	}
	
}
