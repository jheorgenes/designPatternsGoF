package br.com.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.loja.orcamento.Orcamento;
import br.com.loja.pedido.acao.AcaoAposGerarPedido;

public class GeraPedidoHandler {

	private List<AcaoAposGerarPedido> acoes;

	// Sem o padrão Observer, seria utilizado várias injeções de dependências: repository, service, etc.
	public GeraPedidoHandler(List<AcaoAposGerarPedido> acoes) {
		this.acoes = acoes;
	}

	public void execute(GeraPedido dados) {
		Orcamento orcamento = new Orcamento(dados.getValorOrcamento(), dados.getQuantidadeItens());
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);

		// Padrão Observer - Está executando cada ação observável sem usar acoplamento (Sem necessariamente realizar um new NomeDaClasse)
		acoes.forEach(a -> a.executarAcao(pedido));
	}

}
