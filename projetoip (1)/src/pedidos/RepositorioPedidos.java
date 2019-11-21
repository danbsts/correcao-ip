 package pedidos;
public interface RepositorioPedidos {
//Definir os metodos que os repositorios tem (cadastrar, remover, atualizar e procurar).
	// olhar exceptions que tao dando um que nao tem nada haver tipo o procurar kk OU SEJA CRIAR + EXCEPTION

public void remover(String codigo) throws PedidoNaoEncontradoException;
public void atualizar(Pedidos classe) throws PedidoNaoEncontradoException,ValorInvalidoException;
public boolean existe(String codigo);
public Pedidos  procurar(String codigo) throws PedidoNaoEncontradoException;
public void inserir(Pedidos pedidos)throws ValorInvalidoException;
}
