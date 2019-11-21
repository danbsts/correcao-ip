package venda;
public class CadastroVenda {
	private RepositorioVendas repositorio;
       public CadastroVenda (RepositorioVendas repo) {
    	   this.repositorio = repo;
       }
       
       public void cadastrar (Vendas venda) 
    		   throws LimiteAtingidoException, VendaJaCadastradaException {
    	   //cadastrando qnd nao existe a venda com o respectivo id
    	   if (!this.repositorio.existe(venda.getId()))
    		   this.repositorio.inserir(venda);	   
    	   }
       
       public void atualizar (Vendas venda) 
    		   throws VendaNaoEncontradaException {
    	   this.repositorio.atualizar(venda);
       }
       
       public void remover (String id) 
    		   throws VendaNaoEncontradaException {
    	   this.repositorio.remover(id);
       }
       
       public Vendas procurar (String id) 
    		   throws VendaNaoEncontradaException {
		return this.repositorio.procurar(id);	   
       }
       
       public boolean existe (String id) {
		return this.repositorio.existe(id); 	   
       }
}
