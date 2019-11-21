package cartas;

import cartas.Carta;

public class CartaEspectroHades extends Carta {

	public CartaEspectroHades(String nome, String desc,int id) {
		super(nome,desc, id);
	}
	
	//Implementação do método abstrato
		public String getDesc() {
			return "Efeito sombriu da carta: " + this.desc;
		}

}
