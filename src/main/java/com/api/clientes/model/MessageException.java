package com.api.clientes.model;

import org.springframework.stereotype.Component;

@Component
public class MessageException {

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
