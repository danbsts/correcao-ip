package funcionario;

import vendas.NaoExisteException;
import vendas.Vendas;

public class RepositorioFuncionariosArray implements RepositorioFuncionarios {
	private Funcionarios funcionarios[];
	int size = 0;

	public RepositorioFuncionariosArray() {
		funcionarios = new Funcionarios[size];
	}

	public void inserir(Funcionarios funcionario) {
		Funcionarios[] aux = new Funcionarios[size + 1];
		for (int i = 0; i <= size; i++) {
			if (i < size)
				aux[i] = funcionarios[i];
			else
				aux[i] = funcionario;
		}
		size++;
		funcionarios = aux;
	}

	public void remover(Funcionarios funcionario){
		Funcionarios[] aux = new Funcionarios[size - 1];
		boolean removeu = false;
		for (int i = 0; i < size; i++) {
			if((!removeu&&size==1&&!funcionarios[i].getCpf().equals(funcionario.getCpf()))||(size!=1&&!removeu&&i==size-1&&!funcionarios[i+1].getCpf().equals(funcionario.getCpf()))) {
				i++;
				}
			else if (funcionarios[i].getCpf().equals(funcionario.getCpf())) {
				removeu=true;
				if(i+1!=size)
				aux[i] = funcionarios[i+1];
				i++;
			}
			else
				aux[i] = funcionarios[i];
		}
		size--;
		funcionarios=aux;
	}
	public void atualizar(Funcionarios funcionario) throws FuncionarioInexistenteException {
		for (int i = 0; i < size; i++) {
			if (funcionarios[i].getCpf().equals(funcionario.getCpf())) {
				funcionarios[i] = funcionario;
				i = size;
			} else if (i == size -1) {
				throw new FuncionarioInexistenteException();
			}
		}
	}

	public Funcionarios procurar(String cpf) {
		for (int i = 0; i < size; i++) {
			if (this.funcionarios[i].getCpf().equals(cpf))
				return this.funcionarios[i];

		}
		return null;
	}

	public boolean existe(String cpf) {
		for (int i = 0; i < size; i++) {
			if (this.funcionarios[i].getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}

}