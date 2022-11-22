package br.com.loja.pedido.acao;

import br.com.loja.pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido {

	@Override
	public void executarAcao(Pedido pedido) {
		System.out.println("Enviando email com dados do pedido!");
	}
}
