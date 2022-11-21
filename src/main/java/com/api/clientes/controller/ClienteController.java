package com.api.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.clientes.model.Cliente;
import com.api.clientes.repository.ClienteRepository;
import com.api.clientes.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ClienteController {

	@Autowired
	private ClienteRepository acao;
	
	@Autowired
	private ClienteService clienteService;

	/* METODO SALVARS CLIENTES */
	@PostMapping("/clientes")
	@Operation(summary = "Save Client Method")
	public ResponseEntity<?> save(@RequestBody Cliente obj) {
		return clienteService.save(obj);
	}

	/* METODO LISTAR TODOS OS CLIENTES */
	@GetMapping("/clientes")
	@Operation(summary = "ListAll Clients Method")
	public List<Cliente> listAll() {
		return acao.findAll();
	}

	/* METODO SELECIONAR CLIENTE PELO CODIGO */
	@GetMapping("/clientes/{codigo}")
	@Operation(summary = "SelectById Client Method")
	public Cliente selectByCodigo(@PathVariable int codigo) {
		return acao.findByCodigo(codigo);
	}

	/* METODO ATUALIZAR CLIENTE */
	@PutMapping("/clientes")
	@Operation(summary = "Client UpDate Method")
	public Cliente update(@RequestBody Cliente obj) {
		return acao.save(obj);
	}

	/* METODO DELETAR CLIENTE PELO CODIGO */
	@DeleteMapping("/clientes/{codigo}")
	@Operation(summary = "DeleteById Client Method")
	public void delete(@PathVariable int codigo) {
		Cliente obj = selectByCodigo(codigo);
		acao.delete(obj);
	}

}
