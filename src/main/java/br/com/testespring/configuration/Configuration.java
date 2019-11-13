package br.com.testespring.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("testespring.mensagem")
public class Configuration {
	
	private String olaMensagem;
	private String olaMensagemdois;
	
	public String getOlaMensagem() {
		return olaMensagem;
	}
	public void setOlaMensagem(String olaMensagem) {
		this.olaMensagem = olaMensagem;
	}
	public String getOlaMensagemdois() {
		return olaMensagemdois;
	}
	public void setOlaMensagemdois(String olaMensagemdois) {
		this.olaMensagemdois = olaMensagemdois;
	}
	
	


	

	
	
	
	

}
