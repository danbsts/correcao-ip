package servicos;

public class TesteServicos {

	public static void main(String[] args) throws LimiteServicoAtingidoException, ServicoJaCadastradoException, ServicoNaoEncontradoException {
		RepositorioServicos repoteste = new RepositorioServicoArray();
		Servicos teste = new Servicos ("Oi", "1", 2);
		Servicos teste1 = new Servicos ("Oi", "2", 2);
		repoteste.inserir(teste1);
		repoteste.inserir(teste);
		System.out.println(repoteste.existe("1"));
		repoteste.remover("1");
		System.out.println(repoteste.existe("1"));
		Servicos procura = repoteste.procurar("2");
		System.out.println(procura.getNome() + " " + procura.getCodigo() + " " + procura.getPreco());
		Servicos att = new Servicos ("Ei", "2", 8);
		repoteste.atualizar(att);
		procura = repoteste.procurar("2");
		System.out.println(procura.getNome() + " " + procura.getCodigo() + " " + procura.getPreco());
		repoteste.inserir(teste);
		
		System.out.println("\n");
		
		RepositorioServicos repoteste1 = new RepositorioServicoLista();
		repoteste1.inserir(teste1);
		repoteste1.inserir(teste);
		System.out.println(repoteste1.existe("1"));
		repoteste1.remover("1");
		System.out.println(repoteste1.existe("1"));
		procura = repoteste1.procurar("2");
		System.out.println(procura.getNome() + " " + procura.getCodigo() + " " + procura.getPreco());
		att = new Servicos ("Ei", "2", 7);
		repoteste1.atualizar(att);
		procura = repoteste1.procurar("2");
		System.out.println(procura.getNome() + " " + procura.getCodigo() + " " + procura.getPreco());
		
		
		
		
		CadastroServicos cadastro = new CadastroServicos(repoteste);
		cadastro.cadastrar(teste);
	}

}
