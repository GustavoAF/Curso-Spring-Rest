package br.com.testespring.service;

import org.springframework.stereotype.Service;
import br.com.testespring.model.Pessoa;

//Pacote service, criado para armazenar as classes que trabalham com a regra de negócios, ou seja o core do bussiness da aplicação.

@Service //Esta anotação é Utilizada para a camada de aplicação e negócio. Comumente usada para anotar classes que denotam 
         //serviços de aplicação e de regras de negócio. Essa é uma anotação definida como esteriótipo do framework. No geral
         //a prática de marcar uma classe com uma anotação do tipo esteriotipa não faz diferença para o Spring, mas além de ser uma 
         //boa pratica, semanticamente é muito importante para a arquitetura da aplicação e principalmente para o desenvolvedor.
	     //anotando a classe como @Service, não é necessário anota-la como @Component pois uma já esta anotada na outra.
public class PessoaService extends Pessoa{

	
	public Pessoa obterPessoa(int idade ) {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setId(13);
		pessoa.setIdade(idade);
		pessoa.setNome("Gustavo");	
		pessoa.setSobrenome("Ferreira");

		return pessoa;
	}
}
