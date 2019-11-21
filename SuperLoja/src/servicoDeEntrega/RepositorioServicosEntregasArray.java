package servicoDeEntrega;

public class RepositorioServicosEntregasArray implements RepositorioServicoEntrega {
	private ServicoDeEntrega fretes[];
	private int indice;

	public RepositorioServicosEntregasArray() {
		fretes = new ServicoDeEntrega[30];
	}

	public void inserirFrete(ServicoDeEntrega frete) {
		// TODO Auto-generated method stub
		if (indice <= fretes.length) {
			fretes[indice] = frete;
			indice++;
		} else {
			ServicoDeEntrega aux[] = new ServicoDeEntrega[fretes.length];
			aux = fretes;
			fretes = new ServicoDeEntrega[fretes.length * 2];
			fretes = aux;
		}

	}

	public boolean existeFrete(int identificador) {
		// TODO Auto-generated method stub
		boolean existeFrete = false;
		for (int i = 0; i < fretes.length; i++) {
			if (fretes[i] != null) {
				if (fretes[i].equalsFrete(identificador)) {
					existeFrete = true;
				}
			}
		}
		return existeFrete;
	}

	@Override
	public void removerFrete(int identificador) throws FreteInexistenteException {
		// TODO Auto-generated method stub
		boolean removido = false;
		for (int i = 0; i < fretes.length; i++) {
			if (fretes[i] != null) {
				if (fretes[i].equalsFrete(identificador)) {
					fretes[i] = null;
					removido = true;
				}
			}
		}
		if (removido == false) {
			throw new FreteInexistenteException();
		}
	}

	@Override
	public ServicoDeEntrega procurarFrete(int identificador) throws FreteInexistenteException {
		// TODO Auto-generated method stub
		ServicoDeEntrega freteRetornado = null;
		for (int i = 0; i < fretes.length; i++) {
			if (fretes[i] != null) {
				if (fretes[i].equalsFrete(identificador)) {
					freteRetornado = fretes[i];
				}
			}
		}
		if (freteRetornado == null) {
			throw new FreteInexistenteException();
		} else {
			return freteRetornado;
		}
	}

	@Override
	public void atualizarFrete(int identificador, ServicoDeEntrega newFrete) throws FreteInexistenteException {
		// TODO Auto-generated method stub
		boolean atualizou = false;
		for (int i = 0; i < fretes.length; i++) {
			if (fretes[i]!=null) {
				if (fretes[i].equalsFrete(identificador)) {
					fretes[i] = newFrete;
					atualizou = true;
				}
			}	
		}
		if (atualizou == false) {
			throw new FreteInexistenteException();
		}
	}
}
