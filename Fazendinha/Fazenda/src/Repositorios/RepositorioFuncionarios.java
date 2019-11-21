package Repositorios;

import ClassesBase.Funcionario;

public interface RepositorioFuncionarios {
	
	public void inserirFuncionario(Funcionario funcionario);
	public void atualizarFuncionario(Funcionario funcionario);
	public void removerFuncionario(String nome);
	public Funcionario procurarFuncionario(String nome);
	public boolean existeFuncionario(String nome);
	
}