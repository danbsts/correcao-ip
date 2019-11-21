package servicoDeEntrega;

import venda.Venda;

public class ServicoDeEntrega { 
	private int distancia;
	private String tipoDeEntrega;
	private Venda venda;
	private int identificador;

	public ServicoDeEntrega(int distancia, Venda venda, String tipoDeEntrega,int identificador) {
		this.distancia = distancia;
		this.tipoDeEntrega = tipoDeEntrega;
		this.venda = venda;
		this.identificador=identificador;
	}
	public int getDistancia() {
		return distancia;
	}

	public int getIdentificador() {
		return identificador;
	}

	public Venda getVenda() {
		return venda;
	}

	public String getTipoDeEntrega() {
		return tipoDeEntrega;
	}
	public boolean equalsFrete(int identificador) {
		if (this.identificador == identificador) {
			return true;
		} else {
			return false;
		}
	}

	}

