package funcionarios;


public class CadastroFuncionarios {
	private RepositorioFuncionarios colecaoFuncionarios;
	
	
	public CadastroFuncionarios(RepositorioFuncionarios repFuncionarios) {
		this.colecaoFuncionarios = repFuncionarios;
	}

	public String listar() throws NaoHaFuncionariosException {	
		if(colecaoFuncionarios.listarFuncionarios("").equals("")) {
			throw new NaoHaFuncionariosException();
		} else {
		return colecaoFuncionarios.listarFuncionarios("");
		}
	}

	
	public void cadastrar(Funcionario adicionado) throws FuncionarioJaCadastradoException {
		if(!colecaoFuncionarios.existeFuncionario(adicionado)) {
			colecaoFuncionarios.inserirFuncionario(adicionado);
		} else {
			throw new FuncionarioJaCadastradoException();
		}
		
	}

	public void remover(Funcionario demitido) throws FuncionarioNaoExistenteException {
		if(colecaoFuncionarios.existeFuncionario(demitido)) {
		colecaoFuncionarios.removerFuncionario(demitido);
		} else {
			throw new FuncionarioNaoExistenteException ();
		}
	}
	
	public void atualizar(Funcionario novo) {
		if(colecaoFuncionarios.existeFuncionario(novo))
		colecaoFuncionarios.atualizarFuncionario(novo);
	}
	public RepositorioFuncionarios getFuncionarios() {
		return this.colecaoFuncionarios;
	}
	
	
	public Funcionario procurar(String login, String senha) throws FuncionarioNaoExistenteException{
		Funcionario check = colecaoFuncionarios.procurarFuncionario(login, senha);
		if(check == null)
		throw new FuncionarioNaoExistenteException();
		else return check;
	}

}