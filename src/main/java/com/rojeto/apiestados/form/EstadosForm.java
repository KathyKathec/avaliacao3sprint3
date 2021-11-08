package com.rojeto.apiestados.form;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.projeto.apiestados.modelo.Estados;
import com.projeto.apiestados.modelo.Regiao;
import com.projeto.apiestados.repository.EstadosRepository;

public class EstadosForm {

	@NotNull @NotEmpty @Length (min = 4)
	private String nome;
	
	@Enumerated(EnumType.STRING) @NotEmpty
	private Regiao regiao;
	
	@NotNull @NotEmpty @Length (min = 5)
	private String capital;
	
    @NotEmpty @NotNull
	private Long area;
    @NotEmpty @NotNull
	private Long populacao;
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
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
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	
	
	
	public Estados converter(EstadosRepository estadosRepository) {
		Estados estados = estadosRepository.findBynome(nome);
		return new Estados (nome, area, capital, populacao, regiao);
	}
	public Estados atualizar(int id, EstadosRepository estadosRepository) {
		Estados estados = estadosRepository.getOne(id);
		estados.setArea(this.area);
		estados.setPopulacao(this.populacao);
		estados.setCapital(this.capital);
		estados.setRegiao(this.regiao);
		return estados;
	}
	
	

	
	

}
	
