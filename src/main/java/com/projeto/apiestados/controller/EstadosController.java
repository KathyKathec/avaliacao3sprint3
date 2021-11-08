package com.projeto.apiestados.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.apiestados.dto.EstadosDto;
import com.projeto.apiestados.modelo.Estados;
import com.projeto.apiestados.modelo.Regiao;
import com.projeto.apiestados.repository.EstadosRepository;
import com.rojeto.apiestados.form.EstadosForm;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RequestMapping("/api/states")
public class EstadosController {
	
	@Autowired
	private EstadosRepository estadosRepository;
	@Enumerated(EnumType.STRING)
	private Regiao regiao;
	
	private Estados populacao;
	
	@GetMapping
	public List<EstadosDto> lista(Regiao regiao) {
		if (regiao == null) {
			List<Estados> estados = estadosRepository.findAll();
			return  EstadosDto.converter(estados);		
	
		} else  { List<Estados> estados = estadosRepository.findByRegiao(regiao);
		return  EstadosDto.converter(estados);			
		}                             
	}

	
	@PostMapping
	public ResponseEntity<EstadosDto> cadastrar (@RequestBody @Valid EstadosForm form, UriComponentsBuilder uriBuilder) {
		Estados estado = form.converter(estadosRepository);
		estadosRepository.save(estado);
		
			URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(estado.getId()).toUri();
	 
		return ResponseEntity.created(uri).body(new EstadosDto(estado));
	}	
	
	
	@GetMapping ("/{id}")
	public EstadosDto detalhar (@PathVariable int id) {
		Estados estados = estadosRepository.getOne(id);
		return new EstadosDto (estados);
		
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<EstadosDto> atualizar(@PathVariable int id, @RequestBody @Valid EstadosForm form ){
		Estados estado = form.atualizar(id,estadosRepository);
		
	return ResponseEntity.ok(new EstadosDto(estado));
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity<EstadosDto> remover (@PathVariable int id) {
		estadosRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	
	
	
}
