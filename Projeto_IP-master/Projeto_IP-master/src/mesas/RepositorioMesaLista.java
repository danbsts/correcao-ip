package mesas;

import funcionarios.Funcionario;
import pedidos.RepositorioPedidos;
import pratos.Prato;

public class RepositorioMesaLista implements RepositorioMesa {
    private Mesa mesa;
    private RepositorioMesaLista proximo;

    public RepositorioMesaLista(){
        this.mesa=null;
        this.proximo=null;
    }
    public void inserirMesa(Mesa mesa){
        if (this.mesa==null){
            this.mesa= mesa;
            this.proximo= new RepositorioMesaLista();
        }else{
            this.proximo.inserirMesa(mesa);
        }
    }

    public void removerMesa(Mesa mesa){
        if (this.mesa.getNum()== mesa.getNum()){
            this.mesa=this.proximo.mesa;
            this.proximo=this.proximo.proximo;
        }else{
            this.proximo.removerMesa(mesa);
        }
    }
    
    public boolean existe(Mesa mesa){
        if (this.mesa==null){
            return false;
        }else if (this.mesa.getNum()== mesa.getNum()){
            return true;
        }else{
            return this.proximo.existe(mesa);
        }

    }

    public void atualizarMesa(Mesa mesa, int numeroMesa, Funcionario funcionario, RepositorioPedidos pedidos ){
        if (this.mesa.getNum()== mesa.getNum()){
            this.mesa.setNumero(numeroMesa);
            this.mesa.setFuncionario(funcionario);
            this.mesa.setRepPedidos(pedidos);
        }else {
            this.proximo.atualizarMesa(mesa,numeroMesa, funcionario, pedidos);

        }
    }

    public int quantidadeMesas(Funcionario funcionario){
	if (this.mesa != null && this.mesa.getFuncionario().getRg()== funcionario.getRg()){
	     if (this.proximo!=null){
		return 1 + this.proximo.quantidadeMesas(funcionario);
	     }else{
		return 1;
	     }
	}else if (this.proximo != null){
		return 0+ this.proximo.quantidadeMesas(funcionario);
	
	}
	return 0;
    }
    
	public Mesa procurarMesa(int identificadorMesa){
		if (this.mesa.getNum()==(identificadorMesa)) {
			return this.mesa; 
		} else {
			return this.proximo.procurarMesa(identificadorMesa);
	}

    }
	public boolean existeMesa(int identificadorMesa) {
		if (this.mesa != null) {
			if (this.mesa.getNum()==(identificadorMesa)) {
				return true;
			} else {
				return this.proximo.existeMesa(identificadorMesa);
			}
		} else {
			return false;
		}
	}
	
	


}
