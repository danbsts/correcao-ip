package mesas;

import funcionarios.Funcionario;
import pedidos.PedidoNaoCadastradoException;
import pedidos.Pedidos;
import pedidos.RepositorioPedidos;

public class RepositorioMesaArray implements RepositorioMesa{
    private Mesa[] arrayMesa;
    private int count;

    public RepositorioMesaArray() {
        this.arrayMesa = new Mesa[100];
        this.count = 0;
    }

    public void inserirMesa(Mesa mesa) {
        arrayMesa[count] = mesa;
        count++;
    }

    public void removerMesa(Mesa mesa) {
        for (int i = 0; i < count; i++) {
            if (arrayMesa[i].getNum() == mesa.getNum()) {
                for (int n = i + 1; n < count; n++) {
                    arrayMesa[n - 1] = arrayMesa[n];
                }
            }
        }
        count--;

    }

    

    public boolean existe(Mesa mesa) {
        boolean existe = false;
        for (int i = 0; i < count; i++) {
            if (arrayMesa[i].getNum()== mesa.getNum()) {
                existe = true;
            }
        }
        return existe;
    }

    public void atualizarMesa(Mesa mesa, int numeroMesa, Funcionario funcionario, RepositorioPedidos pedidos ) {
        for (int i = 0; i < count; i++) {
            if (arrayMesa[i].getNum() == mesa.getNum()) {
                arrayMesa[i].setNumero(numeroMesa);
                arrayMesa[i].setFuncionario(funcionario);
                arrayMesa[i].setRepPedidos(pedidos);
            }
        }

    }


    public int quantidadeMesas(Funcionario funcionario){
	int quantidade=0;	
	for (int i =0; i<count;i++){
	    if (arrayMesa[i].getFuncionario().getRg()== funcionario.getRg()){
	    quantidade++;

	    }

	
	}
	return quantidade;


    
    }
    
    
    public Mesa procurarMesa(int identificadorMesa) {
		Mesa resposta = null;
    	for (int i = 0; i < 100 && this.arrayMesa[i] != null; i++) {
			if (this.arrayMesa[i].getNum() == (identificadorMesa)) {
				return this.arrayMesa[i];
			}
			
		}
    	return resposta;
	}
    
    public boolean existeMesa(int identificadorMesa) {
		boolean retorno = false;
		for (int i = 0; i < count; i++) {
			if (arrayMesa[i].getNum()==(identificadorMesa)) {
				retorno = true;
			}
		}
		return retorno;
	}


}
