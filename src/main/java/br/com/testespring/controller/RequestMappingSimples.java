package br.com.testespring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.testespring.configuration.Configuration;

@RestController
public class RequestMappingSimples {
	
	@Autowired
	private Configuration configuration;
	
	

	//Método simples mapeando a solicitação HTTP para um método usando critérios básicos
	@RequestMapping( value="/metodo_simples_get",method=RequestMethod.GET)
	@ResponseBody
	public String getMetodoSimples() {
		return "Este e um metodo simples usando o verbo get";
	}
	
	//Método simples mapeando a solicitacao HTTP para o verbo POST
	@RequestMapping( value="/metodo_simples_get_carai",method=RequestMethod.GET)
	@ResponseBody
	public String postMetodoSimples() {
				
		return "Este e um metodo simples usando o verbo get " + configuration.getOlaMensagem() + 
				" caraiiii " + configuration.getOlaMensagemdois();
	}
	
}
