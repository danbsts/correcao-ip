package cartas;
//mudanças serão feitas
public class CartaCavaleiro extends Carta {
	private int atk;
	private int def;
	private String signo;
	private String classificacao;
	private String constelacao;

	public CartaCavaleiro(String nome, String desc, int atk, int def, String signo, String classificacao, String constelacao,
			int id) {
		super(nome, desc, id);
		this.atk = atk;
		this.def = def;
		this.signo = signo;
		this.classificacao = classificacao;
		this.constelacao = constelacao;
	}

	public void setATQ(int atk) {
		this.atk = atk;
	}

	public void setDFS(int def) {
		this.def = def;
	}

	//Implementação do método abstrato
    public String getDesc()  {
        return "Descrição do monstro: " + this.desc;
    }

	public void setSigno(String signo) {
		this.signo = signo;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public void setConstelacao(String constelacao) {
		this.constelacao = constelacao;
	}

	public int getATK() {
		return this.atk;
	}

	public int getDEF() {
		return this.def;
	}

	public String getSigno() {
		return this.signo;
	}

	public String getClassificacao() {
		return this.classificacao;
	}

	public String getConstelacao() {
		return this.constelacao;
	}

}