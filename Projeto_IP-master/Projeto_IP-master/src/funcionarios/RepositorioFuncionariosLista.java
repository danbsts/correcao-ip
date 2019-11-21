package funcionarios;

public class RepositorioFuncionariosLista implements RepositorioFuncionarios {
	private Funcionario funcionario;
	private RepositorioFuncionariosLista prox;

	public RepositorioFuncionariosLista() {
		this.funcionario = null;
		this.prox = null;
	}

	public void inserirFuncionario(Funcionario funcionario) {
		if (this.funcionario == null) {
			this.funcionario = funcionario;
			this.prox = new RepositorioFuncionariosLista();
		} else {
			this.prox.inserirFuncionario(funcionario);
		}
	}

	public void removerFuncionario(Funcionario removido) {
		if (this.funcionario == removido) {
			this.funcionario = this.prox.funcionario;
			this.prox = this.prox.prox;
		} else {
			this.prox.removerFuncionario(removido);
		}
	}
	
	public void atualizarFuncionario(Funcionario novo) {
		if (this.funcionario.getCpf().equals(novo.getCpf())) {
			this.funcionario = novo;
			this.prox = this.prox.prox;
		} else {
			this.prox.removerFuncionario(novo);
		}
	}

	public boolean existeFuncionario(Funcionario procurado) {
		if (this.funcionario == null) {
			return false;
		} else if (this.funcionario.getCpf().equals(procurado.getCpf())) {
			return true;
		} else {
			return this.prox.existeFuncionario(procurado);
		}
	}
	
	
	
	public String listarFuncionarios(String parcial) {
		String res = "";
		if (this.funcionario == null) {
			res = parcial;
		} else {
			parcial += this.funcionario.getDados() + "\n";
			res = this.prox.listarFuncionarios(parcial);
		}
		return res;
	}

	public Funcionario procurarFuncionario(String login, String senha) {
		if (this.funcionario == null) {
			return null;
		} else if (this.funcionario.getLogin().equals(login)) {
			if(this.funcionario.getSenha().equals(senha))
			return this.funcionario;
		} else {
			return this.prox.procurarFuncionario(login, senha);
		}
		return null;
	}
}
