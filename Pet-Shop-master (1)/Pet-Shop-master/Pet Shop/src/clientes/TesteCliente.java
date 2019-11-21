package clientes;

public class TesteCliente {
	public static void main (String[] args) throws ClienteNaoEncontradoException, ClienteJaCadastradoException, LimiteClientesAtingidoException {
		
		RepositorioClientes repoTeste = new RepositorioClientesLista();
		Clientes cliente = new Clientes ("thais", "95488", "99686660");
		repoTeste.inserir(cliente);
		Clientes novoCliente = new Clientes ("debora", "45472", "995672000");
		repoTeste.inserir(novoCliente);
		Clientes novoCliente2 = new Clientes ("nathalia", "74899", "999942444");
		repoTeste.inserir(novoCliente2);
		System.out.println(repoTeste.existe(novoCliente2.getCpf()));
		Clientes procura = repoTeste.procurar(novoCliente2.getCpf());
		System.out.println(procura.getNome() + ", " + procura.getCpf() 
				+ ", " + procura.getTelefone());
		Clientes procura2 = repoTeste.procurar(novoCliente.getCpf());
		System.out.println(procura2.getNome() + ", " + procura2.getCpf() 
				+ ", " + procura2.getTelefone());
		Clientes procura3 = repoTeste.procurar(cliente.getCpf());
		System.out.println(procura3.getNome() + ", " + procura3.getCpf() 
				+ ", " + procura3.getTelefone());
		repoTeste.remover("74899");
		System.out.println(repoTeste.existe(novoCliente2.getCpf()));
		Clientes novoCliente3 = new Clientes ("elinete", "45472", "998752022");
		repoTeste.atualizar(novoCliente3);
		System.out.println(repoTeste.existe(novoCliente2.getCpf()));
		Clientes procura4 = repoTeste.procurar(novoCliente3.getCpf());
		System.out.println(procura4.getNome() + ", " + procura4.getCpf() 
				+ ", " + procura4.getTelefone());
		Clientes procurar = repoTeste.procurar(novoCliente3.getCpf());
		System.out.println(procurar.getNome() + ", " + procurar.getCpf() 
				+ ", " + procurar.getTelefone() + ", " + procurar.getCredito());
		
		System.out.println();
		
		RepositorioClientes repoTeste2 = new RepositorioClientesArray();
		Clientes cliente2 = new Clientes ("thais", "95488", "99686660");
		repoTeste2.inserir(cliente2);
		Clientes novoCliente4 = new Clientes ("debora", "45472", "995672000");
		repoTeste2.inserir(novoCliente4);
		Clientes novoCliente5 = new Clientes ("nathalia", "74899", "999942444");
		repoTeste2.inserir(novoCliente5);
		System.out.println(repoTeste2.existe(novoCliente2.getCpf()));
		Clientes procura5 = repoTeste2.procurar(novoCliente2.getCpf());
		System.out.println(procura5.getNome() + ", " + procura5.getCpf() 
				+ ", " + procura5.getTelefone());
		Clientes procura6 = repoTeste2.procurar(novoCliente.getCpf());
		System.out.println(procura6.getNome() + ", " + procura6.getCpf() 
				+ ", " + procura6.getTelefone());
		Clientes procura7 = repoTeste2.procurar(cliente.getCpf());
		System.out.println(procura7.getNome() + ", " + procura7.getCpf() 
				+ ", " + procura7.getTelefone());
		repoTeste2.remover("74899");
		System.out.println(repoTeste2.existe(novoCliente5.getCpf()));
		Clientes novoCliente6 = new Clientes ("elinete", "45472", "998752022");
		repoTeste2.atualizar(novoCliente6);
		System.out.println(repoTeste2.existe(novoCliente5.getCpf()));
		Clientes procura8 = repoTeste2.procurar(novoCliente6.getCpf());
		System.out.println(procura8.getNome() + ", " + procura8.getCpf() 
				+ ", " + procura8.getTelefone());
		Clientes procurar2 = repoTeste.procurar(novoCliente6.getCpf());
		System.out.println(procurar2.getNome() + ", " + procurar2.getCpf() 
				+ ", " + procurar2.getTelefone() + ", " + procurar2.getCredito());
	}
}

