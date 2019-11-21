package entregador;

public class RepositorioEntregadoresArray implements RepositorioEntregadores {
	private Entregador[] entregadores;
	private int index;

	public RepositorioEntregadoresArray() {
		entregadores = new Entregador[0];
		index = 0;
	}

	public void inserirEntregador(Entregador entregador) throws EntregadorJaCadastroException {
		Entregador[] aux = new Entregador[index + 1];
		for (int i = 0; i <= index; i++) {
			if (i < index)
				aux[i] = entregadores[i];
			else if(i!=index&&entregadores[i].getCpf().equals(entregador.getCpf())) {
				i=index+1;
				throw new EntregadorJaCadastroException();
			}
			else
				aux[i] = entregador;
		}
		index++;
		entregadores = aux;
	}

	public void removerEntregador(String cpf) throws EntregadorNaoEncontradoException{
		if(index==0) {
			throw new EntregadorNaoEncontradoException();
		}
		Entregador[] aux = new Entregador[index - 1];
		boolean removeu = false;	
		for (int i = 0; i < index; i++) {
			if((!removeu&&index==1&&!entregadores[i].getCpf().equals(cpf))||(index>1&&!removeu&&i==index-1&&!entregadores[i+1].getCpf().equals(cpf))) {
				i++;
				throw new EntregadorNaoEncontradoException();
	        }
			else if (entregadores[i].getCpf().equals(cpf)||index==0) {
				removeu=true;
				if(i+1!=index)
				aux[i] = entregadores[i+1];
				i++;
			}
			else
				aux[i] = entregadores[i];
		}
		index--;
		entregadores=aux;
	}

	public boolean verificarEntregador(String cpf) {
		for (int i = 0; i < entregadores.length; i++) {
			if (entregadores[i].getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

	public Entregador procurarEntregador(String cpf) throws EntregadorNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < this.index && !achou; i++) {
			if (entregadores[i] != null && entregadores[i].getCpf().equals(cpf)) {
				achou = true;
				return entregadores[i];
			}
		}
		if (!achou) {
			throw new EntregadorNaoEncontradoException();
		}
		return null;
	}

	public void atualizarEntregador(Entregador entregador) throws EntregadorNaoEncontradoException {
		for (int i = 0; i < index; i++) {
			if (entregadores[i].getCpf().equals(entregador.getCpf())) {
				entregadores[i] = entregador;
				i=index;
			}
			else if (i == index - 1)
				throw new EntregadorNaoEncontradoException();
		}
}
}
