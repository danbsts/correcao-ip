package funcionarios;

public class CadastroFuncionarios {
	private RepositorioFuncionarios repositorio;

	public CadastroFuncionarios (RepositorioFuncionarios repoFuncionario) {
		this.repositorio = repoFuncionario;
	}

	public void cadastrar (Funcionarios funcionario) 
			throws FuncionarioJaCadastradoException, LimiteFuncionariosAtingidoException{
		if(!this.repositorio.existeFuncionario(funcionario.getCodigo())) {
			this.repositorio.inserirFuncionarios(funcionario);
		} else {
			FuncionarioJaCadastradoException e = new FuncionarioJaCadastradoException();
			throw e;
		}
	}

	public void remover (String codigo) 
			throws FuncionarioNaoEncontradoException {
		this.repositorio.removerFuncionarios(codigo);
	}

	public Funcionarios procurar (String codigo) 
			throws FuncionarioNaoEncontradoException {
		return this.repositorio.procurarFuncionarios(codigo);
	}

	public boolean existe (String codigo) {
		return this.repositorio.existeFuncionario(codigo);
	}
	
	public void atualizar (Funcionarios funcionario) 
			throws FuncionarioNaoEncontradoException {
		this.repositorio.atualizarFuncionarios(funcionario);
	}
}
