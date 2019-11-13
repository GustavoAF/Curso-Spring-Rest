package br.com.testespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.testespring.model.Pessoa;
import br.com.testespring.service.PessoaService;

@RequestMapping("/pessoa") //Esta anotação indica qual uri fará o mapeamento desse controlador, ou seja todas as requisições "/pessoa", vao cair nesse controlador

@RestController //Esta anotação é um resumo de duas anotaçoes que seriam @Controller e @ResponseBody, onde o @Controller indica que é um
				//controlador, utilizada para a camada de apresentação. Normalmente anotamos classes que representam a interação 
                //do usuário, como managed beans, actions e controllers, e @ResponseBody significa que esta classe retorna informações e a resposta é 
				//exatamente o return do método.
				//Usada para abreviar ou seja nao precisar usar duas anotações pode-se usar somente esta.
public class AnotacaoGetMappingComPathVariable {
	
	
	@Autowired //Anotação responsável por informar ao spring que a Classe AnotacaoGetMappingComPathVariable depende da Classe PessoaService, e por isso o framework
	           //deverá providenciar a instanciação desse objeto, todo controle dessa dependencia será feito pelo Spring e guardado no container.
			   //Nessa anotação também é possivel informar a prioridade da instanciação, que por default é true, ou seja essa dependencia é
			   //obrigatória, caso seja informado false (@Autowired(required=false)) significa que a instancia não é obrigatoria, caso o spring
			   //nao consiga instanciar não será exibido um erro, mas o tratamento deve ser feito pelo programador.
	private PessoaService pessoaService;
	
	@GetMapping(path = "/{idade}", //Esta anotação informa que requisições com o metodo Get para uri pessoa indicado na anotação @RequestMapping
						           //chegaram nesse método, que é um verbo Get ou seja uma consulta.
				produces = MediaType.APPLICATION_JSON_VALUE) //Anotação que diz que este metodo produz somente um formato especifico de conteúdo, no caso Json. Mas 
															 //é possivel especificar quantos quiser, basta coloca-los entre {}, é possivel ter mais de um metodo
															 //ou seja dois mapeamentos, um para cada retorno, o que irá especificar qual chamar seria o valor do Accept
														     //indicado no header na requisição.
	public ResponseEntity<Pessoa> getComGetMapping(@PathVariable("idade") Integer parametro){ //@PathVariable Anotação que possibilita obter o valor passado como parâmetro na uri 
													//da chamada do serviço mas não como um parametro que é passado apos o sinal de interrogação (?) e sim quando o valor
													//faz parte da uri. Quando o nome do parametro interno for o mesmo do passado na anotação @GetMapping não é necesssário
													//colocar o parametro na anotação @PathVariable do contrario é necessário porque a variavel interna tem um nome 
													//diferente do parametro passado na uri.
													//O objeto ResponseEntity permite customizar a resposta HTTP deixando o response com um formato mais programático
													//esse objeto representa uma resposta, onde entre <> (maior e menor) devemos definir o Tipo desse objeto.
										   

		HttpHeaders headers = new HttpHeaders();  //Objeto responsável por retornar informações no header do response
		headers.add(HttpHeaders.ACCEPT , "Json"); //necessário adicionar as mensagens no objeto, basicamente são constantes da classe HttpHeaders
		
		Pessoa pessoa = new Pessoa();
		pessoa = pessoaService.obterPessoa(parametro);
		
		if (pessoa.getIdade() < 1)
			return ResponseEntity.badRequest().build(); // É possível usar o objeto Response Entity de várias formas, neste modelo, podemos usar como shortcut, ou seja
														// como um atalho onde é passado o status diretamente como um método do objeto ResponseEntity
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(pessoa); // Nessa maneira, podemos invocar o método status, que requer uma constante do tipo
													   //inteiro como parametro, que representa o códido do status do HTTP. Caso o codigo seja um ok, é ncessário
													   //passar o o body do response, ou seja o corpo da mensagem de retorno, uma vez que o processamento teve sucesso.
	}
	
	

	@GetMapping(path = "/primeiro/{primeiro}/segundo/{segundo}", //Na anotação @GetMapping é possivel receber quantos parametros forem necessários
			    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getComDoisParametros(@PathVariable String primeiro, @PathVariable String segundo) { // No objeto ResponseEntity é necessário passar
												  //o tipo do objeto que será retornado, mas também é possível abstrair essa informação usando o <?>.
												  //Caso o nome do parametro da uri for igual o parametro do metodo, não é preciso passar nenhum parametro para a anotação @@PathVariable
		String resposta = "Parametros digitados Primeiro SobreNome "+ primeiro + ", Segundo Sobrenome " + segundo;
		
		return ResponseEntity.status(HttpStatus.OK).body(resposta);   
	}
}


