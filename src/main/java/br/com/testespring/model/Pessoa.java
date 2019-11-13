package br.com.testespring.model;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("ObjetoRaiz")//Anotação usada para alterar o nome da Raiz do objeto, anotação usada somente para Content Negociation em xml. Essa anotação 
                           //esta no pacote jackson declarada no Poom.xml
@Component  //Anotação usada para informar ao framework que este Bean deve ser gerenciado automaticamente pelo Spring, ou seja
            // no momento que a mesma for executada o Spring já instancia e guarda um objeto deste no container 
            //(ele não necessáriamento ainda é usado, só instanciado). Este conceito é chamado de IoC Inversion of Control ou Inversão de Controle
public class Pessoa {
	
	@JsonProperty("NomePrincipal")//Anotação responsável por formatar o atribulo que será exibido para o lado cliente, não será alterado o modelo de dominio do objeto
	                              //somente o que será visualizado no retorno. Essa anotação esta no pacote jackson declarada no Poom.xml
	private String nome;
	private int idade;
	private String sobrenome;
	@JsonIgnore //Anotação que faz com que essa propriedade não seja retornada no response. Essa anotação esta no pacote jackson declarada no Poom.xml
	private int id;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}
