package servicos;

public class RepositorioServicoArray implements RepositorioServicos {
	private Servicos [] arrayServico;
	private int indice;
	
	public RepositorioServicoArray() {
		this.arrayServico = new Servicos [100];
		this.indice = 0;
	}
	
	public void inserir(Servicos servico) throws LimiteServicoAtingidoException {
		if (this.indice < this.arrayServico.length) {
			this.arrayServico [this.indice] = servico;
			indice ++;
		}
		else {
			LimiteServicoAtingidoException e = new LimiteServicoAtingidoException();
			throw e;
		}
	}
	
	public void remover(String codigo) throws ServicoNaoEncontradoException{
		boolean achou = false;
		for (int i = 0; i < 100; i ++) {
			if (this.arrayServico[i] != null && this.arrayServico[i].getCodigo().equals(codigo)) {
				this.arrayServico[i] = null;
				System.arraycopy(arrayServico, i + 1, this.arrayServico, i, this.arrayServico.length - 1 - i);
				this.indice --;
				achou = true;
				return;
			}
		}
		if (!achou) {
			ServicoNaoEncontradoException e = new ServicoNaoEncontradoException();
			throw e;
		}
	}

	public void atualizar(Servicos servico) throws ServicoNaoEncontradoException{
		boolean achou = false;
		for (int i = 0; i < 100; i ++) {
			if(this.arrayServico[i] != null && this.arrayServico[i].getCodigo().equals(servico.getCodigo())) {
				this.arrayServico[i] = servico;
				achou = true;
				return;
			}
		}
		if (!achou) {
			ServicoNaoEncontradoException e = new ServicoNaoEncontradoException();
			throw e;
		}
	}

	public Servicos procurar(String codigo) throws ServicoNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < 100; i ++) {
			if (this.arrayServico[i] != null && this.arrayServico[i].getCodigo().equals(codigo)) {
				achou = true;
				return this.arrayServico [i];
			}
		}
		if (!achou) {
			ServicoNaoEncontradoException e = new ServicoNaoEncontradoException();
			throw e;
		}
		return null;
	}

	public boolean existe(String codigo) {
		for (int i = 0; i < 100; i ++) {
			if (this.arrayServico[i] != null && this.arrayServico[i].getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
	}
}
