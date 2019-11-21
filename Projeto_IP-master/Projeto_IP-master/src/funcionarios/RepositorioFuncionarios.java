package funcionarios;

public interface RepositorioFuncionarios {
	public void inserirFuncionario(Funcionario funcionario);

	public void removerFuncionario(Funcionario funcionario);
	
	public void atualizarFuncionario(Funcionario funcionario);

	public boolean existeFuncionario(Funcionario funcionario);
	
	public String listarFuncionarios(String vazia);
	
	public Funcionario procurarFuncionario(String login, String senha);
}
