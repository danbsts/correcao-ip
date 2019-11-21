package funcionario;
import pessoa.Pessoa;
public class RepositorioFuncionarioArray implements RepositorioFuncionario {
	private Funcionario[] repositorio;
	private int contador;
	public RepositorioFuncionarioArray() {
		this.repositorio = new Funcionario[30]; // Array criado
		this.contador = 0;
}
	public void inserir(Funcionario funcionario) throws FuncionarioCadastradoException {
		for (int i = 0; i < this.contador; i++) {
			if (this.repositorio[i] == funcionario) {
				throw new FuncionarioCadastradoException();
			}
		}

		repositorio[contador] = funcionario;
		contador++;
		//this.contador sempre apontará para uma posição vazia

	}

	public Funcionario procurar(String cpf) throws FuncionarioNaoExisteException {
		Funcionario resposta = null;
		int i = this.getContador(cpf);// vai para o metodo getContador e joga cpf lá
		if (i == this.contador) {
//Quando i for igual a this.contador, dará erro(Não encontrou o funcionário)	
			throw new FuncionarioNaoExisteException();
		} else {
			resposta = this.repositorio[i];
		}
		return resposta;
	}
	private int getContador(String cpf) {
//Private pois so usarei esse metodo nessa classe
		String n;
		boolean achou = false;
		int i = 0;
		while ((!achou) && (i < this.contador)&&repositorio[i]!=null) {
//Se achou for vdd ele entra altomaticamente(mesma coisa que acontece no if)	
			n = repositorio[i].getCpf();
			if (n.equals(cpf)) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
//Se i for igual a this.contador, ele nao encontrou
	}
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoExisteException {
		int i = this.getContador(funcionario.getCpf());
		if (i == this.contador) {
			throw new FuncionarioNaoExisteException();
		} else {
			this.repositorio[i] = funcionario;
		}
	}
	public void remover(String cpf) throws FuncionarioNaoExisteException {
		int i = this.getContador(cpf);
		if (i == this.contador) {
			throw new FuncionarioNaoExisteException();
		} else {
			// this.contador aponta para uma posição vazia(sempre)
			this.contador = this.contador - 1;
			this.repositorio[i] = this.repositorio[this.contador];
			// botei eu que sou posição 1 na posicao q antes era de daniel, logo eu to na
			// posicao 0 e 1
			this.repositorio[this.contador] = null;
			// eu na posicao1 é agora e null
		}
	}
	public boolean existe(String cpf) {
		int i = getContador(cpf);
		if (i == this.contador) {
			return false;
		} else {
			return true;
		}
	}

}
