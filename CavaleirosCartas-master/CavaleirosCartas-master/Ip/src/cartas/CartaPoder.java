package cartas;

public class CartaPoder extends Carta {

	public CartaPoder(String nome, String desc, int id) {
		super(nome, desc, id);
	}

	//Implementação do método abstrato
    public String getDesc() {
        return "Efeito mágico da carta: " + this.desc;
    }
}
