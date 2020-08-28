package com.br.alura.microservices.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.alura.microservices.loja.controller.dto.CompraDTO;
import com.br.alura.microservices.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate client;
	
	public void realizaCompra(CompraDTO compra) {
	
		//Realizando um get para o microservico fornecedor, configurado em 8081
		ResponseEntity<InfoFornecedorDTO> exchange = 
				client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(),
						HttpMethod.GET, null, InfoFornecedorDTO.class);
		
		System.out.println(exchange.getBody().getEndereco());
	}

}
