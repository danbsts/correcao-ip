package fachada;

import ingredientes.*;
import pratos.*;
import mesas.*;
import pedidos.*;
import funcionarios.*;

public class App {

	private CadastroIngredientes ingredientes;
	private CadastroPratos pratos;
	private CadastroMesa mesas;
	private CadastroPedidos pedidos;
	private CadastroFuncionarios funcionarios;

	public App(RepositorioIngredientes repIngredientes, RepositorioPratos repPratos, RepositorioMesa repMesas,
			RepositorioPedidos repPedidos, RepositorioFuncionarios repFuncionarios) {

		this.ingredientes = new CadastroIngredientes(repIngredientes);
		this.pratos = new CadastroPratos(repPratos);
		this.mesas = new CadastroMesa(repMesas);
		this.pedidos = new CadastroPedidos(repPedidos);
		this.funcionarios = new CadastroFuncionarios(repFuncionarios);

	}

	// Pratos

	// cadastra um prato checando a disponibilidade de ingredientes, e se o mesmo ja
	// foi cadastrado
	public void cadastrarPrato(Prato prato) throws PratoJaCadastradoException, IngredientesInsuficientesException {
		Ingrediente[] arrayIngredientes = prato.getIngredientes();
		boolean estoqueDisponivel = true;

		for (int i = 0; i < arrayIngredientes.length && arrayIngredientes[i] != null; i++) {
			if (!this.ingredientes.existe(arrayIngredientes[i])) {
				estoqueDisponivel = false;
			}
		}
		if (estoqueDisponivel) {
			if (this.pratos.getPratos().existePrato(prato.getNome())) {
				throw new PratoJaCadastradoException();
			} else {
				this.pratos.cadastrar(prato);
			}
		} else {
			throw new IngredientesInsuficientesException();
		}
	}

	// remove um prato
	public void removerPrato(Prato prato) throws PratoNaoCadastradoException {
		if (this.pratos.getPratos().existePrato(prato.getNome())) {
			this.pratos.remover(prato);
		} else {
			throw new PratoNaoCadastradoException();
		}
	}

	// atualiza os dados de um prato
	public void atualizarPrato(Prato prato) throws PratoNaoCadastradoException {
		if (this.pratos.getPratos().existePrato(prato.getNome())) {
			this.pratos.atualizar(prato.getIdentificador(), prato.getNome(), prato.getPreco(), prato.getIngredientes());
		} else {
			throw new PratoNaoCadastradoException();
		}
	}
	public Prato procurarPrato(String nomePrato) throws PratoNaoCadastradoException {
		if (this.pratos.getPratos().existePrato(nomePrato)) {
			return this.pratos.procurar(nomePrato);
		} else {
			throw new PratoNaoCadastradoException();
		}
	}

	// ingredientes

	// cadastra um ingrediente no estoque
	public void cadastrarIngrediente(Ingrediente ingrediente) throws IngredienteJaCadastradoException {
		if (this.ingredientes.getIngredientes().existe(ingrediente.getIdentificador())) {
			throw new IngredienteJaCadastradoException();
		} else {
			this.ingredientes.inserir(ingrediente);
		}
	}

	// remove um ingrediente do estoque
	public void removerIngrediente(String identificador) throws IngredienteNaoCadastradoException {
		if (this.ingredientes.getIngredientes().existe(identificador)) {
			this.ingredientes.remover(identificador);
		} else {
			throw new IngredienteNaoCadastradoException();
		}
	}

	// atualiza um ingrediente do estoque
	public void atualizarIngrediente(Ingrediente ingrediente) throws IngredienteNaoCadastradoException {
		if (this.ingredientes.getIngredientes().existe(ingrediente.getIdentificador())) {
			this.ingredientes.atualizar(ingrediente);
		} else {
			throw new IngredienteNaoCadastradoException();
		}
	}
  
	// retorna o ingrediente quando solicitado um identificador
	public Ingrediente procurarIngrediente(String identificador) throws IngredienteNaoCadastradoException {
		return this.ingredientes.procurar(identificador);
	}

	// mesas

	// cadastra uma mesa checando se o funcionario responsavel existe
	public void cadastrarMesa(Mesa mesa) throws MesaJaCadastradaException, FuncionarioNaoExistenteException {
		Funcionario funcionario = mesa.getFuncionario();
		boolean funcionarioExiste = true;

		if (!this.funcionarios.getFuncionarios().existeFuncionario(funcionario)) {
			funcionarioExiste = false;
		}

		if (funcionarioExiste) {
			if (this.mesas.getMesas().existe(mesa)) {
				throw new MesaJaCadastradaException();
			} else {
				this.mesas.cadastrar(mesa);
			}
		} else {
			throw new FuncionarioNaoExistenteException();
		}
	}

	// remove uma mesa
	public void removerMesa(Mesa mesa) throws MesaNaoCadastradaException {
		if (this.mesas.getMesas().existe(mesa)) {
			this.mesas.remover(mesa);
		} else {
			throw new MesaNaoCadastradaException();
		}
	}

