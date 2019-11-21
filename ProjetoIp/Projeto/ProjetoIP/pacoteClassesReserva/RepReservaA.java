package pacoteClassesReserva;

import pacoteExcecoes.RNCException;

public class RepReservaA implements RepositorioReserva {

	private Reserva[] reserva;
	private int indice;

	public RepReservaA() {
		reserva = new Reserva[100];
		indice = 0;
	}

	@Override
	public void inserir(Reserva reserva) {
		this.reserva[this.indice] = reserva;
		this.indice++;
	}

	@Override
	public boolean existe(Reserva reserva) {
		boolean resposta = false;
		for (int a = 0; a < indice && !resposta; a++) {
			if (this.reserva[a].igual(reserva)) {
				resposta = true;
			}
		}
		return resposta;
	}

	public boolean existeCompleto(int codigo) {
		boolean resposta = false;
		for (int a = 0; a < indice && !resposta; a++) {
			if (this.reserva[a].getCodigo() == codigo) {
				resposta = true;
			}
		}
		return resposta;
	}

	@Override
	public void remover(int codigo) throws RNCException {
		if (this.existeCompleto(codigo)) {
			int proc = this.indice(codigo);
			for (int i = proc; i <= indice - 1; i++) {
				this.reserva[i] = this.reserva[i + 1];
			}
			this.indice--;
		} else {
			throw new RNCException();
		}
	}

	public int indice(int codigo) throws RNCException {
		for (int i = 0; i < 100; i++) {
			if (this.reserva[i] != null && this.reserva[i].getCodigo() == codigo) {
				return i;
			}

		}
		throw new RNCException();
	}

	@Override
	public void atualizar(int codigo, Reserva alterada) throws RNCException {
		int proc = this.indice(codigo);
		this.reserva[proc] = alterada;

	}

	@Override
	public String procurarReserva(int codigo) throws RNCException {
		String info = "";

		int proc = this.indice(codigo);
		info = "horario: "+this.reserva[proc].getHora() +":00"+ "    data: " + this.reserva[proc].getDia() + "/" + this.reserva[proc].getMes()
				+ "/" + this.reserva[proc].getAno();

		return info; 
	}

	@Override
	public boolean existe(int codigo) {
		boolean resposta = false;
		for (int a = 0; a < indice && !resposta; a++) {
			if (this.reserva[a].getCodigo()==codigo) {
				resposta = true;
			}
		}
		return resposta;
	}

}
