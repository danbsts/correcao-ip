package dados;
import alugueis.*;
import carros.*;
import clientes.*;
import exceptions.*;

public interface RepositorioAlugados {
	public void alugar(Aluguel aluguel);
	public void remover(Aluguel aluguel) throws CNAException;
	public void atualizar(Aluguel aluguel) throws ANEException;
	public boolean existeClienteAlugando(String cpf);
	public boolean existeCarroAlugado(String placa);
	public Aluguel procurarAluguelCarro(String placa) throws CNAException;
	public Aluguel procurarAluguelCliente(String cpf) throws ANEException;
}
