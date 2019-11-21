package funcionario;
public interface RepositorioFuncionarios {
	public void inserir(Funcionarios funcionario) throws FuncionarioJaCadastradoException;

	public void remover(Funcionarios funcionario) throws FuncionarioInexistenteException;

	public Funcionarios procurar(String cpf) throws FuncionarioInexistenteException;

	public void atualizar(Funcionarios funcionario) throws FuncionarioInexistenteException;

	public boolean existe(String cpf);

}
