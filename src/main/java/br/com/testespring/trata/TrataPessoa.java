package br.com.testespring.trata;

import javax.inject.Named;

import br.com.testespring.model.Pessoa;

@Named  //Esta anoação pertence a especificação JSR-330, especificação suportada pelo Spring, a anotação @Named substituia a anotação @Component
public class TrataPessoa {
	
	public Pessoa TratandoPessoa(Pessoa pessoa){
		pessoa.setIdade(38);
		pessoa.setNome("Gustavo");
		pessoa.setSobrenome("Almeida Ferreira");
		return pessoa;
	}
}
