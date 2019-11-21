package servicoDeEntrega;

public class RepositorioServicosEntregaLista implements RepositorioServicoEntrega {
	private ServicoDeEntrega frete;
	private RepositorioServicosEntregaLista proximo;

	public RepositorioServicosEntregaLista() {
		this.frete = null;
		this.proximo = null;
	}

	public ServicoDeEntrega getFrete() {
		return frete;
	}

	public RepositorioServicosEntregaLista getProximo() {
		return proximo;
	}

	public void inserirFrete(ServicoDeEntrega frete) {

		if (this.frete == null) {
			this.frete = frete;
			this.proximo = new RepositorioServicosEntregaLista();
		} else {
			this.proximo.inserirFrete(frete);
		}
	}

	public boolean existeFrete(int identificador) {
		boolean existeFrete = false;
		if (this.frete != null) {
			if (this.frete.equalsFrete(identificador)) {
				existeFrete = true;
			} else {
				this.proximo.existeFrete(identificador);
			}
		}
		return existeFrete;
	}

	public void removerFrete(int identificador) throws FreteInexistenteException {
		// TODO Auto-generated method stub

		if (this.frete != null) {
			if (this.frete.equalsFrete(identificador)) {
				this.frete = this.proximo.frete;
				this.proximo = this.proximo.proximo;
			} else {

				this.proximo.removerFrete(identificador);
			}
		} else {
			throw new FreteInexistenteException();
		}
	}

	@Override

	public ServicoDeEntrega procurarFrete(int identificador) throws FreteInexistenteException {
		// TODO Auto-generated method stub
		if (this.frete != null) {
			if (this.frete.equalsFrete(identificador)) {
				return this.frete;
			} else {
				return this.proximo.procurarFrete(identificador);
			}
		} else {
			throw new FreteInexistenteException();
		}

	}

	@Override

	public void atualizarFrete(int identificador, ServicoDeEntrega newFrete) throws FreteInexistenteException {
		// TODO Auto-generated method stub
		if (this.frete != null) {
			if (this.frete.equalsFrete(identificador)) {
				this.frete = newFrete;
			} else {
				this.proximo.atualizarFrete(identificador, newFrete);
			}
		} else {
			throw new FreteInexistenteException();
		}
	}
}
