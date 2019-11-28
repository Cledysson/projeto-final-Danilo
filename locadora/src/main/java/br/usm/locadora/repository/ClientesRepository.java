package br.usm.locadora.repository;

import org.springframework.data.repository.CrudRepository;

import br.usm.locadora.model.Clientes;
import br.usm.locadora.model.Filmes;

public interface ClientesRepository extends CrudRepository<Clientes, String>{
	
	Iterable<Clientes> findByFilmes(Filmes filmes);
	
}