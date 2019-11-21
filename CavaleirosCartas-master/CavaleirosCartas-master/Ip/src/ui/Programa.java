package ui;

import cartas.*;
import decks.*;
import duelistas.*;
import extradecks.*;
import excecoes.ArrayCheioException;
import excecoes.CartaNaoCadastradaException;
import excecoes.DeckNaoCadastradoException;
import excecoes.ExtraDeckNaoCadastradoException;
import excecoes.IdJaCadastradoException;
import excecoes.NaoEncontradoException;


public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Repositorios e cadastro para Carta
		RepositorioCartas repCartasArray = new RepositorioCartasArray();
		//RepositorioCartas repCartasLista = new RepositorioCartasLista();
		CadastroCartas cadCartas = new CadastroCartas(repCartasArray);
		//CadastroCartas cadCartas = new CadastroCartas(repCartasLista);

		// Repositorios e cadastro para Deck
		RepositorioDecks repDecksArray = new RepositorioDecksArray();
		//RepositorioDecks repDecksLista = new RepositorioDecksLista();
		CadastroDecks cadDecks = new CadastroDecks(repDecksArray);
		//CadastroDecks cadDecks = new CadastroDecks(repDecksLista);

		// Repositorios e cadastro para Duelista
		RepositorioDuelistas repDuelistaArray = new RepositorioDuelistasArray();
		//RepositorioDuelistas repDuelistaLista = new RepositorioDuelistasLista();
		CadastroDuelistas cadDuelistas = new CadastroDuelistas(repDuelistaArray);
		//CadastroDuelistas cadDuelistas = new CadastroDuelistas(repDuelistaLista);

		// Repositorios e cadastro para ExtraDeck
		RepositorioExtraDecks repExtraDecksArray = new RepositorioExtraDecksArray();
		//RepositorioExtraDecks repExtraDecksLista = new RepositorioExtraDecksLista();
		CadastroExtraDecks cadExtraDecks = new CadastroExtraDecks(repExtraDecksArray);
		//CadastroExtraDecks cadExtraDecks = new CadastroExtraDecks(repExtraDecksLista);

		// Cartas criadas para teste
		Carta a = new CartaCavaleiro("Seiya",
				"Caracterizado principalmente por nunca desistir de lutar em qualquer situação", 2400, 1585,
				"Sagitário", "Cavaleiro de Bronze", "Pégaso", 213);
		Carta b = new CartaCavaleiro("Shiryu", "Shiryu é o mais calmo e reservado perante os outros cavaleiros", 3000,
				2500, "Libra", "Cavaleiros de Bronze", "Draco", 124);
		Carta c = new CartaPoder("Meteoro de Pégaso",
				" Concentrando a cosmo-energia, o Cavaleiro dispara 100 socos por segundos, a velocidade do som, que assumem a forma de meteoros/estrelas cadentes.",
				523);
		Carta d = new CartaEspectroHades("Redemoinho Esmagador",
				"Caronte concentra seu Cosmo entre seus punhos, em seguida ele dispara uma capsula ou vórtice de energia poderosa. ",
				235);
		Carta e = new CartaPoder("Cólera do Dragão",
				"Emanando um Cosmo Shiryu dispara uma rajada na forma de dragão que, se acerta, leva o oponente pelos ares.",
				243);
		Carta f = new CartaCavaleiro("Hyoga",
				"É arrogante, e bastante orgulhoso de sua força e seu poder, não hesitando em demonstrar tais qualidades.",
				1300, 1400, "Aquário", "Cavaleiros de Bronze", "Cygnus", 734);

		Carta g = new CartaPoder("Pó de Diamante",
				"Consiste em criar uma grande quantidade de finos cristais de gelo que avançam em alta velocidade sobre seu adversário.",
				773);

		Carta h = new CartaEspectroHades("Balança da Maldição",
				"Faraó toca com sua harpa uma melodia obscura. O inimigo perde os movimentos de seu corpo, em seguida a área onde Faraó e seu inimigo estão, é tomada de várias paredes antigas com escrituras egípicias.",
				212);
		Carta i = new CartaPoder("Ave Fênix",
				"Técnica mais poderosa do Cavaleiro de Fênix. Ikki usa a palma das mãos para criar um sopro furioso de ar em chamas, jogando o inimigo pelos ares.",
				921);
		Carta j = new CartaEspectroHades("Reencarnação",
				"lança uma esfera de cosmos que imobiliza o adversário que em seguida passa a ver todos os pecados que cometeu durante a vida.",
				635);
		// Decks para teste
		Deck deck1 = new Deck(1);
		Deck deck3 = new Deck(38);
		ExtraDeck extradeck1 = new ExtraDeck(34);
		ExtraDeck extradeck2 = new ExtraDeck(79);
		try {
			deck1.inserir(a);
			deck1.inserir(b);
			deck1.inserir(c);
			deck1.inserir(d);
			deck1.inserir(e);
			deck1.inserir(f);
			deck1.inserir(g);
			deck1.inserir(h);
			deck1.inserir(i);
			deck1.inserir(j);

			deck3.inserir(j);
			deck3.inserir(i);
			deck3.inserir(h);
			deck3.inserir(g);
			deck3.inserir(f);
			deck3.inserir(e);
			deck3.inserir(d);
			deck3.inserir(c);
			deck3.inserir(b);
			deck3.inserir(a);

			extradeck1.inserir(a);
			extradeck1.inserir(c);
			extradeck1.inserir(b);
			extradeck1.inserir(d);
			extradeck1.inserir(e);
			extradeck1.inserir(f);
			extradeck1.inserir(g);
			extradeck1.inserir(h);
			extradeck1.inserir(i);
			extradeck1.inserir(j);
			extradeck1.remover(921);
			extradeck1.inserir(g);

			extradeck2.inserir(a);
			extradeck2.inserir(a);
			extradeck2.inserir(a);
			extradeck2.inserir(a);
			extradeck2.inserir(e);
			extradeck2.inserir(f);
			extradeck2.inserir(g);
			extradeck2.inserir(h);
			extradeck2.inserir(i);
			extradeck2.inserir(j);

			// Caso teste para atingir o max do array
			// deck1.inserir(j);
			// System.out.println(a.getDesc());
			// System.out.println(c.getDesc());
			// System.out.println(d.getDesc());
		} catch (ArrayCheioException | NaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Jogo fachada = new Jogo(cadCartas, cadDecks, cadDuelistas, cadExtraDecks);
		Duelista duelista = new Duelista("Gabriel", 1, deck1, extradeck1);
		Duelista duelista2 = new Duelista("Jhenne", 325253, deck1, extradeck1);
		Duelista duelista3 = new Duelista("Thiago", 845, deck1, extradeck1);
		try {
			// Adicionando cartas no repositorio
			fachada.registrarCarta(a);
			fachada.registrarCarta(b);
			fachada.registrarCarta(c);
			fachada.registrarCarta(d);
			fachada.registrarCarta(e);
			fachada.registrarCarta(f);
			fachada.registrarCarta(g);
			fachada.registrarCarta(h);
			fachada.registrarCarta(i);
			fachada.registrarCarta(j);// Comenta uma dessas cartas para verificar o cadastro de um deck com carta nao
										// cadastrada no repositorio

			// Adicionando um deck
			fachada.registrarDeck(deck1);// Para testar se podemos cadastrar um duelista com um deck não cadastrado, só comentar essa linha
			//fachada.registrarDeck(deck1);
			
			// Adicionando um extra-deck para teste
			fachada.registrarExtraDeck(extradeck1); // Para testar se podemos cadastrar um duelista com um extradeck não cadastrado, só comentar essa linha
			//fachada.registrarExtraDeck(extradeck1); // Testar cadastrar extradeck com mesmo ID
			
			// Adicionando um duelista
			fachada.registrarDuelista(duelista);
			//fachada.registrarDuelista(duelista); // Testar cadastrar duelista com mesmo ID
			fachada.registrarDuelista(duelista2);

			// Removendo objetos por ID
			
			// fachada.apagarDeck(1);
			// fachada.apagarCarta(773);
			// fachada.apagarExtraDeck(34);
			// fachada.apagarDuelista(325253);

			// Retornando objetos pelo ID
			
			// fachada.buscarDeck(1);
			// fachada.buscarCarta(773);
			// fachada.buscarDuelista(325253);
			// fachada.buscarExtraDeck(34);

			/*
			 * Atualizando um objeto; Esses métodos não precisam verificar se o objeto que
			 * vai substituir o anterior já está cadastrado, apenas verificar o objeto a ser
			 * substituido
			 */

			// fachada.retificarCarta(212, a);
			// fachada.retificarDuelista(1, duelista2);// Lançará exceção se o ID do duelista2 já estiver cadastrado no repositorio
			// fachada.retificarDuelista(325253, duelista3);
			// fachada.retificarExtraDeck(34, extradeck2);
			// fachada.retificarDeck(1, deck3);

			
			/* 
			 * Para testar se algum objeto existe ou não é só alterar o ID a ser procurado
			 * Obs: Como o método contem verifica a presença de um objeto através do retorno de um boolean,
			 * ela não gera exceção, por exemplo, se ele não encontrar o ID ele vai retornar false.
			 */
			
			/* 
			 * Obs2:
			 * Método "contemDeck" verifica se o "Deck" está presente no repositorio, como o
			 * DECK de ID-34 não existe, ele vai retornar false. Lembrando que o EXTRADECK
			 * possui ID-34 separado dos ID's de DECK, ou seja, pode haver um EXTRADECK com
			 * ID-34 e um DECK com ID-34
			 */
			
			//fachada.contemCarta(34);
			//fachada.contemDeck(34);
			//fachada.contemDuelista(34);
			//fachada.contemExtraDeck(34);

			System.out.println("teste");
		} catch (IdJaCadastradoException | ArrayCheioException | NaoEncontradoException | DeckNaoCadastradoException
				| ExtraDeckNaoCadastradoException | CartaNaoCadastradaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}