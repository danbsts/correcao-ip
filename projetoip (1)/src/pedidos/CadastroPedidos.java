package pedidos;
public class CadastroPedidos {
	RepositorioPedidos repositorioPedidos;
	//Definir as regras (valida��es) que permitem o cadastrar, remover, atualizar e procurar das classes.
public CadastroPedidos(RepositorioPedidos repositorioPedidos ) {
		this.repositorioPedidos=repositorioPedidos;
	}
public void cadastrar(Pedidos pedidos)throws  PedidoJaExistenteException,PedidoNaoEncontradoException,ValorInvalidoException {
		// SE JA EXISTIR UM PEDIDO COM ESSE CODIGO
		if(this.repositorioPedidos.existe(pedidos.getCodigo())){
			// DE O ERRO --> PEDIDO JA EXISTENTE
			throw new PedidoJaExistenteException();
		}else if(pedidos.getValor()<=0){
			throw new ValorInvalidoException();
			
		}else {
			this.repositorioPedidos.inserir(pedidos);
		}

	}

public void remover (String codigo) throws PedidoNaoEncontradoException {
	// ESSE METODO JA PODE DAR O ERRO ACIMA
	this.repositorioPedidos.remover(codigo);
}

public void atualizar(Pedidos pedidos) throws PedidoNaoEncontradoException, ValorInvalidoException{
	this.repositorioPedidos.atualizar(pedidos);
}
public Pedidos procurar (String codigo) throws PedidoNaoEncontradoException, ValorInvalidoException {
	// ESSE METODO JA PODE DAR O ERRO ACIMA
	return this.repositorioPedidos.procurar(codigo);
}


public boolean existe (String codigo) {
	return this.repositorioPedidos.existe(codigo);
}
}
