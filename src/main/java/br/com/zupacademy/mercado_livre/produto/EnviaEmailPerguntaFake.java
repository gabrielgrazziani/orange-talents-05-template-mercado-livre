package br.com.zupacademy.mercado_livre.produto;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.zupacademy.mercado_livre.produto.entity.PerguntoProduto;

@Component
@Profile("dev")
public class EnviaEmailPerguntaFake implements EnviaEmailPergunta{

	@Override
	public void envia(PerguntoProduto pergunta) {
		String nomeCliente = pergunta.getConsumidor().getLogin();
		String tituloPergunta = pergunta.getTitulo();
		String nomeProduto = pergunta.getProduto().getNome();
		System.out.printf("Olá o cliente %s perguntou '%s' sobre o seu produto %s%n",nomeCliente,tituloPergunta,nomeProduto);
	}

}
