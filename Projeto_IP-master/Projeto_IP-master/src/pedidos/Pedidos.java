package pedidos;

import pratos.Prato;

public class Pedidos {
	private Prato pedido;
	private int quantidadePratos;
	private String identificador;
	
	public Pedidos(Prato prato, int quantidade, String identificador) {
		this.pedido = prato;
		this.quantidadePratos = quantidade;
		this.identificador = identificador;
	}

	public int getQuantidadePratos() {
		return quantidadePratos;
	}

	public void setQuantidadePratos(int quantidadePratos ) {
		this.quantidadePratos = quantidadePratos;
	}

	public String getIdentificador() {
		return identificador;
	}

	public Prato getPrato() {
		return this.pedido;
	}

	public void setPedido(Prato prato) {
		this.pedido = prato;
	}
	public String toString(){
		return this.pedido + " " + this.quantidadePratos;
	}
}