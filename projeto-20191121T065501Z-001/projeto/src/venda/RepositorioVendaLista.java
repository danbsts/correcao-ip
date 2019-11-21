package venda;

public class RepositorioVendaLista implements RepositorioVenda {
private Venda venda;
private RepositorioVendaLista prox;

	public RepositorioVendaLista() {
		this.venda=null;
		this.prox=null;
	}


	public void inserir(Venda venda)  {



				if (this.venda==null) {
					this.venda=venda;
					this.prox=new RepositorioVendaLista();
				}else {
					this.prox.inserir(venda);
				}




	}


	public boolean existe(Venda venda) {
		boolean aux=false;
		if (venda!=null) {
			if (this.venda!=null) {
			if (this.prox==null) {
				//aux continua falso
			}
				else if (this.venda.equals(venda)) {
					aux=true;

				}else {
					aux= prox.existe(venda);
				}
			}

		}/*else {
			//vai dar excecao porem o da venda ser null vai estar na camada de negocios
		}*/


		return aux;


	}


	public Venda buscar(int id) throws BuscaIdException{

		Venda aux=null;
		if (prox==null) {

			BuscaIdException e=new BuscaIdException(id);
			throw e;
		}
		else if (venda.getId()==id) {
			aux= venda ;
		}else {
			aux= prox.buscar(id);
		}



		return aux;
	}



	public void atualizar(Venda vendaAntiga, Venda vendaAtualizada)throws VendaNaoEncontradaException {


			if (venda!=null) {
			if (this.prox==null) {
				VendaNaoEncontradaException e= new VendaNaoEncontradaException(vendaAntiga);
				throw e;
			}
				else if (this.venda.equals(vendaAntiga)) {

					this.venda=vendaAtualizada;
				}
				else {
					prox.existe(venda);
				}
			}

		else {
			//vai dar excecao porem o da venda ser null vai estar na camada de negocios

		}


	}


	@Override
	public void remover(Venda venda) throws VendaNaoEncontradaException {
	if (this.prox==null) {
		VendaNaoEncontradaException e = new VendaNaoEncontradaException(venda);
		throw e;
	}
		else if (this.venda.equals(venda)) {
			this.venda=this.prox.venda;
			this.prox=this.prox.prox;
		}else {
			prox.remover(venda);
		}

	}

}