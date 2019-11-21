package funcionarios;

public interface RepositorioFuncionarios {
	
	public void inserirFuncionarios(Funcionarios funcionario) 
			throws LimiteFuncionariosAtingidoException, FuncionarioJaCadastradoException;
		
	public void removerFuncionarios(String codigo) 
			throws FuncionarioNaoEncontradoException;
	
	public Funcionarios procurarFuncionarios(String codigo) 
			throws FuncionarioNaoEncontradoException;
	
	public void atualizarFuncionarios(Funcionarios funcionario) 
			throws FuncionarioNaoEncontradoException;
	
	public boolean existeFuncionario(String codigo);
}