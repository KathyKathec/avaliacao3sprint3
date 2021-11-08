package com.projeto.apiestados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.apiestados.modelo.Estados;
import com.projeto.apiestados.modelo.Regiao;

public interface EstadosRepository extends JpaRepository<Estados, Integer> {

	List<Estados> findByRegiao(Enum<Regiao> regiao);

	Estados findBynome(String nome);



	
}
