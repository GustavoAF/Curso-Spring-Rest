package br.com.testespring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingComVariosMetodosECaminhos {
	
	//Mesma requisicao sendo chamada por mais de uma url
	@RequestMapping(value= {"/chamada_metodo_um","/chamada_metodo_dois"}, method = RequestMethod.GET)
	@ResponseBody
	public String getChamadaPorDuasURL(){
		return "Metodo sendo chamado por duas urls";
	}
	
	//mesmo metodo sendo chamado por dois verbos diferentes
	@RequestMapping(value = "/dois_metodos_mesma_url", method = {RequestMethod.PUT, RequestMethod.POST})
	@ResponseBody
	public String getPostNoMesmoMetodo() {
		return "Dois verbos no mesmo metodo";
	}
	
	//exemplo de metodo usando fallback não é preciso passar nenhuma url
	@RequestMapping(value = "*", method = RequestMethod.GET)
	@ResponseBody
	public String getMetodoFallback() {
		return "Metodo usando fallback";
	}
	
	//fallback usando dois verbos
	@RequestMapping(value = "*", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String getPostMetodoFallback() {
		return "Fallback usando dois verbos";
	}
}
