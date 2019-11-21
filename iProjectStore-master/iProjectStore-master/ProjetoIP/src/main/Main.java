package main;

import fachada.LojaMagica;
import mercadoria.*;
import Cliente.*;
import funcionario.*;
import entregador.*;
import Pessoa.*;
import vendas.*;

import java.util.*;

//main interativo, interface no console

public class Main {

	public static void main(String[] args) throws MercadoriaJaCadastradaException, MercadoriaNaoEncontradaException,
			ClienteJaCadastradoException, ClienteNaoEncontradoException, EntregadorJaCadastroException,
			EntregadorNaoEncontradoException, FuncionarioInexistenteException, FuncionarioJaCadastradoException,
			ExisteVendaException, NaoExisteException {
		Scanner in = new Scanner(System.in);
		boolean MercadoriaExiste = false;
		boolean EntregadorExiste = false;
		int entrada = 0;

		Mercadoria objetoMercadoria;
		Cliente objetoCliente;
		Funcionarios objetoFuncionario;
		Entregador objetoEntregador;
		Vendas objetoVendas;

		// lista
		 RepositorioMercadoria repoMercadoria = new RepositorioMercadoriaLista();
		 RepositorioCliente repoCliente = new RepositorioListaCliente();
		 RepositorioEntregadores repoEntregador = new RepositorioEntregadoresLista();
		 RepositorioFuncionarios repoFuncionarios = new
		 RepositorioFuncionariosLista();
		 VendasInterface repoVendas = new RepositorioListaVendas();
		 LojaMagica lojaMagica = new LojaMagica(repoMercadoria, repoVendas,
		 repoEntregador, repoCliente,
		 repoFuncionarios);

		// array
		 //RepositorioMercadoria repoMercadoria = new RepositorioMercadoriaArray();
		 //RepositorioCliente repoCliente = new RepositorioArrayCliente();
		 //RepositorioEntregadores repoEntregador = new RepositorioEntregadoresArray();
		 //RepositorioFuncionarios repoFuncionarios = new RepositorioFuncionariosArray();
		//VendasInterface repoVendas = new RepositorioArrayVendas();
		 //LojaMagica lojaMagica = new LojaMagica(repoMercadoria, repoVendas, repoEntregador, repoCliente,
		 //		repoFuncionarios);

		System.out.println("Ola! Bem vindo a nossa Loja Magica! \n");

		while (entrada != 6) {
			int opcao = 0;
			System.out.println("O que deseja fazer?");
			System.out.println("1 - Gerenciar mercadoria");
			System.out.println("2 - Gerenciar vendas");
			System.out.println("3 - Gerenciar entregadores");
			System.out.println("4 - Gerenciar funcionarios");
			System.out.println("5 - Gerenciar clientes");
			System.out.println("6 - Sair \n");

			entrada = in.nextInt();

			// mercadoria
			if (entrada == 1) {
				while (opcao != 5) {
					System.out.println("Voce esta no gerenciamento de mercadorias. Selecione o que deseja fazer.");
					System.out.println("1 - Cadastrar mercadoria");
					System.out.println("2 - Remover mercadoria");
					System.out.println("3 - Atualizar mercadoria");
					System.out.println("4 - Procurar mercadoria");
					System.out.println("5 - Sair \n");

					opcao = in.nextInt();

					// cadastrar mercadoria
					if (opcao == 1) {
						in.nextLine();
						MercadoriaExiste = true;
						System.out.println("Para cadastrar uma mercadoria, digite o que se pede:");
						System.out.println("Nome da mercadoria: ");
						String nomeM = in.nextLine();
						System.out.println("Descricao da mercadoria: ");
						String descricaoM = in.nextLine();
						System.out.println("Preco da mercadoria: ");
						double precoM = in.nextDouble();
						System.out.println("Identificador da mercadoria: ");
						int idM = in.nextInt();

						try {

							Mercadoria objMercadoria = new Mercadoria(nomeM, descricaoM, precoM, idM);
							lojaMagica.cadastrarMercadoria(objMercadoria);
							System.out.println("\n\nMercadoria cadastrada com sucesso!\n\n");

						} catch (MercadoriaJaCadastradaException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

					// remover mercadoria
					if (opcao == 2) {

						System.out.println("Para remover uma mercadoria, digite o que se pede:");
						System.out.println("Identificador da mercadoria");
						int idM = in.nextInt();

						try {

							lojaMagica.removerMercadoria(idM);
							System.out.println("\n\nMercadoria removida com sucesso!\n\n");

						} catch (MercadoriaNaoEncontradaException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}
					}

					// atualizar mercadoria	
					if (opcao == 3) {
						System.out.println("Para atualizar uma mercadoria, digite o que se pede: ");
						System.out.println("Identificador da mercadoria");
						int idM = in.nextInt();
						in.nextLine();

						try {
							boolean x =lojaMagica.verificarMercadoria(idM);
							if(x) {
								System.out.println("Insira o novo nome da mercadoria");
								String nomeM = in.nextLine();
								System.out.println("Insira a nova descricao da mercadoria");
								String descM = in.nextLine();
								System.out.println("Insira o novo preco da mercadoria");
								double precoM = in.nextDouble();
								Mercadoria objMercadoria = new Mercadoria(nomeM, descM, precoM, idM);
								lojaMagica.atualizarMercadoria(objMercadoria);
								System.out.println("\n\nMercadoria atualizada com sucesso!\n\n");
							}
							else {
								System.out.println("\n\n******ERRO******\n\n");
								System.out.println("Mercadoria nao encontrada.\n");
								System.out.println("\n\n******ERRO******\n\n");
							}
						} catch (MercadoriaNaoEncontradaException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

					// procurar mercadoria
					if (opcao == 4) {

						System.out.println("Para procurar uma mercadoria, digite o que se pede: ");
						System.out.println("Identificador da mercadoria");
						int idM = in.nextInt();

						try {

							Mercadoria mercadoriaProcurada = lojaMagica.procurarMercadoria(idM);
							System.out.println("\n\nNome da mercadoria: " + mercadoriaProcurada.getNome());
							System.out.println("Descricao da mercadoria: " + mercadoriaProcurada.getDescricao());
							System.out.println("Preco da mercadoria: " + mercadoriaProcurada.getPreco());
							System.out.println("\n\n");

						} catch (MercadoriaNaoEncontradaException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

				}
			}

			// vendas
			if (entrada == 2) {
				while (opcao != 5) {
					System.out.println("Voce esta no gerenciamento de vendas. Selecione o que deseja fazer.");
					System.out.println("1 - Cadastrar vendas");
					System.out.println("2 - Remover vendas");
					System.out.println("3 - Atualizar vendas");
					System.out.println("4 - Procurar vendas");
					System.out.println("5 - Sair \n");

					opcao = in.nextInt();
					in.nextLine();

					// cadastro venda
					if (opcao == 1) {
						if (EntregadorExiste) {
							if (MercadoriaExiste) {
								System.out.println("Para comprar um produto, digite o que se pede:");
								System.out.println("digite o cpf do entregador");
								String cpf = in.nextLine();
								in.nextLine();
								System.out.println("digite o id da mercadoria");
								int id = Integer.parseInt(in.nextLine());
								System.out.println("Digite o Id da venda: ");
								String idvenda = in.nextLine();
								System.out.println("Digite o local de entrega: ");
								String localdeEntrega = in.nextLine();
								if (localdeEntrega.length() > 10) {
									localdeEntrega = localdeEntrega.substring(0, 10);
									System.out
											.println("voce morava longe demais, agora voce mora em " + localdeEntrega);

								}
								try {
									Entregador objentregador = lojaMagica.procurarEntregador(cpf);
									cpf = objentregador.getCpf();
									try {
										Mercadoria objmercadoria = lojaMagica.procurarMercadoria(id);
										int MercadoriaId = lojaMagica.procurarMercadoria(id).getId();
										try {
											Vendas objVenda = new Vendas(idvenda, localdeEntrega);
											objVenda.setCost(objVenda.getDistance(), 0.0,
													lojaMagica.procurarEntregador(cpf).getPrecoPorDistancia());
											lojaMagica.inserirVenda(objVenda);
											System.out.println("\n\nVenda concluida com sucesso!\n\n");
										} catch (ExisteVendaException e) {
											System.out.println("\n\n******ERRO******\n\n");
											System.out.println(e.getMessage() + "\n");
											System.out.println("\n\n******ERRO******\n\n");
										}
									} catch (MercadoriaNaoEncontradaException e) {
										System.out.println("\n\n******ERRO******\n\n");
										System.out.println(e.getMessage() + "\n");
										System.out.println("\n\n******ERRO******\n\n");
									}
								} catch (EntregadorNaoEncontradoException e) {
									System.out.println("\n\n******ERRO******\n\n");
									System.out.println(e.getMessage() + "\n");
									System.out.println("\n\n******ERRO******\n\n");
								}
							} else {
								System.out.println("\n\n*****ERRO*****\n\n");
								System.out.println("Nao existe nenhuma mercadoria\n");
								System.out.println("\n\n*****ERRO*****\n\n");
							}
						} else {
							System.out.println("\n\n*****ERRO*****\n\n");
							System.out.println("Nao existe nenhum entregador\n");
							System.out.println("\n\n*****ERRO*****\n\n");
						}
					}

					// remover venda
					if (opcao == 2) {
						System.out.println("Para descomprar uma venda, digite o que se pede:");
						System.out.println("Identificador da venda");
						String idV = in.nextLine();

						try {

							lojaMagica.removerVenda(idV);
							System.out.println("\n\nMercadoria removida com sucesso!\n\n");

						} catch (NaoExisteException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}
					}

					// atualizar venda
					if (opcao == 3) {
						if (EntregadorExiste) {
							if (MercadoriaExiste) {
								System.out.println("Para comprar um novo produto, digite o que se pede:");
								System.out.println("digite o novo cpf do entregador");
								String cpf = in.nextLine();
								in.nextLine();
								System.out.println("digite o novo id da mercadoria");
								int id = Integer.parseInt(in.nextLine());
								System.out.println("Digite o novo Id da venda: ");
								String idvenda = in.nextLine();
								System.out.println("Digite o novo local de entrega: ");
								String localdeEntrega = in.nextLine();
								if (localdeEntrega.length() > 10) {
									localdeEntrega = localdeEntrega.substring(0, 10);
									System.out
											.println("voce morava longe demais, agora voce mora em " + localdeEntrega);

								}
								try {
									Entregador objentregador = lojaMagica.procurarEntregador(cpf);
									cpf = objentregador.getCpf();
									try {
										Mercadoria objmercadoria = lojaMagica.procurarMercadoria(id);
										int MercadoriaId = lojaMagica.procurarMercadoria(id).getId();
										try {
											Vendas objVenda = new Vendas(idvenda, localdeEntrega);
											objVenda.setCost(objVenda.getDistance(), 0.0,
													lojaMagica.procurarEntregador(cpf).getPrecoPorDistancia());
											lojaMagica.atualizarVenda(objVenda);
											System.out.println("\n\nVenda atualizada com sucesso!\n\n");
										} catch (NaoExisteException e) {
											System.out.println("\n\n******ERRO******\n\n");
											System.out.println(e.getMessage() + "\n");
											System.out.println("\n\n******ERRO******\n\n");
										}
									} catch (MercadoriaNaoEncontradaException e) {
										System.out.println("\n\n******ERRO******\n\n");
										System.out.println(e.getMessage() + "\n");
										System.out.println("\n\n******ERRO******\n\n");
									}
								} catch (EntregadorNaoEncontradoException e) {
									System.out.println("\n\n******ERRO******\n\n");
									System.out.println(e.getMessage() + "\n");
									System.out.println("\n\n******ERRO******\n\n");
								}
							} else {
								System.out.println("\n\n*****ERRO*****\n\n");
								System.out.println("Nao existe nenhuma mercadoria\n");
								System.out.println("\n\n*****ERRO*****\n\n");
							}
						} else {
							System.out.println("\n\n*****ERRO*****\n\n");
							System.out.println("Nao existe nenhum entregador\n");
							System.out.println("\n\n*****ERRO*****\n\n");
						}
					}
					// procurar venda
					if (opcao == 4) {
						System.out.println("Para procurar uma venda, digite o que se pede: ");
						System.out.println("Identificador da venda");
						String idV = in.nextLine();

						try {

							Vendas vendaquetuque = lojaMagica.procurarVenda(idV);
							System.out.println("\n\nId da venda: " + vendaquetuque.getSaleid());
							System.out.println("Custo total: " + vendaquetuque.getCost());
							System.out.println("Distancia da entrega do produto: " + vendaquetuque.getDistance());
							System.out.println("Sua Casa: " + vendaquetuque.getDeliver());
							System.out.println("\n\n");

						} catch (NaoExisteException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}
				}
			}
			// entregadores
			if (entrada == 3) {
				while (opcao != 5) {
					System.out.println("Voce esta no gerenciamento de entregadores. Selecione o que deseja fazer.");
					System.out.println("1 - Cadastrar entregador");
					System.out.println("2 - Remover entregador");
					System.out.println("3 - Atualizar entregador");
					System.out.println("4 - Procurar entregador");
					System.out.println("5 - Sair \n");

					opcao = in.nextInt();

					// cadastrar entregador
					if (opcao == 1) {
						in.nextLine();
						EntregadorExiste = true;
						System.out.println("Para cadastrar um entregador, digite o que se pede:");
						System.out.println("Nome do entregador: ");
						String nomeE = in.nextLine();
						System.out.println("CPF do entregador: ");
						String cpfE = in.nextLine();
						System.out.println("Contato do entregador: ");
						String contatoE = in.nextLine();
						System.out.println("Transporte do entregador: ");
						String transporteE = in.nextLine();
						System.out.println("Preco por distancia do entregador");
						double precodistE = in.nextDouble();

						try {

							Entregador objEntregador = new Entregador(nomeE, cpfE, contatoE, transporteE, precodistE);
							lojaMagica.cadastrarEntregador(objEntregador);
							System.out.println("\n\nEntregador cadastrado com sucesso!\n\n");

						} catch (EntregadorJaCadastroException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

					// remover entregador
					if (opcao == 2) {
						in.nextLine();
						System.out.println("Para remover um entregador, digite o que se pede:");
						System.out.println("CPF do entregador");
						String cpfE = in.nextLine();

						try {

							lojaMagica.removerEntregador(cpfE);
							System.out.println("\n\nEntregador removido com sucesso!\n\n");

						} catch (EntregadorNaoEncontradoException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

					// atualizar entregador
					if (opcao == 3) {
						in.nextLine();
						System.out.println("Para atualizar um entregador, digite o que se pede: ");
						System.out.println("CPF do entregador");
						String cpfE = in.nextLine();

						try {
							boolean x = lojaMagica.verificarEntregador(cpfE) ;
									if(x) {
								System.out.println("Insira o novo nome do Entregador");
								String nomeE = in.nextLine();
								System.out.println("Insira o novo contato do Entregador");
								String contatoE = in.nextLine();
								System.out.println("Insira o novo transporte do Entregador");
								String transporteE = in.nextLine();
								System.out.println("Insira o novo preco por distancia do Entregador");
								double precodistE = in.nextDouble();
								Entregador objEntregador = new Entregador(nomeE, cpfE, contatoE, transporteE,
										precodistE);
								lojaMagica.atualizarEntregador(objEntregador);
								System.out.println("\n\nEntregador atualizado com sucesso!\n\n");
							}
									else {
										System.out.println("\n\n******ERRO******\n\n");
										System.out.println("Entregador nao encontrado!\n");
										System.out.println("\n\n******ERRO******\n\n");
									}
						} catch (EntregadorNaoEncontradoException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

					// procurar entregador
					if (opcao == 4) {
						in.nextLine();
						System.out.println("Para procurar um Entregador, digite o que se pede: ");
						System.out.println("CPF do Entregador");
						String cpfE = in.nextLine();

						try {

							Entregador entregadorProcurado = lojaMagica.procurarEntregador(cpfE);
							System.out.println("\n\nNome do entregador: " + entregadorProcurado.getNome());
							System.out.println("Contato do entregador: " + entregadorProcurado.getContato());
							System.out.println("Transporte do entregador: " + entregadorProcurado.getTransporte());
							System.out.println(
									"Preco por distancia do entregador: " + entregadorProcurado.getPrecoPorDistancia());
							System.out.println("\n\n");

						} catch (EntregadorNaoEncontradoException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

				}

			}

			// funcionarios
			if (entrada == 4) {
				while (opcao != 5) {
					System.out.println("Voce esta no gerenciamento de funcionarios. Selecione o que deseja fazer.");
					System.out.println("1 - Cadastrar funcionario");
					System.out.println("2 - Remover funcionario");
					System.out.println("3 - Atualizar funcionario");
					System.out.println("4 - Procurar funcionario");
					System.out.println("5 - Sair \n");

					opcao = in.nextInt();

					// cadastrar funcionario
					if (opcao == 1) {
						in.nextLine();
						System.out.println("Para cadastrar um funcionario, digite o que se pede:");
						System.out.println("Nome do funcionario: ");
						String nomeF = in.nextLine();
						System.out.println("CPF do funcionario: ");
						String cpfF = in.nextLine();
						System.out.println("Contato do funcionario: ");
						String contatoF = in.nextLine();
						try {

							Funcionarios funcionario = new Funcionarios(nomeF, cpfF, contatoF);
							lojaMagica.cadastrarFuncionario(funcionario);
							System.out.println("\n\nFuncionario cadastrado com sucesso!\n\n");

						} catch (FuncionarioJaCadastradoException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

					// remover funcionario
					if (opcao == 2) {
						in.nextLine();
						System.out.println("Para remover um funcionario, digite o que se pede:");
						System.out.println("CPF do funcionario:");
						String cpfF = in.nextLine();
						try {
						Funcionarios funcionario = lojaMagica.procurarFuncionario(cpfF);

						try {

							lojaMagica.removerFuncionario(funcionario);
							System.out.println("\n\nFuncionario removido com sucesso!\n\n");

						} catch (FuncionarioInexistenteException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}
						}
						catch(FuncionarioInexistenteException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}
					}

					// atualizar funcionario
					if (opcao == 3) {
						System.out.println("Para atualizar um funcionario, digite o que se pede: ");
						System.out.println("CPF do funcionario:");
						in.nextLine();
						String cpfF = in.nextLine();
						try {
							System.out.println("Insira o novo nome do funcionario:");
							String nomeF = in.nextLine();
							System.out.println("Insira o novo contato do funcionario");
							String contatoF = in.nextLine();
							Funcionarios funcionario = new Funcionarios(nomeF, cpfF, contatoF);
							lojaMagica.atualizarFuncionario(funcionario);
							System.out.println("\n\nFuncionario atualizado com sucesso!\n\n");

						} catch (FuncionarioInexistenteException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

					// procurar funcionario
					if (opcao == 4) {
						in.nextLine();
						System.out.println("Para procurar um funcionario, digite o que se pede: ");
						System.out.println("CPF do funcionario:");
						String cpfF = in.nextLine();

						try {

							Funcionarios funcionario = lojaMagica.procurarFuncionario(cpfF);
							System.out.println("\n\nNome do funcionario: " + funcionario.getNome());
							System.out.println("Contato do funcionario: " + funcionario.getContato());
							System.out.println("\n\n");

						} catch (FuncionarioInexistenteException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}
				}

			}

			// clientes
			if (entrada == 5) {
				while (opcao != 5) {
					System.out.println("Voce esta no gerenciamento de clientes. Selecione o que deseja fazer.");
					System.out.println("1 - Cadastrar cliente");
					System.out.println("2 - Remover cliente");
					System.out.println("3 - Atualizar cliente");
					System.out.println("4 - Procurar cliente");
					System.out.println("5 - Sair \n");

					opcao = in.nextInt();

					// cadastrar cliente
					if (opcao == 1) {
						in.nextLine();
						System.out.println("Para cadastrar uma cliente, digite o que se pede:");
						System.out.println("Nome do cliente: ");
						String nomeC = in.nextLine();
						System.out.println("CPF do cliente: ");
						String cpfC = in.nextLine();
						System.out.println("Especie do cliente: ");
						String especieC = in.nextLine();
						System.out.println("Contato do cliente");
						String contatoC = in.nextLine();

						try {

							Cliente objCliente = new Cliente(nomeC, cpfC, especieC, contatoC);
							lojaMagica.cadastrarCliente(objCliente);
							System.out.println("\n\nCliente cadastrado com sucesso!\n\n");

						} catch (ClienteJaCadastradoException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

					// remover cliente
					if (opcao == 2) {
						in.nextLine();

						System.out.println("Para remover um cliente, digite o que se pede:");
						System.out.println("CPF do cliente: ");
						String cpfC = in.nextLine();

						try {

							lojaMagica.removerCliente(cpfC);
							System.out.println("\n\nCliente removido com sucesso!\n\n");

						} catch (ClienteNaoEncontradoException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

					// atualizar cliente
					if (opcao == 3) {
						in.nextLine();
						System.out.println("Para atualizar um cliente, digite o que se pede: ");
						System.out.println("CPF do cliente");
						String cpfC = in.nextLine();

						try {
							boolean x = lojaMagica.verificarCliente(cpfC);
							if(x) {
								System.out.println("Insira o novo nome do cliente:");
								String nomeC = in.nextLine();
								System.out.println("Insira a nova especie do cliente:");
								String especieC = in.nextLine();
								System.out.println("Insira o novo contato do cliente:");
								String contatoC = in.nextLine();
								Cliente objCliente = new Cliente(nomeC, cpfC, especieC, contatoC);
								lojaMagica.atualizarCliente(objCliente);
								System.out.println("\n\nCliente atualizado com sucesso!\n\n");
							}
							else {
								System.out.println("\n\n******ERRO******\n\n");
								System.out.println("Cliente não encontrado\n");
								System.out.println("\n\n******ERRO******\n\n");
							}
						} catch (ClienteNaoEncontradoException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}

					// procurar cliente
					if (opcao == 4) {
						in.nextLine();
						System.out.println("Para procurar um cliente, digite o que se pede: ");
						System.out.println("CPF do cliente:");
						String cpfC = in.nextLine();

						try {

							Cliente clienteProcurado = lojaMagica.procurarCliente(cpfC);
							System.out.println("\n\nNome do cliente: " + clienteProcurado.getNome());
							System.out.println("CPF do cliente: " + clienteProcurado.getCpf());
							System.out.println("Especie do cliente: " + clienteProcurado.getEspecie());
							System.out.println("Contato do cliente: " + clienteProcurado.getContato());
							System.out.println("\n\n");

						} catch (ClienteNaoEncontradoException e) {
							System.out.println("\n\n******ERRO******\n\n");
							System.out.println(e.getMessage() + "\n");
							System.out.println("\n\n******ERRO******\n\n");
						}

					}
				}

			}
		}
	}
}