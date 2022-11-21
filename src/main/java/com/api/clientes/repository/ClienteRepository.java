package com.api.clientes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.api.clientes.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

	List<Cliente> findAll();
	
	Cliente findByCodigo(int codigo);
}
