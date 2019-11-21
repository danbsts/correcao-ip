package pacoteClassesReserva;

import pacoteExcecoes.NOException;
import pacoteExcecoes.HIException;
import pacoteExcecoes.RNCException;

public class NegocioReserva {
	
	private RepositorioReserva reservas;
	
	public NegocioReserva(int a) throws NOException {
		if (a == 1) {
			reservas = new RepReservaL();
		} else if (a == 2) {
			reservas = new RepReservaA();
		} else {
			throw new NOException();
		}
	}
	
	public void cadastrar(Reserva reserva) throws HIException {//okok
		if(this.reservas.existe(reserva) || !reserva.horaOk()) throw new HIException();
		this.reservas.inserir(reserva);
	}

	public boolean existe(int i) {//okok
		return this.reservas.existe(i);
	}
	
	public boolean existe(Reserva reserva) {//okok
		return this.reservas.existe(reserva);
	}

	public void atualizar(int codigo, Reserva alterada) throws RNCException, HIException{//okok
		if(!this.reservas.existe(codigo)) throw new RNCException();
		if(!alterada.horaOk()) throw new HIException();
		this.reservas.atualizar(codigo, alterada);
	}

	public void deletar(int codigo) throws RNCException{//okok
		this.reservas.remover(codigo);
	}
	
	public String procurarReserva(int codigo) throws RNCException{//pkok
		if(!this.reservas.existe(codigo)) throw new RNCException();
		return this.reservas.procurarReserva(codigo);
	}

}

