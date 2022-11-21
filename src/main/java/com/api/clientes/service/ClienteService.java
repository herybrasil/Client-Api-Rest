package com.api.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.clientes.model.Cliente;
import com.api.clientes.model.MessageException;
import com.api.clientes.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	public MessageException messageException;	
	@Autowired
	public ClienteRepository acao;
	
	public ResponseEntity<?> save(Cliente obj){
		
		if(obj.getNome().equals("")) {
			messageException.setMensagem("O nome precisa ser preechido");
			return new ResponseEntity<>(messageException, HttpStatus.BAD_REQUEST);
		}else if (obj.getIdade() <0 ) {
			messageException.setMensagem("Informe uma idade válida");
			return new ResponseEntity<>(messageException, HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(acao.save(obj), HttpStatus.CREATED);
		}
	}
}
