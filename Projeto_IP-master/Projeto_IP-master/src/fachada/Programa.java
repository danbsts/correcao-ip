package fachada;

import ingredientes.*;
import pratos.*;
import mesas.*;
import pedidos.*;

import java.util.Scanner;

import funcionarios.*;

public class Programa {

	public static void main(String[] args){

		// Inicializando a Fachada

		RepositorioIngredientesLista repositorioIngredientesLista = new RepositorioIngredientesLista();
		RepositorioPratosLista repositorioPratosLista = new RepositorioPratosLista();
		RepositorioMesaLista repositorioMesaLista = new RepositorioMesaLista();
		RepositorioPedidosLista repositorioPedidosLista = new RepositorioPedidosLista();
		RepositorioFuncionariosLista repositorioFuncionariosLista = new RepositorioFuncionariosLista();

		App fachada = new App(repositorioIngredientesLista, repositorioPratosLista, repositorioMesaLista,
				repositorioPedidosLista, repositorioFuncionariosLista);

		// Inicializando os metodos
		Scanner in = new Scanner(System.in);
		String comando = "";
		String operacao = "";
		String auxiliar = "";

		for (boolean sessao = false, programaAberto = true; programaAberto == true;) {
			System.out.println("Digite o seu Login:");
			String loginAtual = in.nextLine();
			System.out.println("Digite sua senha:");
			String senhaAtual = in.nextLine();

			sessao = true;
			
			for (; sessao == true;) {

				System.out.println("Bem vindo ao SCR (Sistema de Controle de Restaurante) \n ");
				System.out.println(
						"Escolha um dos comandos abaixo para selecionar qual funcionalidade voce deseja usar \n");
				System.out.println("1 - Pedidos");
				System.out.println("Selecione essa opcao para acessar as operacoes relacionadas a pedidos. \n");
				System.out.println("2 - Cardapio");
				System.out.println("Selecione essa opcao para acessar as operacoes relacionadas a cardapio. \n");
				System.out.println("3 - Mesas");
				System.out.println("Selecione essa opcao para acessar as operacoess relacionadas a mesas. \n");
				System.out.println("4 - Ingredientes");
				System.out.println("Selecione essa opcao para acessar as operacoes relacionadas a ingredientes. \n");
				System.out.println("5 - Funcionarios");
				System.out.println("Selecione essa opcao para acessar as operacoes relacionadas a funcionarios. \n");
				System.out.println("6 - Finalizar Sessao");
				System.out.println("Selecione essa opcao para finalizar sua sessao. \n");

				comando = in.nextLine();

				///////////////////////////////////////////////
				// Pedidos
				if (comando.equals("1")) {
					System.out.println("Voce escolheu a opcao Pedidos" + "\n"
							+ "Escolha um dos comandos abaixo para selecionar a operacao desejada:");

					System.out.println("1 - Cadastrar Pedido");
					System.out.println("Selecione essa opcao para inserir um novo pedido no sistema \n");
					System.out.println("2 - Remover Pedido");
					System.out.println("Selecione essa opcao para remover um pedido do sistema \n");
					System.out.println("3 - Atualizar Pedido");
					System.out.println("Selecione essa opcao para atualizar os status de um pedido do sistema \n");
					System.out.println("4 - Voltar");
					System.out.println("Selecione essa opcao para voltar para a tela anterior \n");

					operacao = in.nextLine();

					// Pedidos Pedido
					int numeroMesa;

					if (operacao.equals("1")) {
						System.out.println("Voce escolheu a opcao cadastrar pedido");
						System.out.println("Digite nome do prato: ");
					String nomePrato = in.next();
						in.nextLine();
						System.out.println("Digite a quantidade: ");
                    int quantidadePedido = in.nextInt();
                         in.nextLine();  
                        System.out.println("Digite o identificador do pedido: ");
                    String identificadorPedido = in.nextLine();
                    System.out.println("Digite o identificador da mesa: ");
                    int identificadorMesa = in.nextInt();
                   
                    try {
                    	Prato prato = fachada.procurarPrato(nomePrato);
                    	Pedidos pedido = new Pedidos (prato, quantidadePedido, identificadorPedido);
                    	try{
                    		 try {
                             	Mesa mesa = fachada.procurarMesa(identificadorMesa);
                             	try {
									fachada.fazerPedido(pedido, mesa);
								} catch (IngredientesInsuficientesException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                             } catch (MesaNaoCadastradaException e) {
                             	System.out.println(e);
                             }
                            
                          } catch (PedidoJaCadastradoException e){
                            System.out.println(e);
                          }
                    } catch (PratoNaoCadastradoException e) {
                    	System.out.println(e);
                    }
                    
                   
                    
                    
                    
					} else if (operacao.equals("2")) {
						System.out.println("Voce escolheu a opcao remover pedido");
						System.out.println("Digite o identificador do pedido: ");
						String identificadorPedido = in.next();
					    in.nextLine();
					    try {
					    	Pedidos pedido = fachada.procurarPedido(identificadorPedido);
					    	System.out.println("Digite o identificador da mesa: ");
						    int identificadorMesa = in.nextInt();
						    in.nextLine();
					    	try {
						    	Mesa mesa = fachada.procurarMesa(identificadorMesa);
						    } catch (MesaNaoCadastradaException e) {
						    	System.out.println(e);
						    }
					    } catch (PedidoNaoCadastradoException e) {
					    	System.out.println(e);
					    }
					    
					    
					} else if (operacao.equals("3")) {
						System.out.println("Voce escolheu a opcao atualizar pedido");
						System.out.println("Digite nome do novo prato: ");
						String novoPrato = in.next();
						in.nextLine();
						System.out.println("Digite nova quantidade de pratos: ");
						int quantidadeNova = in.nextInt();
						in.nextLine();
						System.out.println("Digite um identificador do pedido : ");
						String identificadorPedido = in.next();
						in.nextLine();
						System.out.println("Digite o identificador da mesa: ");
	                    int identificadorMesa = in.nextInt();
	                    
	                    try {
	                    	Pedidos pedido = fachada.procurarPedido(identificadorPedido);
	                    	try {
	                    		Mesa mesa = fachada.procurarMesa(identificadorMesa);
	                    		fachada.atualizarPedido(pedido,mesa);
	                      	} catch (MesaNaoCadastradaException e) {
	                    		System.out.println(e);
	                    	}
	                    } catch (PedidoNaoCadastradoException e) {
	                    	System.out.println(e);
	                    }
	                   
					} else if (operacao.equals("4")) {
					} else
						System.out.println("Comando invalido. Voce sera redirecionado para a pagina inicial.");

					///////////////////////////////////////////////
					// Cardapio (Falta teste)
				} else if (comando.equals("2")) {
					System.out.println("Voce escolheu a opcao Cardapio" + "\n"
							+ "Escolha um dos comandos abaixo para selecionar a operacao desejada:");

					System.out.println("1 - Cadastrar Prato");
					System.out.println("Selecione essa opcao para inserir um novo prato no cardapio \n");
					System.out.println("2 - Remover Prato");
					System.out.println("Selecione essa opcao para remover um prato do cardapio \n");
					System.out.println("3 - Atualizar Prato");
					System.out.println("Selecione essa opcao para atualizar os status de um prato do cardapio \n");
					System.out.println("4 - Voltar");
					System.out.println("Selecione essa opcao para voltar para a tela anterior \n");

					operacao = in.next();
					in.nextLine();

					String nomePrato;
					String fim;
					double precoPrato;
					int contador = 0;
					String identificadorIngrediente = "";
					Ingrediente[] ingredientesPrato = new Ingrediente[10];
					int identificadorPrato;

					if (operacao.equals("1")) {
						System.out.println("Voce escolheu a opcao cadastrar prato \n");
						System.out.println("Digite o nome do novo prato");
						nomePrato = in.nextLine();
						System.out.println("Agora digite o preco desse prato:");
						precoPrato = in.nextDouble();
						in.nextLine();
						System.out.println(
								"Agora e necessario que voce informe os ingredientes que sao usados no prato : \n Ao terminar, digite fim");

						for (fim = ""; !fim.equals("fim");) {
							
							
							System.out.println("Digite um identificador para seu ingrediente:");
							identificadorIngrediente = in.nextLine();
                                                  
							System.out.println("Fim?");
							fim = in.nextLine();	

						}
						Ingrediente ingrediente;
						try {
							ingrediente = fachada.procurarIngrediente(identificadorIngrediente);
							ingredientesPrato[contador] = ingrediente;
							contador++;		
							System.out.println("Agora digite o identificador desse prato:");
							identificadorPrato = in.nextInt();

							Prato prato = new Prato(nomePrato, precoPrato, ingredientesPrato, identificadorPrato);
							System.out.println("Prato cadastrado com sucesso!");
							System.out.println("-----------------------------------");
							try {
								try {
									fachada.cadastrarPrato(prato);
								} catch (IngredientesInsuficientesException e) {
									e.printStackTrace();
								}
							} catch (PratoJaCadastradoException e) {
								System.out.println(e);
							}
							
						} catch (IngredienteNaoCadastradoException e) {
							
							e.printStackTrace();
							in.nextLine();
							fim = "fim";
						}
						

					} else if (operacao.equals("2")) {
						System.out.println("Voce escolheu a opcao remover prato");
						System.out.print("Digite o nome do prato: ");
						nomePrato = in.nextLine();
						
						Prato pratoRemover;
						try {
							pratoRemover = fachada.procurarPrato(nomePrato);
							try {
								fachada.removerPrato(pratoRemover);
								System.out.println("Prato removido com sucesso!");
								System.out.println("-----------------------------------");
							} catch (PratoNaoCadastradoException e) {
								e.printStackTrace();
								in.nextLine();
							}
						} catch (PratoNaoCadastradoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							in.nextLine();
						}


					} else if (operacao.equals("3")) {
						contador = 0;
						Ingrediente ingrediente;
						System.out.println("Voce escolheu a opcao atualizar prato");
						System.out.print("Digite o nome do prato: ");
						String novoNomePrato = in.nextLine();
						System.out.print("Digite o novo preco do prato (Se desejado): ");
						Double novoPrecoPrato = in.nextDouble(); 
						in.nextLine();
						System.out.println("Digite os novos ingredientes do prato (Se desejado): \n Ao terminar, digite fim.");
						Ingrediente[] ingredientesNovoPrato = new Ingrediente[10];
						for (fim = ""; !fim.equals("fim");) {
				
							System.out.println("Digite um identificador para seu ingrediente:");
							identificadorIngrediente = in.nextLine();
                                                  
							System.out.println("Fim?");
							fim = in.nextLine();

						}
						
						try {
							ingrediente = fachada.procurarIngrediente(identificadorIngrediente);
							ingredientesNovoPrato[contador] = ingrediente;
							contador++;		
							System.out.println("Agora digite o identificador desse prato:");
							identificadorPrato = in.nextInt();

							Prato novoPrato = new Prato(novoNomePrato, novoPrecoPrato, ingredientesNovoPrato, identificadorPrato);
							
							try {
								fachada.atualizarPrato(novoPrato);
								System.out.println("Prato atualizado com sucesso!");
								System.out.println("-----------------------------------");
								
							} catch (PratoNaoCadastradoException e) {
								e.printStackTrace();
								in.nextLine();
							}
							
						} catch (IngredienteNaoCadastradoException e) {
							
							e.printStackTrace();
							in.nextLine();
							fim = "fim";
						}

					} else if (operacao.equals("4")) {
					} else
						System.out.println("Comando invalido. Voce sera redirecionado para a pagina inicial.");

					///////////////////////////////////////////////
					// Mesas
				} else if (comando.equals("3")) {
					System.out.println("Voce escolheu a opcao Mesas" + "\n"
							+ "Escolha um dos comandos abaixo para selecionar a operacao desejada:");

					System.out.println("1 - Cadastrar Mesa");
					System.out.println("Selecione essa opcao para inserir uma nova mesa ao sistema \n");
					System.out.println("2 - Remover Mesa");
					System.out.println("Selecione essa opcao para remover um mesa do sistema \n");
					System.out.println("3 - Atualizar Mesa");
					System.out.println("Selecione essa opcao para atualizar os status de um mesa do sistema \n");
					System.out.println("4 - Finalizar Pedidos da Mesa");
					System.out.println("Selecione essa opcao para atualizar os status de um mesa do sistema \n");
					System.out.println("5 - Voltar");
					System.out.println("Selecione essa opcao para voltar para a tela anterior \n");

					operacao = in.next();

					if (operacao.equals("1")) {
                        
											System.out.println("Você escolheu a opção cadastrar mesa");
                        					System.out.println ("Qual o numero da mesa que você quer cadastrar?");
                                          	int numeroMesa= in.nextInt();
                                          	in.nextLine();
                                          	System.out.println("Digite o login :");
                                          	String loginFuncionario = in.nextLine();
                                          	System.out.println("Digite a senha :");
                                          	String senhaFuncionario = in.nextLine();
                                          	try {
                                          		Funcionario funcionarioAtual = fachada.procurarFuncionario(loginFuncionario,  senhaFuncionario);
                                          		RepositorioPedidosLista repPedido =new RepositorioPedidosLista();
                                          		Mesa mesaNova = new Mesa( funcionarioAtual , numeroMesa, repPedido);
                                          		try {
                                          			fachada.cadastrarMesa(mesaNova);
                                          			System.out.println("Mesa cadastrada com sucesso!");
                                          		}catch(MesaJaCadastradaException e) {
                                          			System.out.println(e);
                                          		}
                                          	}catch (FuncionarioNaoExistenteException t) {
                                          		System.out.println(t);
                                          	}
                                          	
                                          	
                                                  //funcionario que esta utilizando o sistema
                                          
					} else if (operacao.equals("2")) {
						System.out.println("Você escolheu a opção remover mesa");
                         	System.out.println("Qual o numero da mesa que deseja remover?");
                                          	int numeroMesa= in.nextInt();
                                          	try {
                                          		Mesa mesaRemover = fachada.procurarMesa(numeroMesa);
                            
                                          		fachada.removerMesa(mesaRemover);
                                          		System.out.println("Mesa removida com sucesso");
                                          		
                                          			
                                          		
                                          	}catch(MesaNaoCadastradaException e){
                                          		System.out.print(e);
                                          	}

                                          	
					} else if (operacao.equals("3")) {
						System.out.println("Voce escolheu a opcao atualizar mesa");
						System.out.println("Qual a mesa que deseja atualizar?");
                      	int numeroMesa= in.nextInt();
                      	System.out.println("Qual o novo numero da mesa que deseja atualizar?");
                      	int novoNum =in.nextInt();
                      	in.nextLine();
                      	System.out.println("Login do funcionario que ficara responsavel:");
                      	String log = in.nextLine();
                      	System.out.println("Senha do funcionario que ficara responsavel:");
                      	String senhaFuncio = in.nextLine();
                      	try {
                      		Funcionario funcionarioNovo = fachada.procurarFuncionario(log,  senhaFuncio);
                      		
                      		try {
                      			Mesa mesaAtualizar = fachada.procurarMesa(numeroMesa);
                      			fachada.atualizarMesa(mesaAtualizar,novoNum,funcionarioNovo);
                      			System.out.print("Mesa atualizada com sucesso!");
                      		}catch(MesaNaoCadastradaException e){
                      			System.out.print(e);
                      		}
                      	}catch(FuncionarioNaoExistenteException t){
                      		System.out.println(t);
                      	}
						
					} else if (operacao.equals("4")) {
						System.out.println("Voce escolheu a opcao finalizar pedidos da mesa");
						System.out.println("Qual o numero da mesa que deseja finalizar?");
						int numeroMesa= in.nextInt();
						try {
                      		Mesa mesaFinalizar = fachada.procurarMesa(numeroMesa);
                      		String conta =fachada.pedirConta(mesaFinalizar);
                      		System.out.print(conta);
                      	}catch(MesaNaoCadastradaException e){
                      		System.out.print(e);
                      	}
						
						
					} else if (operacao.equals("5")) {
					} else
						System.out.println("Comando invalido. Voce sera redirecionado para a pagina inicial.");
					///////////////////////////////////////////////
					// Ingredientes
				} else if (comando.equals("4")) {
					System.out.println("Voce escolheu a opcao Ingredientes" + "\n"
							+ "Escolha um dos comandos abaixo para selecionar a operacao desejada: \n");
					System.out.println("1 - Cadastrar Ingrediente");
					System.out.println("Selecione essa opcao para inserir um novo ingrediente no estoque \n");
					System.out.println("2 - Remover Ingrediente");
					System.out.println("Selecione essa opcao para remover um ingrediente do estoque \n");
					System.out.println("3 - Atualizar Ingrediente");
					System.out.println("Selecione essa opcao para atualizar os status de um ingrediente do estoque \n");
					System.out.println("4 - Voltar");
					System.out.println("Selecione essa opcao para voltar para a tela anterior \n");

					operacao = in.next();
					in.nextLine();

					String nomeIngrediente;
					int qtdIngrediente;
					double precoIngrediente;
					String identificadorIngrediente;

					if (operacao.equals("1")) {
						System.out.println("Voce escolheu a opcao cadastrar ingrediente \n");
						System.out.print("Digite o nome do novo ingrediente:");
						nomeIngrediente = in.nextLine();
						System.out.print("Agora digite a quantidade desse ingrediente:");
						qtdIngrediente = in.nextInt();
						in.nextLine();
						System.out.print("Agora digite o preco do ingrediente:");
						precoIngrediente = in.nextDouble();
						in.nextLine();
						System.out.print("Agora digite um identificador para seu ingrediente:");
						identificadorIngrediente = in.nextLine();

						Ingrediente ingrediente = new Ingrediente(nomeIngrediente, qtdIngrediente,
								precoIngrediente, identificadorIngrediente);
						try {
							fachada.cadastrarIngrediente(ingrediente);
							System.out.println("Ingrediente Cadastrado com sucesso!");
							System.out.println("-----------------------------------");
						} catch (IngredienteJaCadastradoException e) {
							System.out.println(e);
							in.nextLine();
						}

					} else if (operacao.equals("2")) {
						System.out.println("Voce escolheu a opcao remover ingrediente \n");
						System.out.println("Digite o identificador do ingrediente que voce quer remover:");
						identificadorIngrediente = in.nextLine();

						try {
							fachada.removerIngrediente(identificadorIngrediente);
							System.out.println("Ingrediente Removido com sucesso!");
							System.out.println("-----------------------------------");
						} catch (IngredienteNaoCadastradoException e) {
							System.out.println(e);
							in.nextLine();
						}

					} else if (operacao.equals("3")) {
						System.out.println("Voce escolheu a opcao atualizar ingrediente");
						System.out.println("Digite o nome do ingrediente");
						nomeIngrediente = in.nextLine();
						System.out.println("Agora digite a quantidade desse ingrediente:");
						qtdIngrediente = in.nextInt();
						in.nextLine();
						System.out.println("Agora digite o preco do ingrediente:");
						precoIngrediente = in.nextDouble();
						in.nextLine();
						System.out.println("Agora digite um identificador para seu ingrediente:");
						identificadorIngrediente = in.nextLine();

						Ingrediente ingrediente = new Ingrediente(nomeIngrediente, qtdIngrediente,
								precoIngrediente, identificadorIngrediente);
					
						try {
							fachada.atualizarIngrediente(ingrediente);
							System.out.println("Ingrediente Atualizado com sucesso!");
							System.out.println("-----------------------------------");
						} catch (IngredienteNaoCadastradoException e) {
							System.out.println(e);
							in.nextLine();
						}
						
					} else if (operacao.equals("4")) {
					} else
						System.out.println("Comando invalido. Voce sera redirecionado para a pagina inicial.");

					///////////////////////////////////////////////
					// Funcionarios
				} else if (comando.equals("5")) {
					System.out.println("Voc� escolheu a op��o Funcion�rios" + "\n"
							+ "Escolha um dos comandos abaixo para selecionar a opera��o desejada:");
					System.out.println("1 - Cadastrar Funcion�rio");
					System.out.println("Selecione essa op��o para cadastrar um novo funcion�rio ao sistema \n");
					System.out.println("2 - Remover Funcion�rio");
					System.out.println("Selecione essa op��o para remover um funcion�rio do sistema \n");
					System.out.println("3 - Atualizar Funcion�rio");
					System.out.println("Selecione essa op��o para atualizar os status de um funcion�rio no sistema \n");
					System.out.println("4 - Voltar");
					System.out.println("Selecione essa op��o para voltar para a tela anterior \n");

					operacao = in.nextLine();

                                  
                    //CADASTRO         	
					if (operacao.equals("1")) {
						System.out.println("Voc� escolheu a op��o cadastrar funcion�rio");
                                          	//INFORMACOES
											System.out.println("Digite o nome do novo Funcion�rio: ");
											String nomeFuncionario = in.nextLine();
                                          	System.out.println("Digite o login de "+nomeFuncionario+": ");
                                         	String loginFuncionario = in.nextLine();
                                          	System.out.println("Digite a senha de "+nomeFuncionario+": ");
                                          	String senhaFuncionario = in.nextLine();	
                                          	System.out.println("Digite o endere�o de "+nomeFuncionario+": ");
                                          	String enderecoFuncionario = in.nextLine();
                                          	System.out.println("Digite a data de nascimento de "+nomeFuncionario+": ");
                                          	String dataFuncionario = in.nextLine();	
                                          	System.out.println("Digite o CPF de "+nomeFuncionario+": "); 
                                          	String cpfFuncionario = in.nextLine();	
                                          	System.out.println("Digite o RG de "+nomeFuncionario+": "); 
                                          	String rgFuncionario = in.nextLine();
                                          	System.out.println("Digite a ocupa��o de "+nomeFuncionario+": "); 
                                          	String typeFuncionario = in.nextLine();
                                          	//GARCOM
                                          	if(typeFuncionario.equals("Garcom")){
                                          		System.out.println("Defina o sal�rio de "+nomeFuncionario+": ");
                                          		double salarioFuncionario = in.nextDouble();
                                                
                                          		Funcionario novoFuncionario = new Garcom(loginFuncionario, senhaFuncionario, nomeFuncionario,
                                                enderecoFuncionario, dataFuncionario, cpfFuncionario, rgFuncionario, salarioFuncionario);
                                        	
                                          		try {
													fachada.cadastrarFuncionario(novoFuncionario);
													System.out.println("O Gar�om "+nomeFuncionario+" foi adicionado com sucesso!");
												} catch (FuncionarioJaCadastradoException e) {
													e.printStackTrace();
												}
                                          	}
                                            //GERENTE
                                          	else if(typeFuncionario.equals("Gerente")){
                                          		System.out.println("Defina o sal�rio de "+nomeFuncionario+": ");
                                          		double salarioFuncionario = in.nextDouble();
                                                
                                          		Funcionario novoFuncionario = new Gerente(loginFuncionario, senhaFuncionario, nomeFuncionario,
                                                enderecoFuncionario, dataFuncionario, cpfFuncionario, rgFuncionario, salarioFuncionario);
                                        	
                                          		try {
													fachada.cadastrarFuncionario(novoFuncionario);
													System.out.println("O Gerente "+nomeFuncionario+" foi adicionado com sucesso!");
												} catch (FuncionarioJaCadastradoException e) {
													e.printStackTrace();
												} 
                                            }
                                          	
                    //REMOVER
					} else if (operacao.equals("2")) {
											System.out.println("Voc� escolheu a op��o remover funcion�rio");
											System.out.println("Para remover um funcion�rio digite o seu respectivo login: ");
											String loginFuncionario = in.nextLine();
											System.out.println("Agora sua respectiva senha: ");
											String senhaFuncionario = in.nextLine();
											try {
											Funcionario removido = fachada.procurarFuncionario(loginFuncionario, senhaFuncionario);
											boolean check = true;
											while(check) {
												System.out.println("Deseja mesmo remover "+removido.getNome()+"?(sim/nao) ");
												String res = in.nextLine();
												if(res.equals("sim")) {
													check = false;
													fachada.removerFuncionario(removido);
													System.out.println("Ok. Funcionario removido");
												}else if(res.equals("nao")) {
													check = false;
													System.out.println("Ok. Opera��o cancelada");
												}
											}
											}catch(FuncionarioNaoExistenteException e) {
												e.printStackTrace();
											}
					
											
					} else if (operacao.equals("3")) {
						System.out.println("Voc� escolheu a op��o atualizar funcion�rio");
						boolean check = true;
						while(check) {
						System.out.println("Deseja ver a rela��o de funcionarios antes de atualizar?(sim/nao) ");
						String res = in.nextLine();
							if(res.equals("sim")) {
								check = false;
								try {
									System.out.println(fachada.listarFuncionarios());
								} catch (NaoHaFuncionariosException e) {
									e.printStackTrace();
								}
							}else if(res.equals("nao")) {
								check = false;
								System.out.println("Ok");
							}else {}
						}
						System.out.println("Para atualizar um funcion�rio digite o seu respectivo login: ");
						String loginFuncionario = in.nextLine();
						System.out.println("Agora sua respectiva senha: ");
						String senhaFuncionario = in.nextLine();
						try {
							Funcionario atualizado = fachada.procurarFuncionario(loginFuncionario, senhaFuncionario);
							System.out.println("O que deseja mudar em seu Funcionario? ");
							System.out.println("1 - Alterar Endere�o");
							System.out.println("2 - Alterar Login");
							System.out.println("3 - Alterar Senha");
							int alteracao = in.nextInt();
							boolean continuar = true;
							while(continuar) {
								switch (alteracao) {
								case 1:
									continuar = false;
									System.out.println("o endere�o atual � "+atualizado.getEndereco());
									System.out.println("Digite o novo Endere�o: ");
									String endereco = in.nextLine();
									atualizado.setEndereco(endereco);
									fachada.atualizarFuncionario(atualizado);
									System.out.println("Endere�o alterado com sucesso");
								break;
								case 2:
									continuar = false;
									System.out.println("o login atual � "+atualizado.getLogin());
									System.out.println("Digite o novo Login: ");
									String login = in.nextLine();
									atualizado.setLogin(login);
									fachada.atualizarFuncionario(atualizado);
									System.out.println("Login alterado com sucesso");
								break;
								case 3:
									continuar = false;
									System.out.println("Digite a nova senha: ");
									String novaSenha = in.nextLine();
									atualizado.setSenha(novaSenha);
									fachada.atualizarFuncionario(atualizado);
									System.out.println("Senha alterada com sucesso");
								break;
								default:
									System.out.println("Comando inv�lido, favor digitar um dos comandos indicados:");
									System.out.println("1 - Alterar Endere�o");
									System.out.println("2 - Alterar Login");
									System.out.println("3 - Alterar Senha");
									alteracao = in.nextInt();
								break;
								}
							}
							
						
							}catch(FuncionarioNaoExistenteException e) {
								e.printStackTrace();
							}
						
						
						
						
						
						
						
					} else if (operacao.equals("4")) {
					} else
						System.out.println("Comando inv�lido. Voc� ser� redirecionado para a p�gina inicial.");

					///////////////////////////////////////////////
					// Finalizar sessao
				} else if (comando.equals("6")) {
					System.out.println("Voce deseja finalizar sua sessao? \nDigite Sim para confirmar");
					auxiliar = in.next();
					if (auxiliar.equals("Sim") || auxiliar.equals("sim")) {
						System.out.println("Sua sessao foi finalizada");
						sessao = false;
						programaAberto = false;
					} else
						System.out.println("Comando invalido. Voce sera redirecionado para a pagina inicial. \n");
					///////////////////////////////////////////////
				} else
					System.out.println("Comando invalido. Por favor digite um dos comandos abaixo. \n");

			}
		}
	}

}
