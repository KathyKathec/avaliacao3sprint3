package com.projeto.apiestados.modelo;

import java.time.*;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.xml.crypto.Data;

@Entity
public class Estados {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	
	@Enumerated(EnumType.STRING) 
	private Regiao regiao;
	private Long populacao;
	private String capital; 
	private Long area;
	
//	private int mes;
//	private int ano;
//	private int dia;
//	private LocalDate dataDeFundacao = LocalDate.of(ano,mes,dia);
//	private long tempoDesdeFundacao = ChronoUnit.YEARS.between(dataDeFundacao, LocalDate.now());

	public Estados () {
	}
	
	

	public Estados( String nome2, long area2, String capital2, long populacao2, Regiao regiao2) {
		
		this.area= area;
		this.capital=capital;
		this.nome = nome;
		this.populacao = populacao;
		this.regiao= regiao;
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


	public Regiao getRegiao() {
		return regiao;
	}


	public long getPopulacao() {
		return populacao;
	}


	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}

	
	public long getArea() {
		return area;
	}


	public void setArea(long area) {
		this.area = area;
	}



	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
}