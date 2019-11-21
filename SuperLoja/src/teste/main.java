package teste;

import java.util.Scanner;

import cliente.Cliente;
import cliente.ClienteExisteException;
import cliente.ClienteNAtualizadoException;
import cliente.ClienteNExisteException;
import cliente.ClienteNRemovidoException;
import cliente.RepositorioCliente;
import cliente.RepositorioClienteArray;
import fachada.Fachada;
import funcionario.Funcionario;
import funcionario.FuncionarioCadastradoException;
import funcionario.FuncionarioNaoExisteException;
import funcionario.RepositorioFuncionario;
import funcionario.RepositorioFuncionarioArray;
import produto.Produto;
import produto.ProdutoJaExistenteException;
import produto.ProdutoNaoAtualizadoException;
import produto.ProdutoNaoEncontradoException;
import produto.ProdutoNaoRemovidoException;
import produto.RepositorioProduto;
import produto.RepositorioProdutoArray;
import produto.RepositorioProdutosLista;
import servicoDeEntrega.FreteInexistenteException;
import servicoDeEntrega.FreteJaExistenteException;
import servicoDeEntrega.RepositorioServicoEntrega;
import servicoDeEntrega.RepositorioServicosEntregasArray;
import servicoDeEntrega.ServicoDeEntrega;
import venda.BuscaIdException;
import venda.InserirExistenteException;
import venda.RepositorioVenda;
import venda.RepositorioVendaArray;
import venda.Venda;
import venda.VendaNaoEncontradaException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		RepositorioServicoEntrega repositorioServicoEntrega = new RepositorioServicosEntregasArray();
		RepositorioCliente repositorioCliente = new RepositorioClienteArray();
		RepositorioFuncionario repositorioFuncionario = new RepositorioFuncionarioArray();
		//RepositorioProduto repositorioProduto = new RepositorioProdutoArray();
		RepositorioVenda repositorioVenda = new RepositorioVendaArray();
		RepositorioProduto repositorioProduto=new RepositorioProdutosLista();
		/*
		 * RepositorioServicoEntrega repositorioServicoEntrega=new
		 * RepositorioServicosEntregasArray(); RepositorioCliente
		 * repositorioCliente=null; RepositorioFuncionario repositorioFuncionario=null;
		 * RepositorioProduto repositorioProduto=null; RepositorioVenda
		 * repositorioVenda=null;
		 */
		int codigoMenu = 0;
		try {
			Fachada fachada = new Fachada(repositorioCliente, repositorioServicoEntrega, repositorioVenda,
					repositorioFuncionario,repositorioProduto);

			while (in.hasNextLine()) {
				System.out.println("***************************************************************************");
				System.out.println("                  	      ACESSO AO SISTEMA DA LOJA                         ");
				System.out.println("***************************************************************************");
				System.out.println("");
				System.out.println("* MENU: *");
				System.out.println("*1-Funcionario");
				System.out.println("*2-Cliente");
				System.out.println("*3-Produto");
				System.out.println("*4-Venda");
				System.out.println("*5-Servicos de Entrega");
				System.out.println();
				System.out.println("Digite o código do menu desejado:");
				codigoMenu = in.nextInt();

				switch (codigoMenu) {
				case 1:
					System.out.println("***************************************************************************");
					System.out.println("                   OPERAÇÕES RELACIONADAS À: FUNCIONARIOS                  ");
					System.out.println("***************************************************************************");
					System.out.println("* MENU: *");
					System.out.println("*1-Cadastrar novo funcionario");
					System.out.println("*2-Remover funcionario");
					System.out.println("*3-Atualizar cadastro de funcionario");
					System.out.println("*4-Procurar cadastro de funcionario");
					System.out.println();
					System.out.println("Digite o código da operação desejada:");
					int codigoOperacao = in.nextInt();
					if (codigoOperacao == 1) {
						System.out.println(" CADASTRO NOVO FUNCIONARIO: ");
						System.out.println("Nome do Funcionario: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						System.out.println("CPF do Funcionario: ");
						String cpf = in.nextLine();
						while (cpf.equals("")) {
							cpf = in.nextLine();
						}
						System.out.println("Salario do novo Funcionario: ");
						double salario = in.nextDouble();
						fachada.cadastrarfuncionario(new Funcionario(nome, cpf, salario));
						System.out.println("Funcionario cadastrado com Sucesso.");
					/*	try {
							fachada.cadastrarfuncionario(new Funcionario(nome, cpf, salario));
							System.out.println("Funcionario cadastrado com Sucesso.");

						} catch (FuncionarioCadastradoException FCE) {
							System.out.println(FCE.getMessage());
						}*/
					} else if (codigoOperacao == 2) {
						System.out.println(" REMOVER FUNCIONARIO: ");
						System.out.println("Nome do Funcionario: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						System.out.println("CPF do Funcionario: ");
						String cpf = in.nextLine();
						while (cpf.equals("")) {
							cpf = in.nextLine();
						}
						System.out.println("Salario do Funcionario: ");
						double salario = in.nextDouble();
						fachada.removerfuncionario(new Funcionario(nome, cpf, salario));
						System.out.println("Funcionario removido com Sucesso.");
						/*try {
							fachada.removerfuncionario(new Funcionario(nome, cpf, salario));
							System.out.println("Funcionario removido com Sucesso.");
						} catch (FuncionarioNaoExisteException FNE) {
							System.out.println(FNE.getMessage());
						}*/
					} else if (codigoOperacao == 3) {
						System.out.println(" ATUALIZAR FUNCIONARIO: ");
						System.out.println("Nome do Funcionario: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						System.out.println("CPF do Funcionario: ");
						String cpf = in.nextLine();
						while (cpf.equals("")) {
							cpf = in.nextLine();
						}
						System.out.println("Salario do Funcionario: ");
						double salario = in.nextDouble();
						fachada.atualizarfuncionario(new Funcionario(nome, cpf, salario));
						System.out.println("Funcionario atualizado com Sucesso.");
						/*try {
							fachada.atualizarfuncionario(new Funcionario(nome, cpf, salario));
							System.out.println("Funcionario atualizado com Sucesso.");
						} catch (FuncionarioNaoExisteException FNE) {
							System.out.println(FNE.getMessage());
						}*/
					} else if (codigoOperacao == 4) {
						System.out.println(" PROCURAR FUNCIONARIO: ");
						System.out.println("CPF do Funcionario: ");
						String cpf = in.nextLine();
						while (cpf.equals("")) {
							cpf = in.nextLine();
						}
						Funcionario funcionario = fachada.procurarfuncionario(cpf);
						System.out.println("Informacoes do Funcionario:");
						System.out.println("-" + funcionario.getNome());
						System.out.println("-" + funcionario.getCpf());
						System.out.println("-" + funcionario.getSalario());
						System.out.println("-" + funcionario.getBonus());
						/*try {
							Funcionario funcionario = fachada.procurarfuncionario(cpf);
							System.out.println("Informacoes do Funcionario:");
							System.out.println("-" + funcionario.getNome());
							System.out.println("-" + funcionario.getCpf());
							System.out.println("-" + funcionario.getSalario());
							System.out.println("-" + funcionario.getBonus());
						} catch (FuncionarioNaoExisteException FNE) {
							System.out.println(FNE.getMessage());
						}*/
					}
					break;

				case 2:
					System.out.println("***************************************************************************");
					System.out.println("                    OPERAÇÕES RELACIONADAS À: CLIENTES                     ");
					System.out.println("***************************************************************************");
					System.out.println("* MENU: *");
					System.out.println("*1-Cadastrar novo cliente ");
					System.out.println("*2-Remover cliente");
					System.out.println("*3-Atualizar cadastro de cliente");
					System.out.println("*4-Procurar cadastro de cliente");
					System.out.println();
					System.out.println("Digite o código da operação desejada:");
					codigoOperacao = in.nextInt();
					if (codigoOperacao == 1) {
						System.out.println(" CADASTRO NOVO CLIENTE: ");
						System.out.println("Nome do Cliente: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						System.out.println("CPF do Cliente: ");
						String cpf = in.nextLine();
						while (cpf.equals("")) {
							cpf = in.nextLine();
						}
						fachada.cadastrarCliente(new Cliente(nome, cpf));
						
						System.out.println("Cliente cadastrado com Sucesso.");
						/*try {
							fachada.cadastrarCliente(new Cliente(nome, cpf));
							
							System.out.println("Cliente cadastrado com Sucesso.");

						} catch (ClienteExisteException CEE) {
							System.out.println(CEE.getMessage());
						}*/
					} else if (codigoOperacao == 2) {
						System.out.println(" REMOVER CLIENTE: ");
						System.out.println("Nome do Cliente: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						System.out.println("CPF do Cliente: ");
						String cpf = in.nextLine();
						while (cpf.equals("")) {
							cpf = in.nextLine();
						}
						fachada.removerCliente(new Cliente(nome, cpf));
						System.out.println("Cliente removido com Sucesso.");
						/*try {
							fachada.removerCliente(new Cliente(nome, cpf));
							System.out.println("Cliente removido com Sucesso.");
						} catch (ClienteNRemovidoException CNEE) {
							System.out.println(CNEE.getMessage());
						}*/
					} else if (codigoOperacao == 3) {
						System.out.println(" ATUALIZAR CLIENTE: ");
						System.out.println("Nome do Cliente: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						System.out.println("CPF do Cliente: ");
						String cpf = in.nextLine();
						while (cpf.equals("")) {
							cpf = in.nextLine();
						}
						System.out.println("Nome atualizado: ");
						String nomeNovo = in.nextLine();
						while (nomeNovo.equals("")) {
							nomeNovo = in.nextLine();
						}
						System.out.println("CPF atualizado: ");
						String cpfNovo = in.nextLine();
						while (cpfNovo.equals("")) {
							cpfNovo = in.nextLine();
						}
						fachada.atualizarCliente(new Cliente(nome, cpf), new Cliente(nomeNovo, cpfNovo));
						
						System.out.println("Cliente atualizado com Sucesso.");
						/*try {
							fachada.atualizarCliente(new Cliente(nome, cpf), new Cliente(nomeNovo, cpfNovo));
							
							System.out.println("Cliente atualizado com Sucesso.");
						} catch (ClienteNAtualizadoException CNAE) {
							System.out.println(CNAE.getMessage());
						}*/
					} else if (codigoOperacao == 4) {
						System.out.println(" PROCURAR CLIENTE: ");
						System.out.println("Nome do Cliente: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						System.out.println("CPF do Cliente: ");
						String cpf = in.nextLine();
						while (cpf.equals("")) {
							cpf = in.nextLine();
						}
						Cliente cliente = fachada.buscarCliente(nome, cpf);
						System.out.println("Informacoes do Cliente:");
						System.out.println("-" + cliente.getNome());
						System.out.println("-" + cliente.getCpf());
						System.out.println("-" + cliente.getBonus());
						System.out.println("-" + cliente.getDesconto());
						/*try {
							Cliente cliente = fachada.buscarCliente(nome, cpf);
							System.out.println("Informacoes do Cliente:");
							System.out.println("-" + cliente.getNome());
							System.out.println("-" + cliente.getCpf());
							System.out.println("-" + cliente.getBonus());
							System.out.println("-" + cliente.getDesconto());
						} catch (ClienteNExisteException CNEE) {
							System.out.println(CNEE.getMessage());
						}*/
					}

					break;

				case 3:
					System.out.println("***************************************************************************");
					System.out.println("                    OPERAÇÕES RELACIONADAS À: PRODUTOS                     ");
					System.out.println("***************************************************************************");
					System.out.println("* MENU: *");
					System.out.println("*1-Cadastrar novo produto");
					System.out.println("*2-Remover produto");
					System.out.println("*3-Atualizar produto");
					System.out.println("*4-Procurar produto");
					System.out.println();
					System.out.println("Digite o código da operação desejada:");
					codigoOperacao = in.nextInt();
					if (codigoOperacao == 1) {
						System.out.println(" CADASTRO NOVO PRODUTO: ");
						System.out.println("Nome do Produto: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						System.out.println("Valor do produto: ");
						double valorProduto = in.nextDouble();
						System.out.println("Quantidade do produto: ");
						int quantidade = in.nextInt();
						System.out.println("Valor de compra: ");
						double valorCompra = in.nextDouble();
						System.out.println("Valor de venda: ");
						double valorVenda = in.nextDouble();
						Produto produto=new Produto(nome, valorProduto, quantidade, valorCompra, valorVenda);
						fachada.cadastrarProduto(produto);
						System.out.println("Produto cadastrado com Sucesso.");
						/*try {
							fachada.cadastrarProduto(produto);
							System.out.println("Produto cadastrado com Sucesso.");
						} catch (ProdutoJaExistenteException PJEE) {
							System.out.println(PJEE.getMessage());
						}*/
					} else if (codigoOperacao == 2) {
						System.out.println(" REMOVER PRODUTO: ");
						System.out.println("Nome do produto: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						fachada.RemoverProduto(nome);
						System.out.println("Produto removido com Sucesso.");
						/*try {
							fachada.RemoverProduto(nome);
							System.out.println("Produto removido com Sucesso.");
						} catch (ProdutoNaoRemovidoException PNRE) {
							System.out.println(PNRE.getMessage());
						}*/
					} else if (codigoOperacao == 3) {
						System.out.println(" ATUALIZAR PRODUTO: ");
						System.out.println("Nome do produto: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						System.out.println("Nome atualizado: ");
						String nomeNovo = in.nextLine();
						while (nomeNovo.equals("")) {
							nomeNovo = in.nextLine();
						}
						System.out.println("Valor do produto atualizado: ");
						double valorProdutoNovo = in.nextDouble();
						System.out.println("Quantidade do produto: ");
						int quantidadeNovo = in.nextInt();
						System.out.println("Valor de compra novo: ");
						double valorCompraNovo = in.nextDouble();
						System.out.println("Valor de venda novo: ");
						double valorVendaNovo = in.nextDouble();
						fachada.AtualizarProduto(new Produto(nomeNovo, valorProdutoNovo, quantidadeNovo,
								valorCompraNovo, valorVendaNovo), nome);
						System.out.println("Produto atualizado com Sucesso.");
					/*	try {
							fachada.AtualizarProduto(new Produto(nomeNovo, valorProdutoNovo, quantidadeNovo,
									valorCompraNovo, valorVendaNovo), nome);
							System.out.println("Produto atualizado com Sucesso.");
						} catch (ProdutoNaoAtualizadoException PNAE) {
							System.out.println(PNAE.getMessage());
						}*/
					} else if (codigoOperacao == 4) {
						System.out.println(" PROCURAR PRODUTO: ");
						System.out.println("Nome do produto: ");
						String nome = in.nextLine();
						while (nome.equals("")) {
							nome = in.nextLine();
						}
						Produto produto = fachada.ProcurarProduto(nome);
						System.out.println("Informacoes do Produto:");
						System.out.println("-" + produto.getNome_Produto());
						System.out.println("-" + produto.getValor());
						System.out.println("-" + produto.getQuantidade());
						System.out.println("-" + produto.getValor_de_Compra());
						System.out.println("-" + produto.getValor_de_venda());
						/*try {
							Produto produto = fachada.ProcurarProduto(nome);
							System.out.println("Informacoes do Produto:");
							System.out.println("-" + produto.getNome_Produto());
							System.out.println("-" + produto.getValor());
							System.out.println("-" + produto.getQuantidade());
							System.out.println("-" + produto.getValor_de_Compra());
							System.out.println("-" + produto.getValor_de_venda());
						} catch (ProdutoNaoEncontradoException PNEE) {
							System.out.println(PNEE.getMessage());
						}*/
					}

					break;

				case 4:
					System.out.println("***************************************************************************");
					System.out.println("                    OPERAÇÕES RELACIONADAS À: VENDA                    ");
					System.out.println("***************************************************************************");
					System.out.println("* MENU: *");
					System.out.println("*1-Cadastrar nova venda");
					System.out.println("*2-Atualizar venda");
					System.out.println("*3-Procurar venda");
					System.out.println();
					System.out.println("Digite o código da operação desejada:");
					codigoOperacao = in.nextInt();
					if (codigoOperacao == 1) {
						int idVenda = 0;
						System.out.println(" CADASTRO NOVA VENDA: ");
						String nomeProduto = "";
						System.out.println("Informe a quantidade de produtos: ");
						int qtdProduto = in.nextInt();
						RepositorioProduto carrinho = new RepositorioProdutosLista();
						int contador = 0;
						while (contador < qtdProduto) {
							System.out.println("Informe a quantidade do produto e o nome do mesmo à ser inserido na venda:(ex: 7(enter seguido de)Sabão )");
							//int quantidade =Integer.parseInt(in.nextLine().trim());
							int quantidade =in.nextInt();
							nomeProduto=in.nextLine();
							nomeProduto = in.nextLine().trim();
							if (fachada.ExisteProduto(nomeProduto)
									&& fachada.ProcurarProduto(nomeProduto).getQuantidade() >= quantidade) {
								Produto aux = fachada.ProcurarProduto(nomeProduto);
								Produto produto = new Produto(aux.getNome_Produto(), aux.getValor(), quantidade,
										aux.getValor_de_Compra(), aux.getValor_de_venda());
								carrinho.cadastrarProduto(produto);
								fachada.ProcurarProduto(nomeProduto).setQuantidade(aux.getQuantidade() - quantidade);
							} else {
								System.out.println("Produto ou quantidade inválida");
							}
							contador++;
						}
						System.out.println("CPF do funcionario da venda: ");
						String cpf = in.nextLine();
						while (cpf.equals("")) {
							cpf = in.nextLine();
						}
						Funcionario funcionario = fachada.procurarfuncionario(cpf);
						System.out.println("Nome do cliente da venda: ");
						String nomeCliente = in.nextLine();
						while (nomeCliente.equals("")) {
							nomeCliente = in.nextLine();
						}
						System.out.println("CPF do cliente da venda: ");
						String cpfCliente = in.nextLine();
						while (cpfCliente.equals("")) {
							cpfCliente = in.nextLine();
						}
						Cliente cliente = fachada.buscarCliente(nomeCliente, cpfCliente);
						Venda venda = new Venda(cliente, funcionario, carrinho, idVenda, repositorioFuncionario,
								repositorioCliente);
						fachada.cadastrarVenda(venda, repositorioCliente, repositorioFuncionario);
						System.out.println("Venda cadastrada com Sucesso.");
						/*try {
							fachada.cadastrarVenda(venda, repositorioCliente, repositorioFuncionario);
							System.out.println("Produto cadastrado com Sucesso.");

						} catch (InserirExistenteException IEE) {
							System.out.println(IEE.getMessage());
						}*/
					} else if (codigoOperacao == 2) {
						System.out.println(" ATUALIZAR VENDA: ");
						System.out.println("Informe ID da venda: ");
						int idVenda = in.nextInt();
						System.out.println("Dados da venda nova: ");
						String nomeProduto = "";
						System.out.println("Informe a quantidade de produtos: ");
						int qtdProduto = in.nextInt();
						RepositorioProduto carrinho = new RepositorioProdutosLista();
						int contador = 0;
						while (contador < qtdProduto) {
							System.out.println(
									"Informe a quantidade do produto e o nome do mesmo à ser inserido na venda:(ex: 7 Sabão )");
							int quantidade = in.nextInt();
							nomeProduto = in.nextLine().trim();
							if (fachada.ExisteProduto(nomeProduto)
									&& fachada.ProcurarProduto(nomeProduto).getQuantidade() >= quantidade) {
								Produto aux = fachada.ProcurarProduto(nomeProduto);
								Produto produto = new Produto(aux.getNome_Produto(), aux.getValor(), quantidade,
										aux.getValor_de_Compra(), aux.getValor_de_venda());
								carrinho.cadastrarProduto(produto);
								fachada.ProcurarProduto(nomeProduto).setQuantidade(aux.getQuantidade() - quantidade);
							} else {
								System.out.println("Produto ou quantidade inválida");
							}
							contador++;
						}
						System.out.println("CPF do funcionario da venda: ");
						String cpf = in.nextLine();
						while (cpf.equals("")) {
							cpf = in.nextLine();
						}
						Funcionario funcionario = fachada.procurarfuncionario(cpf);
						System.out.println("Nome do cliente da venda: ");
						String nomeCliente = in.nextLine();
						while (nomeCliente.equals("")) {
							nomeCliente = in.nextLine();
						}
						System.out.println("CPF do cliente da venda: ");
						String cpfCliente = in.nextLine();
						while (cpfCliente.equals("")) {
							cpfCliente = in.nextLine();
						}
						Cliente cliente = fachada.buscarCliente(nomeCliente, cpfCliente);
						Venda vendaAtualizada = new Venda(cliente, funcionario, carrinho, idVenda,
								repositorioFuncionario, repositorioCliente);
						fachada.atualizarVenda(fachada.buscarVenda(idVenda), vendaAtualizada);
						System.out.println("Produto atualizado com Sucesso.");

						/*try {
							fachada.atualizarVenda(fachada.buscarVenda(idVenda), vendaAtualizada);
							System.out.println("Produto atualizado com Sucesso.");
						} catch (VendaNaoEncontradaException VNAE) {
							System.out.println(VNAE.getMessage());
						}*/
					} else if (codigoOperacao == 3) {
						System.out.println(" PROCURAR VENDA: ");
						System.out.println("ID da venda a procurar: ");
						int id = in.nextInt();
						Venda vendaProcurada = fachada.buscarVenda(id);
						System.out.println("Informacoes da Venda:");
						System.out.println("-" + vendaProcurada.getCliente());
						System.out.println("-" + vendaProcurada.getFuncionario());
						System.out.println("-" + vendaProcurada.getId());
					/*	try {
							Venda vendaProcurada = fachada.buscarVenda(id);
							System.out.println("Informacoes da Venda:");
							System.out.println("-" + vendaProcurada.getCliente());
							System.out.println("-" + vendaProcurada.getFuncionario());
							System.out.println("-" + vendaProcurada.getId());
						} catch (BuscaIdException BIDE) {
							System.out.println(BIDE.getMessage());
						}*/
					}
					break;
					
				case 5:
					System.out.println("***************************************************************************");
					System.out.println("                  OPERAÇÕES RELACIONADAS A: SERVIÇO DE ENTREGA             ");
					System.out.println("***************************************************************************");
					System.out.println("* MENU: *");
					System.out.println("*1-Cadastrar novo frete");
					System.out.println("*2-Atualizar frete");
					System.out.println("*3-Procurar frete");
					System.out.println();
					System.out.println("Digite o código da operação desejada:");
					codigoOperacao = in.nextInt();
					int idFrete=0;
					if (codigoOperacao == 1) {
						int idVenda = 0;
						System.out.println(" CADASTRO NOVO SERVIÇO DE ENTREGA: ");		
						System.out.println("Informe a Distancia do frete: ");
						int distancia  = in.nextInt();
						System.out.println("Informe o tipo do frete: ");
						System.out.println("*1-Normal");
						System.out.println("*2-Ligeiro");
						System.out.println("*3-Very Fast");
						int tipoFreteCodigo=in.nextInt();
						String tipoFrete="";
						switch (tipoFreteCodigo) {
						case 1:
							tipoFrete="Normal";
							break;
						case 2:
							tipoFrete="Ligeiro";
							break;
						case 3:
							tipoFrete="Very Fast";
							break;
						default:
							break;
						}
						System.out.println("Informe o ID da venda a ser entregue: ");
						 idVenda=in.nextInt();
						 Venda vendaFrete=fachada.buscarVenda(idVenda);
						 ServicoDeEntrega frete=new ServicoDeEntrega(distancia, vendaFrete, tipoFrete, idFrete);
							fachada.cadastrarServicoDeEntrega(frete);
							System.out.println("Frete cadastrado com Sucesso.");
						/*try {
							fachada.cadastrarServicoDeEntrega(frete);
							System.out.println("Frete cadastrado com Sucesso.");

						} catch (FreteJaExistenteException FJEE) {
							System.out.println(FJEE.getMessage());
						}*/
					} else if (codigoOperacao == 2) {
						System.out.println(" ATUALIZAR SERVIÇO DE ENTREGA: ");
						System.out.println("Informe ID do frete: ");
						 idFrete=in.nextInt();
						int idVenda=0;
						System.out.println("Dados do frete novo: ");
						System.out.println("Informe a Distancia do frete: ");
						int distancia  = in.nextInt();
						System.out.println("Informe o tipo do frete: ");
						System.out.println("*1-Normal");
						System.out.println("*2-Ligeiro");
						System.out.println("*3-Very Fast");
						int tipoFreteCodigo=in.nextInt();
						String tipoFrete="";
						switch (tipoFreteCodigo) {
						case 1:
							tipoFrete="Normal";
							break;
						case 2:
							tipoFrete="Ligeiro";
							break;
						case 3:
							tipoFrete="Very Fast";
							break;
						default:
							break;
						}
						System.out.println("Informe o ID da venda a ser entregue: ");
						 idVenda=in.nextInt();
						 Venda vendaFrete=fachada.buscarVenda(idVenda);
						 ServicoDeEntrega freteNovo=new ServicoDeEntrega(distancia, vendaFrete, tipoFrete, idFrete);
							fachada.atualizarServicoDeEntrega(idFrete, freteNovo);
							System.out.println("Frete atualizado com Sucesso.");
						/*try {
							fachada.atualizarServicoDeEntrega(idFrete, freteNovo);
							System.out.println("Frete atualizado com Sucesso.");
						} catch (FreteInexistenteException FIE) {
							System.out.println(FIE.getMessage());
						}*/
					} else if (codigoOperacao == 3) {
						System.out.println(" PROCURAR FRETE: ");
						System.out.println("ID do frete a procurar: ");
						int id = in.nextInt();
						ServicoDeEntrega freteProcurado = fachada.procurarServicoDeEntrega(id);
						System.out.println("Informacoes da Venda:");
						System.out.println("-" + freteProcurado.getDistancia());
						System.out.println("-" + freteProcurado.getTipoDeEntrega());
						System.out.println("-" + freteProcurado.getIdentificador());
					/*	try {
							ServicoDeEntrega freteProcurado = fachada.procurarServicoDeEntrega(id);
							System.out.println("Informacoes da Venda:");
							System.out.println("-" + freteProcurado.getDistancia());
							System.out.println("-" + freteProcurado.getTipoDeEntrega());
							System.out.println("-" + freteProcurado.getIdentificador());
						} catch (FreteInexistenteException FIE) {
							System.out.println(FIE.getMessage());
						}*/
					}
					idFrete++;
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
