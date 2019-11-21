package pedidos;
public  class RepositorioPedidosArray implements RepositorioPedidos{
	private Pedidos[] pedidos;
	private int indice;
	
	// CONSTRUTOR DEFININDO O TAMANHO DO ARRAY PEDIDOS E INICIALIZANDO O INDICE COM 0
	public RepositorioPedidosArray(int tamanho) {
		pedidos = new Pedidos[tamanho];
		indice = 0;
	}

	public void remover(String codigo) throws  PedidoNaoEncontradoException {
			// INTEIRO (i) QUE ARMAZENA O VALOR DO INDICE PASSANDO O PARAMETRO (codigo)
			int i = this.getIndice(codigo);
			// SE ESSE (i) FOR == AO (this.indice) (INDICE DO ATRIBUTO) SIGNIFICA QUE CHEGOU AO FIM DO ARRAY
			if (i == this.indice) {
				// LOGO, DE O ERRO --> PEDIDO NAO ENCONTRADO
				throw new PedidoNaoEncontradoException();
			} else {
				this.indice--;
				// PEDIDOS DE INDICE (i) RECEBE PEDIDOS DE INDICE (this.indice) (INDICE DO ATRIBUTO)
				this.pedidos[i] = this.pedidos[this.indice];
				// PEDIDOS DE INDICE (this.indice) (INDICE DO ATRIBUTO) RECEBE NULL
				this.pedidos[this.indice] = null;
			}
		}
	
	public void atualizar(Pedidos pedidos) throws PedidoNaoEncontradoException {
		// INTEIRO (i) QUE ARMAZENA O VALOR DO INDICE PASSANDO UM CODIGO DE UM PEDIDO
		int i = this.getIndice(pedidos.getCodigo());
		// SE ESSE (i) FOR == AO (this.indice) (INDICE DO ATRIBUTO) SIGNIFICA QUE CHEGOU AO FIM DO ARRAY
		if (i == this.indice) {
			// LOGO, DE O ERRO --> PEDIDO NAO ENCONTRADO
			throw new PedidoNaoEncontradoException();
		} else {
			// PEDIDOS DE INDICE (i) RECEBE O PARAMETRO (pedidos)
			this.pedidos[i] = pedidos;
		}
	}	
	
	public boolean existe(String codigo){
		// INTEIRO (i) QUE ARMAZENA O VALOR DO INDICE PASSANDO O PARAMETRO (codigo)
		int i = this.getIndice(codigo);
		// RETORNE TRUE SE (i) FOR != DE (this.indice) (INDICE DO ATRIBUTO)
		return (i != this.indice);
	}
	

	public Pedidos procurar(String codigo) throws PedidoNaoEncontradoException {
		// VARIAVEL (procurado) DO TIPO (Pedido) INICIALIZADA COM NULL
				Pedidos procurado = null;
				// INTEIRO (i) QUE ARMAZENA O VALOR DO INDICE PASSANDO O PARAMETRO (codigo)
				int i = this.getIndice(codigo);
				// SE ESSE (i) FOR == AO (this.indice) (INDICE DO ATRIBUTO) SIGNIFICA QUE CHEGOU AO FIM DO ARRAY
				if (i == this.indice) {
					// LOGO, DE O ERRO --> PEDIDO NAO ENCONTRADO
					throw new PedidoNaoEncontradoException();
				} else {
					// VARIAVEL (procurado) RECEBE PEDIDOS DE INDICE (i)
					procurado = this.pedidos[i];
				}
				// NO FINAL RETORNE PROCURADO PODENDO SER NULL OU O PEDIDO PROCURADO
				return procurado;
			}
	
	
	public void inserir(Pedidos pedidos) {
		if (this.indice >= (this.pedidos.length)) {
			//atribuo o tamanho da string pedidos porem nao quer pegar
			Pedidos[]aux = new Pedidos [this.indice];
			aux = this.pedidos;
			this.indice++;
			this.pedidos = new Pedidos [this.indice];
			for (int i = 0; i < (this.indice-1); i++) {
				this.pedidos[i] = aux[i];
			}
			this.pedidos[this.indice-1] = pedidos;
		} else {
			// O ARRAY PEDIDOS DE INDICE (this.indice) RECEBE O PARAMETRO (pedidos)
			this.pedidos[this.indice] = pedidos;
			// ADICIONA 1 AO INDICE
			this.indice++;
		}
	}
	public int getIndice(String codigo) {
		String aux;
		int i = 0;
		boolean achou = false;
		// ENQUANTO NAO TIVER ACHADO O INDICE
		while ((!achou) && i < this.indice) {
			// AUX RECEBE O CODIGO DO PEDIDO DE INDICE (i)
			aux = pedidos[i].getCodigo();
			// SE ESTE CODIGO FOR IGUAL AO CODIGO DO PEDIDO (PARAMETRO)			
			if (aux.equals(codigo)) {
				// ACHOU
				achou = true;
			} else {
				// PROCURE NO PROXIMO INDICE DO ARRAY
				i++;
			}
		}
		// NO FINAL RETORNE O (i) QUE CORRESPONDERA AO INDICE DO PEDIDO PROCURADO 
		return i;
	}

		
	}
	
