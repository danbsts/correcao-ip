package pacoteClassesReserva;


import pacoteExcecoes.RNCException;

public class RepReservaL implements RepositorioReserva {

	private Reserva reserva;
	private RepReservaL proximo;

	public RepReservaL() {
		this.reserva = null;
		this.proximo = null;
	}

	@Override
	public void inserir(Reserva reserva)  { 
		if (this.proximo == null) {
				this.reserva = reserva;
				this.proximo = new RepReservaL();
			
		} else if(this.proximo!=null) {
			this.proximo.inserir(reserva);
		}
	}

	@Override
	public boolean existe(Reserva reserva) {//ok
		if (this.reserva != null) {
			if (this.reserva.igual(reserva)) {
				return true;
			} else
				return this.proximo.existe(reserva);
		} else {
			return false;
		}
	}

	@Override
	public void remover(int codigo) throws RNCException {
		if (this.reserva != null) {
			if (this.reserva.getCodigo()==codigo) {
				this.reserva = this.proximo.reserva;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(codigo);
			}
		} else {
			throw new RNCException();
		}

	}

	@Override
	public void atualizar(int codigo, Reserva alterada) throws RNCException {
		if (this.reserva != null) {
			if (this.reserva.getCodigo()==codigo) {
				this.reserva = alterada;
			} else {
				this.proximo.atualizar(codigo, alterada);
			}
		} else {
			throw new RNCException();
		}
	}

	
	public String procurarReserva(int codigo) throws RNCException {
		String info = "";
		if (this.reserva != null) {
			if (this.reserva.getCodigo()==codigo) {
				info = "horário: "+this.reserva.getHora() +":00" + "     data: " + this.reserva.getDia() + "/" + this.reserva.getMes() + "/" + this.reserva.getAno();
				return info;
			} else if(this.proximo!=null){
				return this.proximo.procurarReserva(codigo);
			}
		} else {
			throw new RNCException();
		}
		return info; 
	}
	
	
	
	

	@Override
	public boolean existe(int codigo) {
		if (this.reserva != null) {
			if (this.reserva.getCodigo()==codigo) {
				return true;
			} else
				return this.proximo.existe(codigo);
		} else {
			return false;
		}
	}
	

}
