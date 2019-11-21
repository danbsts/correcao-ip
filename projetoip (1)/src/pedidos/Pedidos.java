package pedidos;

import pessoas.Cliente;
import pessoas.Garcom;

public class Pedidos {
	//Definiros identificadors, gerar os get's e set's, e construtor(es).

	private String codigo;
	private String tipo;
	private Cliente cliente;//comprador
	private int valor;//valor
	private Garcom funcionario;//gar�on

	
	
	

	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Pedidos(String codigo,String tipo,Cliente cliente, Garcom funcionario, int valor) {

		this.codigo = codigo;
		this.cliente = cliente;
		this.tipo=tipo;
		this.funcionario = funcionario;
		this.valor=valor;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Garcom getFuncionario() {
		return funcionario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setFuncionario(Garcom funcionario) {
		this.funcionario = funcionario;
	}

	

	



}
