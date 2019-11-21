package UI;

import Fachada.Fachada;
import pacoteClassesPessoa.*;
import pacoteClassesDemanda.*;
import pacoteClassesReserva.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fachada fachada;
		System.out.println("Sejam bem-vindos ao site da Defensoria Publica do CIN!");
		System.out.println("Digite 1 para Lista e 2 para Array.");
		try {
			fachada = new Fachada(in.nextInt());
			in.nextLine();
			while (true) {
				try {
					System.out.println("Gostaria de acessar Pessoas(1), Demanda(2), Reserva(3)? Se desejar sair do site, digite 0.");
					int menu = in.nextInt();
					in.nextLine();
					if (menu == 0) {
						System.out.println("Obrigado(a). Esperamos ter ajudado!");
						break;
					}
					switch (menu) {
					case 1:
						System.out.println(
								"Você deseja: Cadastrar Pessoa(1), Procurar Pessoa(2), Atualizar dados de Pessoa(3), Deletar Pessoa(4)");
						int escolha = in.nextInt();
						in.nextLine();
						switch (escolha) {
						case 1:
							System.out.println("Deseja cadastrar Pessoa Física (1) ou Jurídica(2)?");
							int tipopessoa = in.nextInt();
							in.nextLine();
							switch (tipopessoa) {
							case 1:
								System.out.print("Digite o nome: ");
								String nome = in.nextLine();
								System.out.print("Digite o endereço: ");
								String zipcode = in.nextLine();
								System.out.print("Digite o telefone: ");
								String telefone = in.nextLine();
								System.out.print("Digite o CPF: ");
								String CPF = in.nextLine();
								PessoaFisica pessoa = new PessoaFisica(nome, zipcode, telefone, CPF);
								fachada.cadastrarPessoa(pessoa);
								System.out.println("Pessoa cadastrada com sucesso!");
								break;
							case 2:
								System.out.print("Digite o nome: ");
								nome = in.nextLine();
								System.out.print("Digite o endereço: ");
								zipcode = in.nextLine();
								System.out.print("Digite o telefone: ");
								telefone = in.nextLine();
								System.out.print("Digite o CNPJ: ");
								String CNPJ = in.nextLine();
								PessoaJuridica empresa = new PessoaJuridica(nome, zipcode, telefone, CNPJ);
								fachada.cadastrarPessoa(empresa);
								System.out.println("Empresa cadastrada com sucesso!");
								break;
							}
							break;
						case 2:
							System.out.print("Digite CPF ou CNPJ, por favor: ");
							String documento = in.nextLine();
							Pessoa pessoa = fachada.procurarPessoa(documento);
							System.out.println("Pessoa encontrada. O nome dela é " + pessoa.getNome());
							break;
						case 3:
							System.out.print("Gostaria de atualizar Pessoa Física(1) ou Jurídica(2)?");
							int atualizar = in.nextInt();
							in.nextLine();
							switch (atualizar) {
							case 1:
								System.out.print("Digite CPF de Pessoa Física já cadastrada: ");
								String doc = in.nextLine();
								PessoaFisica person = (PessoaFisica) fachada.procurarPessoa(doc);
								System.out.print("Digite o nome que gostaria de atualizar: ");
								String nome = in.nextLine();
								System.out.print("Digite o endereço que gostaria de atualizar: ");
								String zipcode = in.nextLine();
								System.out.print("Digite o telefone que gostaria de atualizar: ");
								String telefone = in.nextLine();
								PessoaFisica personnova = new PessoaFisica(nome, zipcode, telefone, doc);
								fachada.atualizarPessoa(person, personnova);
								System.out.println("Pessoa atualizada com sucesso!");
								break;
							case 2:
								System.out.print("Digite CNPJ de Pessoa Física já cadastrada: ");
								doc = in.nextLine();
								PessoaJuridica empresa = (PessoaJuridica) fachada.procurarPessoa(doc);
								System.out.print("Digite o nome que gostaria de atualizar: ");
								nome = in.nextLine();
								System.out.print("Digite o endereço que gostaria de atualizar: ");
								zipcode = in.nextLine();
								System.out.print("Digite o telefone que gostaria de atualizar: ");
								telefone = in.nextLine();
								PessoaJuridica empresanova = new PessoaJuridica(nome, zipcode, telefone, doc);
								fachada.atualizarPessoa(empresa, empresanova);
								System.out.println("Empresa atualizada com sucesso!");
								break;
							}
							break;
						case 4:
							System.out.print("Digite o CPF ou CNPJ da pessoa que gostaria de deletar: ");
							String docprocurar = in.nextLine();
							Pessoa pessoa1 = fachada.procurarPessoa(docprocurar);
							fachada.deletarPessoa(pessoa1);
							System.out.println("Exclusão efetuada.");
							break;
						}
						break;
					case 2:
						System.out.println(
								"Você deseja: Cadastrar Demanda(1), Procurar Demanda(2), Atualizar dados da Demanda(3), Deletar Demanda(4)");
						escolha = in.nextInt();
						in.nextLine();
						switch (escolha) {
						case 1:
							System.out.print("Digite CPF ou CNPJ de pessoa já cadastrada para adicionar sua Ação Judicial: ");
							String doc = in.nextLine();
							Pessoa pessoa = fachada.procurarPessoa(doc);
							System.out.print("Digite área do Direito em que se enquadra sua Ação (ex: Civil, Família): ");
							String area = in.nextLine();
							System.out.print("Digite tipo de causa (ex: usucapião, danos morais): ");
							String demanda = in.nextLine();
							Demanda lide = new Demanda(pessoa, area, demanda);
							int codigo = fachada.cadastrarDemanda(lide).getCodigo();
							System.out.println("Acão Judicial cadastrada com sucesso! O Código da sua Ação é " + codigo);
							break;
						case 2:
							System.out.print("Digite o código da Ação Judicial já cadastrada: ");
							int codigoprocurar = in.nextInt();
							in.nextLine();
							Demanda procurada = fachada.procurarDemanda(codigoprocurar);
							System.out.println("Ação encontrada. A área é " + procurada.getArea() + " e esta no nome de: " + procurada.getPessoa().getNome());
							break;
						case 3:
							System.out.print("Digite o código da Ação Judicial já cadastrada: ");
							int codigoatualizar = in.nextInt();						
							in.nextLine(); 
							Demanda antiga = fachada.procurarDemanda(codigoatualizar);
							System.out.print("Digite a nova área do Direito para sua Ação: ");
							String area1 = in.nextLine();
							System.out.print("Digite o novo tipo de causa: ");
							String causa = in.nextLine();
							Demanda atualizar = new Demanda(antiga.getPessoa(), area1, causa);
							fachada.atualizarDemanda(codigoatualizar, atualizar);
							System.out.println("Ação Judicial atualizada com sucesso!");
							break;
						case 4:
							System.out.println("Digite o código da Ação Judicial já cadastrada:");	
							int codigodeletar = in.nextInt();
							in.nextLine();
							fachada.deletarDemanda(codigodeletar);
							System.out.print("Exclusão efetuada com sucesso.");
						}
						break;
					case 3:
						System.out.println(
								"Você deseja: Cadastrar Reserva(1), Procurar Reserva(2), Atualizar dados da Reserva(3), Deletar Reserva(4)");
						escolha = in.nextInt();
						in.nextLine();
						switch (escolha) {
						case 1:
							System.out.print("Digite o código da Ação Judicial já cadastrada: ");
							int codigo = in.nextInt();
							in.nextLine();
							Demanda demanda = fachada.procurarDemanda(codigo);
							System.out.print("Digite um dia útil para agendar sua consulta com a Defensoria (ex: 21/11/2019): ");
							String data = in.nextLine();
							String [] dividir = data.split("/");
							int dia = Integer.parseInt(dividir[0]);
							int mes = Integer.parseInt(dividir[1]);
							int ano = Integer.parseInt(dividir[2]);
							System.out.println("O funcionamento da nossa sede ocorre das 9 da manhã as 18 da noite. Cada consulta com a Defensoria tem a duração de uma hora.");
							System.out.print("Digite uma hora para sua Reserva (ex: 9): ");
							int hora = in.nextInt();
							Reserva reserva = new Reserva(hora, dia, mes, ano, demanda);
							fachada.cadastrarReserva(reserva);
							System.out.println("Pronto! Sua reserva foi efetuada com sucesso. Agora é so aguardar o dia do atendimento.");
							System.out.println("Não se esqueça de anotar o código da sua reserva, é essencial para nos auxiliar no seu atendimento.");
							System.out.println("Seu código é: " + codigo);
							break;
						case 2:
							System.out.print("Digite o código da sua Reserva: ");
							codigo = in.nextInt();
							in.nextLine();
							String res = fachada.procurarReserva(codigo);
							System.out.println(res);
							break;
							
						case 3:
							System.out.print("Digite o código da sua Reserva: ");
							codigo = in.nextInt();
							in.nextLine();
							Demanda antiga = fachada.procurarDemanda(codigo);
							System.out.print("Digite nova data para sua Reserva (ex: 22/12/2019): ");
							data = in.nextLine();
							dividir = data.split("/");
							dia = Integer.parseInt(dividir[0]);
							mes = Integer.parseInt(dividir[1]);
							ano = Integer.parseInt(dividir[2]);
							System.out.println("Digite novo horário para sua reserva: ");
							hora = in.nextInt();
							Reserva atualizar = new Reserva (hora, dia, mes, ano, antiga);
							fachada.atualizarReserva(codigo, atualizar);
							String imprimir = fachada.procurarReserva(codigo);
							System.out.println("Reserva atualizada com sucesso. Sua consulta ocorrerá: " + imprimir);
							break;
							
						case 4:
							System.out.print("Digite o código da sua Reserva: ");
							codigo = in.nextInt();
							in.nextLine();
							fachada.deletarReserva(codigo);
							System.out.println("Exclusão efetuada com sucesso");
							break;
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}

	}

}
