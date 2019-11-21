package pedidos;

public class RepositorioPedidosLista implements RepositorioPedidos {
	private Pedidos pedidos;
    private RepositorioPedidosLista proximo;
    public RepositorioPedidosLista(){
        
    }

	public void atualizar(Pedidos pedidos) throws PedidoNaoEncontradoException {
		//dar uma olhadinha no exception dele pq nao tem nada haver kkk
		// SE ESTIVER NO FIM DA LISTA
				if (this.pedidos == null) {
					// DE O ERRO --> PEDIDO NAO ENCONTRADO
					throw new PedidoNaoEncontradoException();
				} else {
					// SE O CODIGO DO PEDIDO EM QUE ESTOU FOR IGUAL AO CODIGO DO PEDIDO DO PARAMETRO
					if (this.pedidos.getCodigo().equals(pedidos.getCodigo())) {
						// ATUALIZE O PEDIDO
						this.pedidos = pedidos;
					} else {
						// SE NAO --> RECURSAO DO METODO NO PROXIMO
						this.proximo.atualizar(pedidos);
					}
				}
				
			}

	public void remover(String codigo) throws PedidoNaoEncontradoException {
//dar uma olhadinha no exception dele pq nao tem nada haver kkk
		// SE ESTIVER NO FIM DA LISTA
				if (this.pedidos == null) {
					// DE O ERRO --> PEDIDO NAO ENCONTRADO
					throw new PedidoNaoEncontradoException();
				} else {
					// SE O CODIGO DO PEDIDO EM QUE ESTOU FOR IGUAL AO CODIGO DO PEDIDO DO PARAMETRO
					if (this.pedidos.getCodigo().equals(codigo)) {
						// O PEDIDO EM QUE ESTOU RECEBE O PROXIMO
						this.pedidos = this.proximo.pedidos;
						// O PROXIMO RECEBE O PROXIMO
						this.proximo = this.proximo.proximo;
					} else {
						// SE NAO --> RECURSAO DO METODO NO PROXIMO
						this.proximo.remover(codigo);
					}
				}
	}
	
	public boolean existe( String codigo){
		// SE ESTIVER NO FIM DA LISTA
		if (this.pedidos == null) {
			// NAO ACHEI
			return false;
		} else {
			// SE O CODIGO DO PEDIDO EM QUE ESTOU FOR IGUAL AO CODIGO DO PEDIDO DO PARAMETRO
			if (this.pedidos.getCodigo().equals(codigo)) {
				return true;
			} else {
				// SE NAO --> RECURSAO DO METODO NO PROXIMO
				return this.proximo.existe(codigo);
			}
		}
	}

	public void inserir(Pedidos pedidos) {
		// SE ESTIVER NO FIM DA LISTA
				if (this.pedidos == null) {
					this.pedidos = pedidos;
					this.proximo = new RepositorioPedidosLista();
				} else {
					// SE NAO --> RECURSAO DO METODO NO PROXIMO
					this.proximo.inserir(pedidos);
				}
			}

	public Pedidos procurar(String codigo) throws PedidoNaoEncontradoException{
		//dar uma olhadinha no exception dele pq nao tem nada haver kkk
		// SE ESTIVER NO FIM DA LISTA
		if (this.pedidos == null) {
			// DE O ERRO --> PEDIDO NAO ENCONTRADO
			throw new PedidoNaoEncontradoException();
		} else {
			// SE O CODIGO DO PEDIDO EM QUE ESTOU FOR IGUAL AO CODIGO DO PEDIDO DO PARAMETRO
			if (this.pedidos.getCodigo().equals(codigo)) {
				// RETORNE O PEDIDO EM QUE ESTOU
				return this.pedidos;
			} else {
				// SE NAO --> RECURSAO DO METODO NO PROXIMO
				return this.proximo.procurar(codigo);
			}
		}
	}

}
