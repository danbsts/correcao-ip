package funcionarios;


public class TesteFuncionario {
	public static void main(String[] args) throws LimiteFuncionariosAtingidoException, FuncionarioJaCadastradoException, FuncionarioNaoEncontradoException {
		RepositorioFuncionarios repo = new RepositorioFuncionariosArray();
		Funcionarios teste = new Funcionarios("Lorena", "123123", "123", "1", 251.8);
		Funcionarios teste1 = new Funcionarios("Gui", "12312", "123", "2", 251.8);
		repo.inserirFuncionarios(teste);
		repo.inserirFuncionarios(teste1);
		System.out.println(repo.existeFuncionario("1") + " " + repo.existeFuncionario("2"));
		repo.removerFuncionarios("1");
		System.out.println(repo.existeFuncionario("1") + " " + repo.existeFuncionario("2"));
		Funcionarios procura = repo.procurarFuncionarios("2");
		System.out.println(procura.getNome() + " " + procura.getCpf() + " " + procura.getCodigo() + " " + procura.getSalario() + " " + procura.getTelefone());
		teste1 = new Funcionarios("Lorena", "123123", "123", "2", 251.8);
		repo.atualizarFuncionarios(teste1);
		procura = repo.procurarFuncionarios("2");
		System.out.println(procura.getNome() + " " + procura.getCpf() + " " + procura.getCodigo() + " " + procura.getSalario() + " " + procura.getTelefone());
		repo.inserirFuncionarios(teste1);

		System.out.println("\n");
		
		RepositorioFuncionarios repo1 = new RepositorioFuncionariosLista();
		teste = new Funcionarios("Lorena", "123123", "123", "1", 251.8);
		teste1 = new Funcionarios("Gui", "12312", "123", "2", 251.8);
		repo1.inserirFuncionarios(teste);
		repo1.inserirFuncionarios(teste1);
		System.out.println(repo1.existeFuncionario("1") + " " + repo1.existeFuncionario("2"));
		repo1.removerFuncionarios("1");
		System.out.println(repo1.existeFuncionario("1") + " " + repo1.existeFuncionario("2"));
		procura = repo1.procurarFuncionarios("2");
		System.out.println(procura.getNome() + " " + procura.getCpf() + " " + procura.getCodigo() + " " + procura.getSalario() + " " + procura.getTelefone());
		teste1 = new Funcionarios("Lorena", "123123", "123", "2", 251.8);
		repo1.atualizarFuncionarios(teste1);
		procura = repo1.procurarFuncionarios("2");
		System.out.println(procura.getNome() + " " + procura.getCpf() + " " + procura.getCodigo() + " " + procura.getSalario() + " " + procura.getTelefone());
		repo1.inserirFuncionarios(teste1);
	}
}
