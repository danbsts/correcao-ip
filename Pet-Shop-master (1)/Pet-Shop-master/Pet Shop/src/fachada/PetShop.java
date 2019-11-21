package fachada;
import clientes.CadastroClientes;
import clientes.ClienteJaCadastradoException;
import clientes.ClienteNaoEncontradoException;
import clientes.Clientes;
import clientes.LimiteClientesAtingidoException;
import clientes.RepositorioClientes;
import funcionarios.CadastroFuncionarios;
import funcionarios.FuncionarioJaCadastradoException;
import funcionarios.FuncionarioNaoEncontradoException;
import funcionarios.LimiteFuncionariosAtingidoException;
import funcionarios.Funcionarios;
import funcionarios.RepositorioFuncionarios;
import produtos.CadastroProdutos;
import produtos.LimiteProdutosAtingidoException;
import produtos.ProdutoJaCadastradoException;
import produtos.ProdutoNaoEncontradoException;
import produtos.Produtos;
import produtos.RepositorioProduto;
import servicos.CadastroServicos;
import servicos.LimiteServicoAtingidoException;
import servicos.RepositorioServicos;
import servicos.ServicoJaCadastradoException;
import servicos.ServicoNaoEncontradoException;
import servicos.Servicos;
import venda.AlgoNaoFoiEncontradoException;
import venda.CadastroVenda;
import venda.RepositorioVendas;
import venda.VendaJaCadastradaException;
import venda.VendaNaoEncontradaException;
import venda.Vendas;

public class PetShop {
	
   private CadastroClientes clientes;
   private CadastroFuncionarios funcionarios;
   private CadastroProdutos produtos;
   private CadastroServicos servicos;
   private CadastroVenda vendas;
   
   public PetShop (RepositorioClientes repoClientes, 
		   RepositorioFuncionarios repoFuncionarios, RepositorioProduto repoProdutos,
		   RepositorioServicos repoServicos, RepositorioVendas repoVendas) {
	   this.clientes = new CadastroClientes (repoClientes);
	   this.funcionarios = new CadastroFuncionarios (repoFuncionarios);
	   this.produtos = new CadastroProdutos (repoProdutos);
	   this.servicos = new CadastroServicos (repoServicos);
	   this.vendas = new CadastroVenda (repoVendas);
   }
   
   public void cadastrarCliente (Clientes cliente)
           throws ClienteJaCadastradoException, LimiteClientesAtingidoException {
       if (this.clientes.existe(cliente.getCpf())) {
           ClienteJaCadastradoException c = new ClienteJaCadastradoException();
           throw c;
       } else {
           clientes.cadastrar(cliente);
       }
   }

   public void removerCliente(String cpf)
           throws ClienteNaoEncontradoException {
       this.clientes.remover(cpf);
   }

   public void atualizarCliente(Clientes cliente)
           throws ClienteNaoEncontradoException {
       if (this.clientes.existe(cliente.getCpf())) {
           this.clientes.atualizar(cliente);
       } else {
           ClienteNaoEncontradoException c = new ClienteNaoEncontradoException();
           throw c;
       }

   }

   public Clientes procurarCliente(String cpf)
           throws ClienteNaoEncontradoException {
       return this.clientes.procurar(cpf);
   }
   
   public boolean existeCliente (String cpf) 
		   throws ClienteNaoEncontradoException {
       return this.clientes.existe(cpf);
   }

   public void cadastrarProdutos(Produtos produto) throws LimiteProdutosAtingidoException, ProdutoJaCadastradoException, ProdutoNaoEncontradoException {
       if (this.produtos.existe(produto.getCode())) {
           ProdutoJaCadastradoException p = new ProdutoJaCadastradoException();
           throw p;
       } else {
           produtos.cadastrar(produto);
       }
   }

   public void removerProduto (String codeProduto) throws ProdutoNaoEncontradoException {
       this.produtos.remover(codeProduto);
   }

   public void atualizarProduto (Produtos produto) throws ProdutoNaoEncontradoException {
       if (this.produtos.existe(produto.getCode())) {
           this.produtos.atualizarProduto(produto);
       } else {
           ProdutoNaoEncontradoException p = new ProdutoNaoEncontradoException();
           throw p;
       }

   }

