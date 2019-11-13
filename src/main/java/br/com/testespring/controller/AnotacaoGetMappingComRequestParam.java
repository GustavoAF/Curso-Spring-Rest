package br.com.testespring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Esta anotação é um resumo de duas anotaçoes que seriam @Controller e @ResponseBody, onde o @Controller indica que é um
				 //controlador, utilizada para a camada de apresentação. Normalmente anotamos classes que representam a interação 
				 //do usuário, como managed beans, actions e controllers, e @ResponseBody significa que esta classe retorna informações e a resposta é 
				 //exatamente o return do método. Usada para abreviar ou seja nao precisar usar duas anotações pode-se usar somente esta.
public class AnotacaoGetMappingComRequestParam {
	
    
	@RequestMapping(value="/parametro_request_param",method = RequestMethod.GET) // A anotação @@RequestMapping não ncessariamente pode anotar uma classe como esta 
	                                           //exemplificado na classe AnotacaoGetMappingComPathVariable, para isso, basta passar o parametro value que indica qual
	                                           //é o caminho da uri, nessa anotação é possível também indicar o parametro method que será informado qual verbo http
	                                           //se refere. não sendo necessário usar a anotação @@GetMapping. 
	@ResponseBody //@ResponseBody significa que este método retorna informações e a resposta é exatamente o return do método. Apesar de não ser uma boa prática, essa 
				  //anotação não é obrigatoria, ou seja o metodo vai funcionar mesmo sem essa. Nesse caso foi colocado a anotações somente por questões didadicas
				  //uma vez que essa classe ja esta anotada como @@RestController que esta tambem já esta anotada como @@ResponseBody.
	public String getComRequestParamSimples(@RequestParam("id") long id) { //Nesse caso, o metodo não esta retornando o objeto ResponseEntity, isso é possível para o 
										//framework apesar de não ser uma boa pratica, uma vez que nao usando ResponseEntity, não é possível retornar os códigos
										//de retorno do http. A anotação @@RequestParam permite receber um parametro na requisição, mas esse parametro não será recebido
										//no final da uri como demonstrado na Classe AnotacaoGetMappingComPathVariable e sim, como um parametro Key, o consumidor
										//devera informar o nome do parametro seguido do valor.
		return "Usando a anotacao RequestParam " + id; // como dito anteriormente esse método não retorna um ResponseEntity, e sim uma String.
	}
	

	@RequestMapping(value="/parametro__request_com_requestparam_definido_na_assinatura", params = "id", method = RequestMethod.GET) //Na anotação @@RequestMapping
									// tambem é possível definir o parametro que seja recebido, atraves da propriedade params
	public String getParametroNaAssinatura(@RequestParam long id) {//Nesse caso o nome do parametro recebido pelo consumidor, possui o mesmo nome do parametro
									//usado no metodo interno. Isso faz com que não seja necessário a passagem de parametro para a anotação @RequestParam.  
		return "Retorno do parametro Id " + id; // como dito anteriormente esse método não retorna um ResponseEntity, e sim uma String.
	}
	

	@RequestMapping(value="/mais_de_um_parametro", params = {"Id","dois"}, method = RequestMethod.GET)
	@ResponseBody
	public String getMaisDeUmParametro(@RequestParam("Id") long Id) {
		return "Retorno com mais de um parametro que nao precisa ser usado " + Id;
	}
	
	
}
