package ui;
import fachada.Fachada;
import pedidos.*;
import pessoas.*;
import produtos.Produto;
import produtos.RepositorioProdutos;
import produtos.RepositorioProdutosLista;
public class Programa {
//teste so pode usar a fachada
	public static void main(String[] args) throws ValorInvalidoException, PedidoNaoEncontradoException {
        Repositorio RepositorioClientes = new RepositorioPessoaArray(1);
        // Repositorio RepositorioClientes = new RepositorioLista();

        Repositorio RepositorioFuncionarios = new RepositorioPessoaLista();
        // Repositorio RepositorioFuncionarios = new RepositorioArray();

        //RepositorioPedidos repositorioPedidos = new RepositorioPedidosLista();
        RepositorioPedidos repositorioPedidos = new RepositorioPedidosArray(1);

        RepositorioProdutos repositorioProdutos = new RepositorioProdutosLista();
        //RepositorioProdutos repositorioProdutos = new RepositorioProdutosArray(1);

        Fachada fachada = new Fachada(RepositorioClientes, RepositorioFuncionarios,repositorioProdutos, repositorioPedidos);

        System.out.println("---TESTE DE VALOR INVALIDO---");
        //Deve cadastrar um produto de valor negativo ou zero e falhar.
        try {
            Produto produtoValorInvalido = new Produto("Galeto", "Nada", -1.00);
            fachada.cadastrarProdutos(produtoValorInvalido);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }//criar exception valor invalido!

        System.out.println("---TESTE DE CADASTRAR PRODUTO---");
        //Deve cadastrar um produto.
        try {
            Produto produtoTeste = new Produto("Tapiocao", "Queijo", 2.00);
            fachada.cadastrarProdutos(produtoTeste);
            System.out.println(produtoTeste.getNome() + " cadastrado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Tenta cadastrar um produto j� cadastrado anteriormente e falhar.
        try {
            Produto produtoTeste = new Produto("Tapiocao", "Queijo", 2.00);
            fachada.cadastrarProdutos(produtoTeste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---TESTE DE PROCURAR PRODUTO---");
        //Deve procurar um produto que existe.
        try {
            Produto produto = fachada.procurarProduto("Tapiocao");
            System.out.println(produto.getNome() + " encontrado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Tenta procurar um produto que n�o existe e falha.
        try {
            Produto produto = fachada.procurarProduto("Galeto");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---TESTE DE ATUALIZAR PRODUTO---");
        //Deve atualizar um pedidos j� cadastrado.
        try {
            Produto novoProduto = new Produto("Tapiocao", "Presunto", 2.50);
            fachada.atualizarProdutos(novoProduto);
            System.out.println(novoProduto.getNome() + " atualizado com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Tenta atualizar um produto que n�o existe e falha.
        try {
            Produto produtoInvalido = new Produto("Galeto", "Nada", 5.00);
            fachada.atualizarProdutos(produtoInvalido);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---TESTE DE EXISTE PRODUTO---");
        boolean produtoExiste;
        //Procura se um produto j� cadastrado existe.
        try {
            Produto produtoTeste = new Produto("Tapiocao", "Queijo", 2.00);
            produtoExiste = fachada.existeProduto(produtoTeste.getNome());
            System.out.println("O produto existe no sistema: " + produtoExiste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Procura se um produto n�o cadastrado existe.
        produtoExiste = fachada.existeProduto("Galeto");
        System.out.println("O produto existe no sistema: " + produtoExiste);

        System.out.println("---TESTE DE REMOVER PRODUTO---");
        //Deve remover um produto existe.
        try {
            Produto produtoTeste = new Produto("Tapiocao", "Queijo", 2.00);
            fachada.removerProduto(produtoTeste.getNome());
            System.out.println(produtoTeste.getNome() + " foi removido com sucesso.");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        //Tenta remover um produto que n�o existe e falha.
        try {
            fachada.removerProduto("Galeto");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // PEDIDOS


        String codigo1 = "001";
        String codigo2 = "002";
        String codigo3 = "003";

        //RepositorioProdutosLista produto = new RepositorioProdutosLista();
        String produto = "coca-cola";


        Cliente cliente1 = new Cliente("789.654.321-00", "Joao Pedro",  0);
        Garcom funcionario1 = new Garcom("321.654.987-00", "Tia", true, 500);

        Cliente cliente2 = new Cliente("789.654.321-10","Matheus Correia", 5);
        Garcom funcionario2 = new  Garcom("321.654.987-10", "Tio",  false, 2);

        try {
            fachada.cadastrarPessoas(cliente1);
            fachada.cadastrarPessoas(cliente2);
            fachada.cadastrarFuncionario(funcionario1);
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
        }
        System.out.println("\n" + "----- CADASTRAR DOIS PEDIDOS -----" + "\n");
        try {
            Pedidos pedido = new Pedidos(codigo1, produto, cliente1, funcionario1,1);
            fachada.cadastrarPedido(pedido);
            System.out.println("O pedido " + pedido.getCodigo() + " foi cadastrado." + "\n");
            Pedidos pedido2 = new Pedidos(codigo2, produto, cliente1, funcionario1,1);
            fachada.cadastrarPedido(pedido2);
            System.out.println("O pedido " + pedido2.getCodigo() + " foi cadastrado." + "\n");
        } catch (PedidoJaExistenteException pedidoJaExistente) {
            System.out.println(pedidoJaExistente.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- CADASTRAR UM PEDIDO JA EXISTENTE -----" + "\n");
        try {
            Pedidos pedido = new Pedidos(codigo1, produto, cliente1, funcionario1,1);
            fachada.cadastrarPedido(pedido);
            System.out.println("O pedido " + pedido.getCodigo() + " foi cadastrado." + "\n");
        } catch (PedidoJaExistenteException pedidoJaExistente) {
            System.out.println(pedidoJaExistente.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- CADASTRAR UM PEDIDO COM FUNCIONARIO NAO EXISTENTE -----" + "\n");
        try {
            Pedidos pedido = new Pedidos(codigo1, produto, cliente2, funcionario2,1);
            fachada.cadastrarPedido(pedido);
            System.out.println("O pedido " + pedido.getCodigo() + " foi cadastrado." + "\n");
        } catch (PedidoJaExistenteException pedidoJaExistente) {
            System.out.println(pedidoJaExistente.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- ATUALIZAR UM PEDIDO -----" + "\n");
        try {
            Pedidos pedido = new Pedidos(codigo1, produto, cliente1, funcionario1,1);
            Pedidos pedidoAtualizar = new Pedidos(codigo1, produto, cliente2, funcionario1,1);
            fachada.atualizarPedido(pedidoAtualizar);
            System.out.println("O pedido " + pedido.getCodigo() + " foi atualizado." + "\n");
        } catch (PedidoNaoEncontradoException pedidoNaoEncontrado) {
            System.out.println(pedidoNaoEncontrado.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- ATUALIZAR UM PEDIDO NAO EXISTENTE -----" + "\n");
        try {
            Pedidos pedido = new Pedidos(codigo3, produto, cliente1, funcionario1,1);
            fachada.atualizarPedido(pedido);
            System.out.println("O pedido " + pedido.getCodigo() + " foi atualizado." + "\n");
        } catch (PedidoNaoEncontradoException pedidoNaoEncontrado) {
            System.out.println(pedidoNaoEncontrado.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- ATUALIZAR UM PEDIDO COM UM FUNCIONARIO NAO EXISTENTE -----" + "\n");
        try {
            Pedidos pedido = new Pedidos(codigo1, produto, cliente2, funcionario2,1);
            fachada.atualizarPedido(pedido);
            System.out.println("O pedido " + pedido.getCodigo() + " foi atualizado." + "\n");
        } catch (PedidoNaoEncontradoException pedidoNaoEncontrado) {
            System.out.println(pedidoNaoEncontrado.getMessage() + "\n");
        } catch (PessoaNaoEncontradaException pessoaNaoEncontrada) {
            System.out.println(pessoaNaoEncontrada.getMessage() + "\n");
        }
        System.out.println("----- PROCURAR UM PEDIDO -----" + "\n");
        try {
            Pedidos pedido = new Pedidos(codigo1, produto, cliente1, funcionario1,1);
            fachada.procurarPedido(codigo1);
            System.out.println("O pedido " + pedido.getCodigo() + " foi encontrado." + "\n");
        } catch (PedidoNaoEncontradoException PedidoNaoEncontrado) {
            System.out.println(PedidoNaoEncontrado.getMessage() + "\n");
        }
        System.out.println("----- PROCURAR UM PEDIDO NAO EXISTENTE -----" + "\n");
        try {
            Pedidos pedido = new Pedidos(codigo3, produto, cliente1, funcionario1,1);
            fachada.procurarPedido(codigo3);
            System.out.println("O pedido " + pedido.getCodigo() + " foi encontrado." + "\n");
        } catch (PedidoNaoEncontradoException PedidoNaoEncontrado) {
            System.out.println(PedidoNaoEncontrado.getMessage() + "\n");
        }
        System.out.println("----- REMOVER UM PEDIDO -----" + "\n");
        try {
            Pedidos pedido = new Pedidos(codigo1, produto, cliente1, funcionario1,1);
            fachada.removerPedido(codigo1);
            System.out.println("O pedido " + pedido.getCodigo() + " foi removido." + "\n");
        } catch (PedidoNaoEncontradoException PedidoNaoEncontrado) {
            System.out.println(PedidoNaoEncontrado.getMessage() + "\n");
        }
        System.out.println("----- REMOVER UM PEDIDO NAO EXISTENTE -----" + "\n");
        try {
            Pedidos pedido = new Pedidos(codigo1, produto, cliente1, funcionario1,1);
            fachada.removerPedido(codigo1);
            System.out.println("O pedido " + pedido.getCodigo() + " foi removido." + "\n");
        } catch (PedidoNaoEncontradoException PedidoNaoEncontrado) {
            System.out.println(PedidoNaoEncontrado.getMessage() + "\n");
        }
        System.out.println("----- VER SE OS PEDIDOS EXISTEM -----" + "\n");
        boolean pedidoExiste = fachada.existePedido(codigo1);
        System.out.println("O pedido " + codigo1 + " existe: " + pedidoExiste);
        boolean pedido2Existe = fachada.existePedido(codigo2);
        System.out.println("O pedido " + codigo2 + " existe: " + pedido2Existe);
        boolean pedido3Existe = fachada.existePedido(codigo3);
        System.out.println("O pedido " + codigo3 + " existe: " + pedido3Existe + "\n");


        // CLIENTES
      

        String CPF_CLIENTE_TESTE = "220.042.050-49";
        Cliente clienteTeste = new Cliente(CPF_CLIENTE_TESTE,"Bananinho", 0);

        /* TESTES DE CADASTRAR CLIENTE */
        System.out.println("----- TESTES DE CADASTRAR CLIENTE -----");
        // Deve cadastrar um cliente no Cadastro de Clientes
        try {
            fachada.cadastrarPessoas(clienteTeste);
            System.out.println(clienteTeste.getNome() + " cadastrado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Deve tentar cadastrar o mesmo Cliente no Cadastro novamente e falhar
        try {
            fachada.cadastrarPessoas(clienteTeste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE PROCURAR CLIENTE */
        System.out.println("----- TESTES DE PROCURAR CLIENTE -----");
        // Busca um cliente que existe
        try {
            Pessoa cliente = fachada.procurarPessoas(CPF_CLIENTE_TESTE);
            System.out.println(cliente.getNome() + " encontrado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Busca um cliente que nao existe
        try {
            Pessoa cliente = fachada.procurarPessoas("123");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE ATUALIZAR CLIENTE */
        System.out.println("----- TESTES DE ATUALIZAR CLIENTE -----");
        // Atualiza um cliente que existe
        try {
            Cliente novoCliente = new Cliente(CPF_CLIENTE_TESTE,"Matheus", 0);
            fachada.atualizarPessoas(novoCliente);
            System.out.println(novoCliente.getNome() + " atualizado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Atualiza um cliente que nao existe
        try {
            Cliente novoClienteNaoExiste = new Cliente("123.456.789-10","Troll",0);
            fachada.atualizarPessoas(novoClienteNaoExiste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE EXISTE CLIENTE */
        System.out.println("----- TESTES DE EXISTE CLIENTE -----");
        // Busca um cliente que existe
        boolean clienteExiste = fachada.existePessoas(clienteTeste.getCpf());
        System.out.println("O cliente buscado existe: " + clienteExiste);

        // Busca um cliente que nao existe
        clienteExiste = fachada.existePessoas("0");
        System.out.println("O cliente buscado existe: " + clienteExiste);

        /* TESTES DE REMOVER CLIENTE */
        System.out.println("----- TESTES DE REMOVER CLIENTE -----");
        // Remove um cliente que existe
        try {
            fachada.removerPessoas(clienteTeste.getCpf());
            System.out.println(clienteTeste.getNome() + " removido com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Remove um cliente que nao existe
        try {
            fachada.removerPessoas("123.456.789-10");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // FUNCIONARIOS

        String CPF_FUNCIONARIO_TESTE = "470.002.050-49";
        Garcom FuncionarioTeste = new Garcom(CPF_FUNCIONARIO_TESTE,"Ronaldo Fenomeno", true, 800);

        /* TESTES DE CADASTRAR Funcionario */
        System.out.println("----- TESTES DE CADASTRAR Funcionario -----");
        // Deve cadastrar um Funcionario no Cadastro de Funcionarios
        try {
            fachada.cadastrarFuncionario(FuncionarioTeste);
            System.out.println(FuncionarioTeste.getNome() + " cadastrado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Deve tentar cadastrar o mesmo Funcionario no Cadastro novamente e falhar
        try {
            fachada.cadastrarFuncionario(FuncionarioTeste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE PROCURAR Funcionario */
        System.out.println("----- TESTES DE PROCURAR Funcionario -----");
        // Busca um Funcionario que existe
        try {
            Garcom Funcionario = fachada.procurarFuncionario(CPF_FUNCIONARIO_TESTE);
            System.out.println(Funcionario.getNome() + " encontrado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Busca um Funcionario que nao existe
        try {
            Garcom Funcionario = fachada.procurarFuncionario("123.456.789-10");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE ATUALIZAR Funcionario */
        System.out.println("----- TESTES DE ATUALIZAR Funcionario -----");
        // Atualiza um Funcionario que existe
        try {
            Garcom novoFuncionario = new Garcom(CPF_FUNCIONARIO_TESTE,"Matheus", false, 950);
            fachada.atualizarFuncionario(novoFuncionario);
            System.out.println(novoFuncionario.getNome() + " atualizado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Atualiza um Funcionario que nao existe
        try {
        	Garcom novoFuncionarioNaoExiste = new Garcom("265.987.984-15", "Troll", true, 123);
            fachada.atualizarFuncionario(novoFuncionarioNaoExiste);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /* TESTES DE EXISTE Funcionario */
        System.out.println("----- TESTES DE EXISTE Funcionario -----");
        // Busca um Funcionario que existe
        boolean FuncionarioExiste = fachada.existeFuncionario(FuncionarioTeste.getCpf());
        System.out.println("O Funcionario buscado existe: " + FuncionarioExiste);

        // Busca um Funcionario que nao existe
        FuncionarioExiste = fachada.existeFuncionario("0");
        System.out.println("O Funcionario buscado existe: " + FuncionarioExiste);

        /* TESTES DE REMOVER Funcionario */
        System.out.println("----- TESTES DE REMOVER Funcionario -----");
        // Remove um Funcionario que existe
        try {
            fachada.removerFuncionario(FuncionarioTeste.getCpf());
            System.out.println(FuncionarioTeste.getNome() + " removido com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Remove um Funcionario que nao existe
        try {
            fachada.removerFuncionario("123.987.654-59");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

       
    }

}
