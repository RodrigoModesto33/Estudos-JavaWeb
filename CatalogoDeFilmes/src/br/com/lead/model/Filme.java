package br.com.lead.model;

public class Filme {
	private String nome;
	private String genero;
	private Integer ano;
	
	
	public Filme(String nome, String genero, Integer ano) {
		this.nome = nome;
		this.genero = genero;
		this.ano = ano;
	}


	public String getNome() {
		return nome;
	}

	public String getGenero() {
		return genero;
	}
	
	public Integer getAno() {
		return ano;
	}
	
}
