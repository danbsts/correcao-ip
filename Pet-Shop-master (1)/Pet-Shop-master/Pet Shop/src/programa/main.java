package programa;
import java.util.Scanner;
import fachada.*;
import clientes.*;
import funcionarios.*;
import produtos.*;
import servicos.*;
import venda.*;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		//RepositorioClientes repoClientes = new RepositorioClientesLista();
		RepositorioClientes repoClientes = new RepositorioClientesArray();
		//RepositorioFuncionarios repoFuncionarios = new RepositorioFuncionariosLista();
		RepositorioFuncionarios repoFuncionarios = new RepositorioFuncionariosArray();
		//RepositorioProduto repoProdutos = new RepositorioProdutosLista();
		RepositorioProduto repoProdutos = new RepositorioProdutosArray();
		//RepositorioServicos repoServicos = new RepositorioServicoLista();
		RepositorioServicos repoServicos = new RepositorioServicoArray();
		//RepositorioVendas repoVendas = new RepositorioVendasLista();
		RepositorioVendas repoVendas = new RepositorioVendasArray();

		PetShop petshop = new PetShop (repoClientes, repoFuncionarios, 
				repoProdutos, repoServicos, repoVendas);
		//PetShop petshop = new PetShop(repoClientes, repoFuncionarios, repoProdutos,
		//repoServicos, repoVendas);

		int x = 0;
		int p = 0;
		while (p!=6) {
			System.out.println("Digite um numero correspondente a funcao que deseja alterar:\n "
					+ "(1) - FUNCIONARIOS\n"
					+ " (2) - CLIENTES\n"
					+ " (3) - PRODUTOS\n"
					+ " (4) - SERVICOS\n"
					+ " (5) - VENDAS\n"
					+ " (6) - SAIR");
			p = in.nextInt();

			x = 0;

			//FUNCIONARIOS
			if ( p == 1) {
				while (x!=5) {
					System.out.println("Selecione como deseja alterar FUNCIONARIOS:\n"
							+ " (1) - Cadastrar\n"
							+ " (2) - Procurar\n"
							+ " (3) - Remover\n"
							+ " (4) - Atualizar\n"
							+ " (5) - Voltar");

					x = in.nextInt();
					//CADASTRAR FUNCIONARIO
					if (x == 1) {
						System.out.println("Para cadastrar um FUNCIONARIO insira:");
						System.out.println("-Nome do Funcionario:"); 
						String nomeFunc=in.next();
						System.out.println("-CPF do Funcionario:"); 
						String cpfFunc=in.next();
						System.out.println("-Telefone do Funcionario:"); 
						String telFunc=in.next();
						System.out.println("-Codigo do Funcionario:"); 
						String codeFunc=in.next();
						System.out.println("-Salario do Funcionario");
						double salarioFunc=in.nextDouble();
						Funcionarios funcionario = new Funcionarios(nomeFunc, cpfFunc, telFunc, codeFunc, salarioFunc);
						try {
							petshop.cadastrarFuncionario(funcionario);
							System.out.println("\n\n------ Funcionario Cadastrado com Sucesso ------\n\n");
						} catch (LimiteFuncionariosAtingidoException | FuncionarioJaCadastradoException e) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(e.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//PROCURAR FUNCIONARIO 
					if (x == 2) {
						System.out.println("Digite o codigo do FUNCIONARIO que deseja procurar");
						String codeFunc = in.next();
						try {
							Funcionarios funcionario = petshop.procurarFuncionario(codeFunc);
							System.out.println("Produto de codigo:" + codeFunc + "\n-Nome do Funcionario:"
									+ funcionario.getNome() + "\n-CPF do Funcionario:"
									+ funcionario.getCpf() + "\n-Telefone do Funcionario:"
									+ funcionario.getTelefone() + "\n-Salario do Funcionario:"
									+ funcionario.getSalario() + "\n");
						} catch (FuncionarioNaoEncontradoException e) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(e.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//REMOVER FUNCIONARIO
					if (x == 3) {
						System.out.println("Digite o codigo do FUNCIONARIO que deseja remover");
						String codeFunc = in.next();
						try {
							petshop.removerFuncionario(codeFunc);
							System.out.println("\n\n------ Funcionario Removido com Sucesso ------\n\n");
						} catch (FuncionarioNaoEncontradoException e) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(e.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//ATUALIZAR
					if (x == 4) {
						System.out.println("Primeiro, insira o codigo do FUNCIONARIO que deseja atualizar:");
						String codeFunc=in.next();
						System.out.println("-Nome do Funcionario:"); 
						String nomeFunc=in.next();
						System.out.println("-CPF do Funcionario:"); 
						String cpfFunc=in.next();
						System.out.println("-Telefone do Funcionario:"); 
						String telFunc=in.next();
						System.out.println("-Salario do Funcionario");
						double salarioFunc=in.nextDouble();
						Funcionarios funcionario = new Funcionarios(nomeFunc, cpfFunc, telFunc, codeFunc, salarioFunc);
						try {
							petshop.atualizarFuncionario(funcionario);
							System.out.println("\n\n------ Funcionario Atualizado com Sucesso ------\n\n");
						} catch (FuncionarioNaoEncontradoException e) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(e.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}
				} 
			}
			//CLIENTES
			if (p == 2) {
				while(x!=5) {
					System.out.println("Selecione como deseja alterar CLIENTES:\n"
							+ " (1) - Cadastrar\n"
							+ " (2) - Procurar\n"
							+ " (3) - Remover\n"
							+ " (4) - Atualizar\n"
							+ " (5) - Voltar");

					x = in.nextInt();
					//CADASTRAR CLIENTES
					if (x == 1) {
						System.out.println("Para cadastrar o CLIENTE insira:");
						System.out.println("-Nome do Cliente:"); 
						String nomeCliente = in.next();
						System.out.println("-Cpf do Cliente:"); 
						String cpfCliente = in.next();
						System.out.println("-Telefone do Cliente:"); 
						String telefoneCliente = in.next();
						try {
							Clientes objetoCliente = new Clientes (nomeCliente, cpfCliente, telefoneCliente);
							petshop.cadastrarCliente(objetoCliente);
							System.out.println("\n\nCLIENTE cadastrado com sucesso!\n\n");
						}
						catch (ClienteJaCadastradoException e){
							System.out.println("\n\n*******ERRO*******");
							System.out.println(e.getMessage() + "\n\n");
						}
						catch (LimiteClientesAtingidoException e) {
							System.out.println("\n\n*******ERRO*******");
							System.out.println(e.getMessage() + "\n\n");
						}
					}

					//PROCURAR CLIENTES 
					if (x == 2) {
						System.out.println("Para procurar o CLIENTE insira:");
						System.out.println("-CPF do Cliente:");
						String cpfCliente = in.next();
						try {
							Clientes clienteProcurado = petshop.procurarCliente(cpfCliente);
							System.out.println("-Nome do CLIENTE: " + clienteProcurado.getNome());
							System.out.println("-CPF do CLIENTE: " + clienteProcurado.getCpf());
							System.out.println("-Telefone do CLIENTE: " + clienteProcurado.getTelefone() );
						}
						catch (ClienteNaoEncontradoException e) {
							System.out.println("\n\n*******ERRO*******");
							System.out.println(e.getMessage() + "\n\n");
						}
					}

					//REMOVER CLIENTES
					if (x == 3) {
						System.out.println("Para remover o CLIENTE insira:");
						System.out.println("-Cpf do Cliente:"); 
						String cpfCliente = in.next();
						try {
							petshop.removerCliente(cpfCliente);
							System.out.println("\n\nCLIENTE removido com sucesso!\n\n");
						}
						catch(ClienteNaoEncontradoException e) {
							System.out.println("\n\n*******ERRO*******");
							System.out.println(e.getMessage() + "\n\n");
						}
					}

					//ATUALIZAR CLIENTES
					if (x == 4) {
						System.out.println("Para atualizar as informacoes do CLIENTE insira:");
						System.out.println("-Cpf do Cliente:"); 
						String cpfCliente = in.next();
						try {
							petshop.existeCliente(cpfCliente);
							System.out.println("-NOVO nome do Cliente:"); 
							String novoNomeCliente = in.next();
							System.out.println("-NOVO telefone do Cliente:"); 
							String novoTelefoneCliente = in.next();
							Clientes objetoCliente = new Clientes (novoNomeCliente, cpfCliente, novoTelefoneCliente);
							petshop.atualizarCliente(objetoCliente);
						}
						catch (ClienteNaoEncontradoException e) {
							System.out.println("\n\n*******ERRO*******");
							System.out.println(e.getMessage() + "\n\n");
						}
					}
				}
			}

			//PRODUTOS
			if (p == 3) {
				while(x!=5) {
					System.out.println("Selecione como deseja alterar PRODUTOS:\n"
							+ " (1) - Cadastrar\n"
							+ " (2) - Procurar\n"
							+ " (3) - Remover\n"
							+ " (4) - Atualizar\n"
							+ " (5) - Voltar");

					x = Integer.parseInt(in.next());
					//CADASTRAR PRODUTOS
					if (x == 1) {
						System.out.println("Para cadastrar o PRODUTOS insira:");
						System.out.println("-Nome do Produto:"); String nomeProduto = in.next();
						System.out.println("-Codigo do Produto:"); String codeProduto = in.next();
						System.out.println("-Preco do Produto:"); double priceProduto = in.nextDouble();
						System.out.println("-Quantidade:"); int quantidadeProduto = in.nextInt();
						System.out.println("-Fornecedor:"); String fornecedorProduto = in.next();
						Produtos produto = new Produtos(nomeProduto, codeProduto, priceProduto, quantidadeProduto, fornecedorProduto);
						try {
							petshop.cadastrarProdutos(produto);

							System.out.println("\n\n------ Produto Cadastrado com Sucesso ------\n\n");
						} catch (LimiteProdutosAtingidoException | ProdutoJaCadastradoException | ProdutoNaoEncontradoException e) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(e.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//PROCURAR PRODUTOS 
					if (x == 2) {
						System.out.println("Digite o codigo do PRODUTO que deseja procurar");
						String codeProduto = in.next();
						try {
							Produtos produtop = petshop.procurarProduto(codeProduto);
							System.out.println("Produto de codigo:" + codeProduto + "\n-Nome do Produto:"
									+ produtop.getNome() + "\n-Preco do Produto:"
									+ produtop.getPrice() + "\n-Quantidade:"
									+ produtop.getQuantidade() + "\n-Fornecedor:"
									+ produtop.getFornecedor() + "\n");
						} catch ( ProdutoNaoEncontradoException e) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(e.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//REMOVER PRODUTOS
					if (x == 3) {
						System.out.println("Digite o codigo do PRODUTO que deseja remover");
						String codeProduto = in.next();
						try {
							petshop.removerProduto(codeProduto);
							System.out.println("\n\n------ Produto Removido com Sucesso ------\n\n");
						} catch (ProdutoNaoEncontradoException e){
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(e.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}

					}

					//ATUALIZAR PRODUTOS
					if (x == 4) {
						System.out.println("Insira o Codigo do PRODUTO que deseja alterar:");
						String codeProduto = in.next();
						System.out.println("-Novo nome:"); String nomeProduto = in.next();
						System.out.println("-Novo Preco:"); double priceProduto = in.nextDouble();
						System.out.println("-Nova Quantidade:"); int quantidadeProduto = in.nextInt();
						System.out.println("-Novo Fornecedor:"); String fornecedorProduto = in.next();
						Produtos produto = new Produtos(nomeProduto, codeProduto, priceProduto, quantidadeProduto, fornecedorProduto);
						try {
							petshop.atualizarProduto(produto);

							System.out.println("\n\n------ Produto Atualizado com Sucesso ------\n\n");
						} catch (ProdutoNaoEncontradoException e) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(e.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}
				}
			}

			//SERVICOS
			if (p == 4) {
				while (x!=5) {
					System.out.println("Selecione como deseja alterar SERVICOS:\n"
							+ " (1) - Cadastrar\n"
							+ " (2) - Procurar\n"
							+ " (3) - Remover\n"
							+ " (4) - Atualizar\n"
							+ " (5) - Voltar");
					x = in.nextInt();
					//CADASTRAR SERVICO
					if (x == 1) {
						System.out.println("Para cadastrar o SERVICO insira:");
						System.out.println("-Nome do SERVICO:"); 
						String nomeServico = in.next();
						System.out.println("-Codigo do SERVICO:"); 
						String codeServico= in.next();
						System.out.println("-Preco do SERVICO:"); 
						double priceServico = in.nextDouble();
						System.out.println("-");
						try {
							Servicos objetoServico = new Servicos (nomeServico, codeServico, priceServico);
							petshop.cadastrarServico(objetoServico);
							System.out.println("\n\nSERVICO cadastrado com sucesso!\n\n");
						}
						catch (ServicoJaCadastradoException e){
							System.out.println("\n\n********************ERRO********************");
							System.out.println(e.getMessage());
							System.out.println("********************ERRO********************\n\n");
						}
						catch (LimiteServicoAtingidoException e) {
							System.out.println("\n\n********************ERRO********************");
							System.out.println(e.getMessage());
							System.out.println("********************ERRO********************\n\n");

						}
					}

					//PROCURAR SERVICO 
					if (x == 2) {
						System.out.println("Para procurar o SERVICO insira:");
						System.out.println("-Codigo do SERVICO:"); 
						String codeServico= in.next();
						try {
							Servicos servicoProcurado = petshop.procurarServico(codeServico);
							System.out.println("-Nome do SERVICO: " + servicoProcurado.getNome());
							System.out.println("-Codigo do SERVICO: " + servicoProcurado.getCodigo());
							System.out.println("-Valos do SERVICO: R$" + servicoProcurado.getPreco() );
							System.out.println("-\n\n");
						}
						catch (ServicoNaoEncontradoException e) {
							System.out.println("\n\n********************ERRO********************");
							System.out.println(e.getMessage());
							System.out.println("********************ERRO********************\n\n");

						}
					}

					//REMOVER SERVICO
					if (x == 3) {
						System.out.println("Para remover o SERVICO insira:");
						System.out.println("-Codigo do SERVICO:");
						String codeServico = in.next();
						try {
							petshop.removerServico(codeServico);
							System.out.println("\n\nSERVICO removido com sucesso!\n\n");
						}
						catch(ServicoNaoEncontradoException e) {
							System.out.println("\n\n********************ERRO********************");
							System.out.println(e.getMessage());
							System.out.println("********************ERRO********************\n\n");
						}
					}

					//ATUALIZAR SERVICO
					if (x == 4) {
						System.out.println("Para atualizar o SERVICO insira:");
						System.out.println("-Codigo do SERVICO a ser atualizado:");
						String codeServico = in.next();
						try {
							petshop.existeServico(codeServico);
							System.out.println("Insira o novo nome do SERVICO:");
							String newName = in.next();
							System.out.println("Insira o novo preco do SERVICO:");
							double newPrice = in.nextDouble();
							Servicos objetoServico = new Servicos(newName, codeServico, newPrice);
							petshop.atualizarServico(objetoServico);
							System.out.println("\n\nSERVICO atualizado com sucesso\n\n");
						}
						catch (ServicoNaoEncontradoException e) {
							System.out.println("\n\n********************ERRO********************");
							System.out.println(e.getMessage());
							System.out.println("********************ERRO********************\n\n");
						}
					}
				}
			}

			//VENDAS
			if (p == 5) {
				while (x!=5) {
					System.out.println("Selecione como deseja alterar VENDAS:\n"
							+ " (1) - Cadastrar\n"
							+ " (2) - Procurar\n"
							+ " (3) - Remover\n"
							+ " (4) - Atualizar\n"
							+ " (5) - Voltar");

					x = in.nextInt();
					String codeF = null; String cpf = null; String codeP = null; String codeS = null; double valor = 0;

					//procurando as classes pertencentes a venda
					if (x == 1) {

						System.out.println("Digite o CPF do cliente:"); cpf = in.next();
						System.out.println("Digite o codigo do funcionario que efetuou a venda:"); codeF = in.next();
						System.out.println("Digite o codigo do produto vendido:"); codeP = in.next();
						System.out.println("Digite o codigo do servico prestado:"); codeS = in.next();
						System.out.println("Digite o valor total da venda:"); valor = in.nextDouble();
						System.out.println("Digite o ID da venda:"); String id = in.next();
						System.out.println("Abater credito do cliente no valor total da venda?" + "\n" +
								"(1) SIM" + "\n" +
								"(2) NAO"); int comandoCred = in.nextInt();
								if (comandoCred == 1) {
									try {
										double valorCred = petshop.procurarCliente(cpf).getCredito();
										valor -= valorCred;
										petshop.procurarCliente(cpf).setCredito(0);
									} catch (ClienteNaoEncontradoException c) {
										System.out.println("\n\n----------------- ERRO -----------------\n\n");
										System.out.println(c.getMessage());
										System.out.println("\n\n----------------- ERRO -----------------\n\n");
									}
								} 
								else if (comandoCred == 2) {
									try {
										petshop.procurarCliente(cpf).setCredito(petshop.procurarCliente(cpf).gerarbonus(valor)+petshop.procurarCliente(cpf).getCredito());
									} catch (ClienteNaoEncontradoException c) {
										System.out.println("\n\n----------------- ERRO -----------------\n\n");
										System.out.println(c.getMessage());
										System.out.println("\n\n----------------- ERRO -----------------\n\n");
									}
								}

								try {

									Clientes cliente = petshop.procurarCliente(cpf);
									Funcionarios funcionario = petshop.procurarFuncionario(codeF);
									Produtos produto = petshop.procurarProduto(codeP);
									Servicos servico = petshop.procurarServico(codeS);
									Vendas venda = new Vendas (funcionario,
											cliente,
											produto,
											servico,
											valor, id);

									//CADASTRANDO
									funcionario.setSalario(funcionario.getSalario()+petshop.procurarFuncionario(codeF).gerarbonus(valor));
									petshop.cadastrarVenda(venda);
									System.out.println("\n\n------ Venda Cadastrada com Sucesso ------\n\n");

								} catch (ClienteNaoEncontradoException | 
										FuncionarioNaoEncontradoException |
										ProdutoNaoEncontradoException |
										ServicoNaoEncontradoException |  
										VendaJaCadastradaException |
										LimiteAtingidoException | 
										AlgoNaoFoiEncontradoException c) {
									System.out.println("\n\n----------------- ERRO -----------------\n\n");
									System.out.println(c.getMessage());
									System.out.println("\n\n----------------- ERRO -----------------\n\n");	   
								}
					}

					//PROCURAR VENDA
					if (x == 2) {
						System.out.println("Digite o id da venda que voce quer procurar:");
						String idP = in.next();
						try {
							Vendas procura = petshop.procurarVenda(idP);
							System.out.println("Nome do CLIENTE: " + procura.getCliente().getNome() + "\n" + "CPF do CLIENTE: " + procura.getCliente().getCpf() 
									+ "\n" + "Telefone do CLIENTE: " + procura.getCliente().getTelefone() + "\n" + "Desconto que o CLIENTE possui: " 
									+ procura.getCliente().getCredito() + "\n");
							System.out.println("Nome do FUNCIONARIOS: " + procura.getFuncionario().getNome() + "\n" + "CPF do FUNCIONARIO: " + procura.getFuncionario().getCpf() 
									+ "\n" + "Codigo do FUNCIONARIO: " + procura.getFuncionario().getCodigo() + "\n" + "Telefone do FUNCIONARIO: " 
									+ procura.getFuncionario().getTelefone() + "\n" + "Salario do FUNCIONARIO: " + procura.getFuncionario().getSalario() + "\n");
							System.out.println("Nome do PRODUTO: " + procura.getProduto().getNome() + "\n" + "Codigo do PRODUTO: " + procura.getProduto().getCode() + "\n" 
									+ "Nome do fornecedor do PRODUTO: " + procura.getProduto().getFornecedor() + "\n" + "Preco do PRODUTO: " + procura.getProduto().getPrice() 
									+ "\n" + "Quantidade do PRODUTO em estoque: " + procura.getProduto().getQuantidade() + "\n");
							System.out.println("Nome do SERVICO prestado: " + procura.getServico().getNome() + "\n" + "Codigo do SERVICO prestado: " 
									+ procura.getServico().getCodigo() + "\n" + "Preco do SERVICO prestado: " +  procura.getServico().getPreco() + "\n");
							System.out.println("Valor total da VENDA: " + procura.getValor() + "\n" + "ID da VENDA: " + procura.getId() + "\n");
						} catch (VendaNaoEncontradaException v) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(v.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//REMOVER VENDA
					if (x == 3) {
						System.out.println("Digite o id da venda que voce quer remover:");
						String idR = in.next();
						try {
							petshop.removerVenda(idR);
							System.out.println("\n\n------ Venda Removida com Sucesso ------\n\n");
						} catch (VendaNaoEncontradaException v) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(v.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
						}
					}

					//ATUALIZAR VENDA
					if (x == 4) {
						Funcionarios funcionario = null; Clientes cliente = null; Produtos produto = null; Servicos servico = null;

						System.out.println("Digite o id da venda que voce deseja atualizar");
						try {
						String idA = in.next();

						System.out.println("Digite o codigo do Novo FUNCIONARIO responsavel pela venda:");
						
							funcionario = petshop.procurarFuncionario(in.next());
						
						System.out.println("Digite o CPF Novo CLIENTE que comprou:");
						
							cliente = petshop.procurarCliente(in.next());
						

						System.out.println("Digite o Codigo do novo PRODUTO que foi vendido:");
						
							produto = petshop.procurarProduto(in.next());
						

						System.out.println("Digite o codigo do SERVICO incluido na venda:");
						
							servico = petshop.procurarServico(in.next());
						

						System.out.println("Digite o novo VALOR TOTAL da venda:");
						double valorNovaVenda = in.nextDouble();
						Vendas vendaNova = new Vendas(funcionario, cliente, produto, servico, valorNovaVenda, idA);
					
							petshop.atualizarVenda(vendaNova);
							System.out.println("\n\n------ Venda Atualizada com Sucesso ------\n\n");
						}  catch (ClienteNaoEncontradoException | 
								FuncionarioNaoEncontradoException |
								ProdutoNaoEncontradoException |
								ServicoNaoEncontradoException |  
								VendaNaoEncontradaException c) {
							System.out.println("\n\n----------------- ERRO -----------------\n\n");
							System.out.println(c.getMessage());
							System.out.println("\n\n----------------- ERRO -----------------\n\n");	   
						}
					}
				}
			}
		}
		in.close();
	}
}
