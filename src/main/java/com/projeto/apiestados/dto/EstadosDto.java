package com.projeto.apiestados.dto;



import java.util.List;
import java.util.stream.Collectors;

import com.projeto.apiestados.modelo.Estados;
import com.projeto.apiestados.modelo.Regiao;


public class EstadosDto {

	
	private int id;
	private String nome;
	private Regiao regiao;
	private long populacao;
	private String capital;
	private long area;
	
	
	public EstadosDto (Estados estado) {
		this.id = estado.getId();
		this.nome= estado.getNome();
		this.regiao= estado.getRegiao();
		this.area = estado.getArea();
		this.populacao= estado.getPopulacao();
		this.capital= estado.getCapital();
		}

	public int getId(){
		return id;
	}
	public String getNome (){
		return nome ;
	}
	public Regiao getRegiao (){
		return regiao;
	}
	public long getPopulacao (){
		return populacao;
	}
	public String getCapital () {
		return capital;
	}
	public long getArea (){
		return area;
	}

	public static List<EstadosDto> converter(List<Estados> estados) {
	
		return estados.stream().map(EstadosDto::new).collect(Collectors.toList());
	}
	}