	// atualiza uma mesa
	public void atualizarMesa(Mesa mesa, int novoNum, Funcionario novoFuncionario) throws MesaNaoCadastradaException {
		if (this.mesas.getMesas().existe(mesa)) {
			this.mesas.atualizar(mesa, novoNum, novoFuncionario, mesa.getPedidos());
		} else {
			throw new MesaNaoCadastradaException();
		}
	}

	// calcula o valor dos pedidos feitos pela mesa e retorna com a taxa de 10%, em
	// seguida, redefine o repositorio da mesa
	public String pedirConta(Mesa mesa) throws MesaNaoCadastradaException {
		if (this.mesas.getMesas().existe(mesa)) {
			double consumo = (mesa.getPedidos().consumoMesa()) * (0.1);
			// cria um novo repositorio para mesa

			if (mesa.getPedidos() instanceof RepositorioPedidosArray) {
				RepositorioPedidosArray novoRep = new RepositorioPedidosArray();
				mesa.setRepPedidos(novoRep);
			} else if (mesa.getPedidos() instanceof RepositorioPedidosLista) {
				RepositorioPedidosLista novoRep = new RepositorioPedidosLista();
				mesa.setRepPedidos(novoRep);
			}

			return "Seu consumo foi de: R$ " + consumo + ". (A taxa de 10% opcional esta inclusa).";
		} else {
			throw new MesaNaoCadastradaException();
		}
	}
	
	//procurar mesa 
	public Mesa procurarMesa(int identificadorMesa) throws MesaNaoCadastradaException {
		if(mesas.existe(identificadorMesa)) {
			return this.mesas.procurarMesa(identificadorMesa);
		} else {
			throw new MesaNaoCadastradaException();
		}
	}

	// pedidos

	// Realiza um pedido checando se possui estoque de ingredientes
	public void fazerPedido(Pedidos pedido, Mesa mesa) throws PedidoJaCadastradoException, IngredientesInsuficientesException {
		Ingrediente[] ingredientes = pedido.getPrato().getIngredientes();
		boolean ingredientesDisponiveis = true;

		for (int i = 0; i < ingredientes.length; i++) {
			if (!this.ingredientes.existe(ingredientes[i])) {
				ingredientesDisponiveis = false;
			}
		}

		if (ingredientesDisponiveis) {
			if (mesa.getPedidos().existe(pedido)) {
				throw new PedidoJaCadastradoException();
			} else {
				// pedido cadastrado no repositorio da mesa
				mesa.getPedidos().inserir(pedido);
			}
		} else {
			throw new IngredientesInsuficientesException();
		}

	}
	 //cancela um pedido
	public void cancelarPedido(Pedidos pedido, Mesa mesa) throws PedidoNaoCadastradoException {
		if (mesa.getPedidos().existe(pedido)) {
			// pedido removido no repositorio da mesa
			mesa.getPedidos().remover(pedido);
		} else {
			throw new PedidoNaoCadastradoException();
		}
	}
	//altera um pedido
	public void atualizarPedido(Pedidos pedido, Mesa mesa) throws PedidoNaoCadastradoException {
		if (mesa.getPedidos().existe(pedido)) {
			// pedido atualizado no repositorio da mesa
			mesa.getPedidos().atualizar(pedido);
		} else {
			throw new PedidoNaoCadastradoException();
		}
	}
    //procura um pedido
	public Pedidos procurarPedido(String identificadorPedido) throws PedidoNaoCadastradoException {
		if(pedidos.existePedido(identificadorPedido)) {
			return this.pedidos.procurar(identificadorPedido);
		} else {
			throw new PedidoNaoCadastradoException();
		}
	}
	// funcionarios
	
	//cadastra um funcionario
	public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaCadastradoException {
		if (this.funcionarios.getFuncionarios().existeFuncionario(funcionario)) {
			throw new FuncionarioJaCadastradoException();
		} else {
			this.funcionarios.cadastrar(funcionario);
		}

	}
	//remove um funcionario
	public void removerFuncionario(Funcionario funcionario) throws FuncionarioNaoExistenteException {
		if (this.funcionarios.getFuncionarios().existeFuncionario(funcionario)) {
			this.funcionarios.remover(funcionario);
		} else {
			throw new FuncionarioNaoExistenteException();
		}

	}
	
	//atualiza um funcionario
	public void atualizarFuncionario(Funcionario funcionario) throws FuncionarioNaoExistenteException {
		if (this.funcionarios.getFuncionarios().existeFuncionario(funcionario)) {
			this.funcionarios.atualizar(funcionario);
		} else {
			throw new FuncionarioNaoExistenteException();
		}

	}
	

	//procura um funcionario
	public Funcionario procurarFuncionario(String login, String senha) throws FuncionarioNaoExistenteException {
		Funcionario achado = this.funcionarios.getFuncionarios().procurarFuncionario(login, senha);
		if (achado != null) {
			return achado;
		} else {
			throw new FuncionarioNaoExistenteException();
		}
	}
	
	//lista os funcionarios
	public String listarFuncionarios() throws NaoHaFuncionariosException {
		if(this.funcionarios.listar().equals("")) {
			throw new NaoHaFuncionariosException();
		}else {
			return this.funcionarios.listar();
		}
	}

}
