package br.usm.locadora.repository;

import org.springframework.data.repository.CrudRepository;

import br.usm.locadora.model.Filmes;

public interface FilmesRepository extends CrudRepository<Filmes, String>{
	
	Filmes findByCodigo(long codigo);
	
}