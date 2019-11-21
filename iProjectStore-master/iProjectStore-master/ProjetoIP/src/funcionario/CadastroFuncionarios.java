package funcionario;

public class CadastroFuncionarios {
	private RepositorioFuncionarios repositorioFuncionarios;

	public CadastroFuncionarios(RepositorioFuncionarios repositorioFuncionarios) {
		this.repositorioFuncionarios = repositorioFuncionarios;
	}

	public void cadastrarFuncionarios(Funcionarios funcionario) throws FuncionarioJaCadastradoException {
		if (!repositorioFuncionarios.existe(funcionario.getCpf()))
			repositorioFuncionarios.inserir(funcionario);
		else
			throw new FuncionarioJaCadastradoException();
	}

	public void removerFuncionarios(Funcionarios funcionario) throws FuncionarioInexistenteException {
		if (repositorioFuncionarios.existe(funcionario.getCpf()))
			repositorioFuncionarios.remover(funcionario);
		else
			throw new FuncionarioInexistenteException();
	}

	public void atualizarFuncioanrios(Funcionarios funcionario) throws FuncionarioInexistenteException {
		if (repositorioFuncionarios.existe(funcionario.getCpf()))
			repositorioFuncionarios.atualizar(funcionario);
		else
			throw new FuncionarioInexistenteException();
	}

	public Funcionarios procurarFuncionario(String cpf) throws FuncionarioInexistenteException {
		if (!repositorioFuncionarios.existe(cpf))
			throw new FuncionarioInexistenteException();
		
		else
		return repositorioFuncionarios.procurar(cpf);

	}

	public void inserir(Funcionarios funcionario) throws FuncionarioJaCadastradoException {
		this.repositorioFuncionarios.inserir(funcionario);
	}

	public void remover(Funcionarios funcionario) throws FuncionarioInexistenteException {
		this.repositorioFuncionarios.remover(funcionario);
	}

	public boolean existe(String cpf) {
		return this.repositorioFuncionarios.existe(cpf);
	}

	public Funcionarios procurar(String cpf) throws FuncionarioInexistenteException {
		return this.repositorioFuncionarios.procurar(cpf);
	}

	public void atualizar(Funcionarios funcionario) throws FuncionarioInexistenteException {
		this.repositorioFuncionarios.atualizar(funcionario);
	}
}