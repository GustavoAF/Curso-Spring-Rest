package br.com.testespring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestMappingSimplesComCabecalho {	
	
	//Método simples mapeando a solicitacao HTTP para o verbo get mas usando cabecalho
	@RequestMapping( value="/metodo_get_com_cabecalho",headers="key=val",method=RequestMethod.GET)
	@ResponseBody
	public String getComCabecalho() {
		return "Este é um metodo com cabecalho";
	}
	
	//Método get com vários cabecalhos no atributo header
	@RequestMapping( value="/metodo_get_com_varios_cabecalhos",headers= {"key=val","key2=val2"},method=RequestMethod.GET)
	@ResponseBody	
	public String getComVariosCabecalhos() {
		return "Este metodo possui varios cabecalho";
	}
	
	//Método get com cabeçalho Acept
	@RequestMapping ( value="/metodo_get_com_cabecalho_acept",headers="Accept=application/json",method=RequestMethod.GET)
	@ResponseBody
	public String getComAceptNoCabecalho() {
		return "Este metodo possui acept no cabecalho";
	}
	
	//Método get com cabeçalho produces
	@RequestMapping( value="/metodo_get_com_cabecalho_produces",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public String getComCabecalhoProduces() {
		return "Este metodo possui produces no cabecalho";
	}
	
	//Método get com varios cabeçalhos produces
	@RequestMapping( value="/metodo_get_com_cabecalho_varios_produces",method=RequestMethod.GET,produces={ "application/json", "application/xml" })
	@ResponseBody
	public String getComCabecalhoComVariosProduces() {
		return "Este metodo possui produces no cabecalho";
	}
	
}
