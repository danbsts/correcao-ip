package funcionario;

public class CadastroFuncionario {
	private RepositorioFuncionario repositoriofuncionario;
// criei uma variavel e disse que ela é do tipo repositoriofuncionario(ou seja, do mesmo tipo do obj da minha interface)

	public CadastroFuncionario(RepositorioFuncionario repositorioarrayoulista) {
		repositoriofuncionario = repositorioarrayoulista;
		// repositoriofuncionario literalmente recebera o repositorio array ou lista,
		// vai depender do main

	}

	public void cadastrar(Funcionario funcionario) throws FuncionarioCadastradoException {
		if (repositoriofuncionario.existe(funcionario.getCpf()) == false) {
			repositoriofuncionario.inserir(funcionario);
		} else {
			throw new FuncionarioCadastradoException();
		}
	}

	public void remover(Funcionario funcionario) throws FuncionarioNaoExisteException {
		if (repositoriofuncionario.existe(funcionario.getCpf()) == false) {
			throw new FuncionarioNaoExisteException();
		} else {
			repositoriofuncionario.remover(funcionario.getCpf());
		}

	}

	public Funcionario procurar(String cpf) throws FuncionarioNaoExisteException {
		if (repositoriofuncionario.existe(cpf) == false) {
			throw new FuncionarioNaoExisteException();
		} else {
			return repositoriofuncionario.procurar(cpf);
		}
	}

	public void atualizar(Funcionario funcionario) throws FuncionarioNaoExisteException {
		if (repositoriofuncionario.existe(funcionario.getCpf()) == false) {
			throw new FuncionarioNaoExisteException();
		} else {
			repositoriofuncionario.atualizar(funcionario);
		}
	}

}