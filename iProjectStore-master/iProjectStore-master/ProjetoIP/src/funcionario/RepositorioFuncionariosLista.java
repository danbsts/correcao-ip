package funcionario;

public class RepositorioFuncionariosLista implements RepositorioFuncionarios {
	private Funcionarios funcionario;
	private RepositorioFuncionariosLista proximo;

	public RepositorioFuncionariosLista() {
		this.funcionario = null;
		this.proximo = null;
	}

	public void inserir(Funcionarios funcionario) {
		if (this.funcionario == null) {
			this.funcionario = funcionario;
			this.proximo = new RepositorioFuncionariosLista();
		} else
			this.proximo.inserir(funcionario);

	}

	public void remover(Funcionarios funcionario) {
		if (this.funcionario != null) {
			if (this.funcionario.getNome().equals(funcionario.getNome())) {
				this.funcionario = this.proximo.funcionario;
				this.proximo = this.proximo.proximo;
			} else
				this.proximo.remover(funcionario);
		}
	}

	public Funcionarios procurar(String cpf) {
		if (this.funcionario != null) {
			if (this.funcionario.getCpf().equals(cpf))
				return this.funcionario;
			else
				return this.proximo.procurar(cpf);
		} else
			return null;
	}

	public void atualizar(Funcionarios funcionario) throws FuncionarioInexistenteException {
		if (this.funcionario != null) {
			if (this.funcionario.getCpf().equals(funcionario.getCpf())) {
				this.funcionario = funcionario;
			} else
				this.proximo.atualizar(funcionario);
		}

	}

	public boolean existe(String cpf) {
		if (this.funcionario != null) {
			if (this.funcionario.getCpf().equals(cpf))
				return true;
			else
				return this.proximo.existe(cpf);
		}
		return false;
	}

}