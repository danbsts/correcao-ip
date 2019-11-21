package dados;
import carros.*;

public interface RepositorioCarros {
	void inserir(Carros carro);
	Carros procurar(String p); 
	void remover(String p); 
	void atualizar(Carros carro, String p);
	boolean existePlaca(String p);
	boolean isAlugado(String p);
}

