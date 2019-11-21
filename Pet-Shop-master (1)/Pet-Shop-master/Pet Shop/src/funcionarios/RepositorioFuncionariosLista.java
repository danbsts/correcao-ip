package funcionarios;

public class RepositorioFuncionariosLista implements RepositorioFuncionarios{
	private Funcionarios funcionario;
	private RepositorioFuncionariosLista proximo;

	public RepositorioFuncionariosLista() {
		this.funcionario = null;
		this.proximo = null;
	}


	public void inserirFuncionarios(Funcionarios funcionario) {
		if(this.funcionario==null) {
			this.funcionario=funcionario;
			this.proximo= new RepositorioFuncionariosLista(); 
		} else
			this.proximo.inserirFuncionarios(funcionario);
		
	}
	
	public void removerFuncionarios(String codigo) 
	throws FuncionarioNaoEncontradoException {
		if (this.funcionario!=null && this.funcionario.getCodigo().equals(codigo)) {
			this.funcionario = this.proximo.funcionario;
			this.proximo = this.proximo.proximo;
		} else if (this.proximo!=null)
			this.proximo.removerFuncionarios(codigo);
		else {
			FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException();
			throw e;
		}
	}

	public Funcionarios procurarFuncionarios(String codigo) 
			throws FuncionarioNaoEncontradoException {
		Funcionarios funcionarioProcurado = null;
		if(this.funcionario != null && this.funcionario.getCodigo().equals(codigo))
			funcionarioProcurado = this.funcionario;
		else if (this.proximo!=null)
			this.proximo.procurarFuncionarios(codigo);
		else {
			FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException();
			throw e;
		}
		
		return funcionarioProcurado;
	}

	public boolean existeFuncionario(String codigo) {
		if(this.funcionario!=null && this.funcionario.getCodigo().equals(codigo))
			return true;
		else if (this.proximo!=null)
			return this.proximo.existeFuncionario(codigo);
		else
			return false;
	}

	public void atualizarFuncionarios(Funcionarios funcionario) 
			throws FuncionarioNaoEncontradoException{
		if(this.funcionario != null && this.funcionario.getCodigo().equals(funcionario.getCodigo())) {
			this.funcionario = funcionario;
		}
		else if (this.funcionario == null) {
			FuncionarioNaoEncontradoException e = new FuncionarioNaoEncontradoException();
			throw e;
		}
		else {
			this.proximo.atualizarFuncionarios(funcionario);
		}
	}
}