   public Produtos procurarProduto (String codeProduto) throws ProdutoNaoEncontradoException {
       return this.produtos.procurar(codeProduto);
   }

   public boolean existeProduto (String codeProduto) throws ProdutoNaoEncontradoException {
       return this.produtos.existe(codeProduto);
   }

   public void cadastrarFuncionario (Funcionarios funcionario)
           throws LimiteFuncionariosAtingidoException, FuncionarioJaCadastradoException {
       if (this.funcionarios.existe(funcionario.getCodigo())) {
           FuncionarioJaCadastradoException f = new FuncionarioJaCadastradoException();
           throw f;
       } else {
           funcionarios.cadastrar(funcionario);
       }
   }

   public void removerFuncionario (String codigo) throws FuncionarioNaoEncontradoException {
       this.funcionarios.remover(codigo);
   }

   public void atualizarFuncionario (Funcionarios funcionario)
           throws FuncionarioNaoEncontradoException {
       if (this.funcionarios.existe(funcionario.getCodigo())) {
           this.funcionarios.atualizar(funcionario);
       } else {
           FuncionarioNaoEncontradoException f = new FuncionarioNaoEncontradoException();
           throw f;
       }
   }

   public Funcionarios procurarFuncionario (String codigo)
           throws FuncionarioNaoEncontradoException {
       return this.funcionarios.procurar(codigo);
   }
   
   public boolean existeFuncionario (String codigo) throws FuncionarioNaoEncontradoException {
       return this.funcionarios.existe(codigo);
   }


   public void cadastrarServico (Servicos servico) 
		   throws ServicoJaCadastradoException, LimiteServicoAtingidoException {
       if (this.servicos.existe(servico.getCodigo())) {
           ServicoJaCadastradoException s = new ServicoJaCadastradoException();
           throw s;
       } else {
           servicos.cadastrar(servico);
       }
   }

   public void removerServico (String codigo) 
		   throws ServicoNaoEncontradoException {
       this.servicos.remover(codigo);
   }

   public Servicos procurarServico (String codigo) 
		   throws ServicoNaoEncontradoException {
       return this.servicos.procurar(codigo);
   }

   public void atualizarServico (Servicos servico) 
		   throws ServicoNaoEncontradoException {
       if (this.servicos.existe(servico.getCodigo())) {
           this.servicos.atualizar(servico);
       } else {
           ServicoNaoEncontradoException s = new ServicoNaoEncontradoException();
           throw s;
       }
   }
   
   public boolean existeServico (String codigo) 
		   throws ServicoNaoEncontradoException {
       return this.servicos.existe(codigo);
   }
   
   public void cadastrarVenda (Vendas venda) 
		   throws VendaJaCadastradaException, 
		   venda.LimiteAtingidoException, 
		   ClienteNaoEncontradoException, 
		   FuncionarioNaoEncontradoException, 
		   ProdutoNaoEncontradoException, 
		   ServicoNaoEncontradoException, 
		   AlgoNaoFoiEncontradoException {
	   if(existeCliente(venda.getCliente().getCpf()) && existeFuncionario(venda.getFuncionario().getCodigo()) 
			   && existeProduto(venda.getProduto().getCode()) && existeServico(venda.getServico().getCodigo())) {
       if (this.vendas.existe(venda.getId())) {
           VendaJaCadastradaException v = new VendaJaCadastradaException();
           throw v;
       } else {
           vendas.cadastrar(venda);
       }
   } else {
	    AlgoNaoFoiEncontradoException a;
		a = new AlgoNaoFoiEncontradoException();
		throw a;
   }
   }

   public void removerVenda (String id) 
		   throws VendaNaoEncontradaException {
       this.vendas.remover(id);
   }

   public Vendas procurarVenda (String id) 
		   throws VendaNaoEncontradaException {
       return this.vendas.procurar(id);
   }

   public void atualizarVenda (Vendas venda) 
		   throws VendaNaoEncontradaException {
       if (this.vendas.existe(venda.getId())) {
           this.vendas.atualizar(venda);
       } else {
           VendaNaoEncontradaException v = new VendaNaoEncontradaException();
           throw v;
       }
   }
   
   public boolean existeVenda (String id) 
		   throws VendaNaoEncontradaException {
       return this.vendas.existe(id);
   }
}
