package venda;
public interface RepositorioVendas {
       public void remover (String id)
               throws VendaNaoEncontradaException;
       public void inserir (Vendas venda) 
    		   throws LimiteAtingidoException, VendaJaCadastradaException;
       public Vendas procurar (String id)
    		   throws VendaNaoEncontradaException;
       public boolean existe (String id);
       public void atualizar (Vendas venda)
               throws VendaNaoEncontradaException;
}
