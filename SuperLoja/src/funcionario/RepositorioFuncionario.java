package funcionario;

public interface RepositorioFuncionario {
//S�o os Metodos da minha interface4
	public void inserir(Funcionario funcionario) throws FuncionarioCadastradoException;

	public void remover(String cpf) throws FuncionarioNaoExisteException;

	public Funcionario procurar(String cpf) throws FuncionarioNaoExisteException;

	public void atualizar(Funcionario funcionario) throws FuncionarioNaoExisteException;

	public boolean existe(String cpf);
//em lista funcionario � o tipo do atributo.
}
