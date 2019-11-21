package Repositorios;

import ClassesBasicas.Equipamento;
import Excecoes.EquipamentoJaCadastradoException;
import Excecoes.EquipamentoNaoEncontradoException;

public class RepositorioEquipamentoLista implements RepositorioEquipamento {
	private Equipamento equipamento;
	private RepositorioEquipamentoLista proximo;

	public RepositorioEquipamentoLista() {
		this.equipamento = null;
		this.proximo = null;
	}

	@Override
	public void inserir(Equipamento equipamento){
		if (this.proximo == null) {
			this.equipamento = equipamento;
			this.proximo = new RepositorioEquipamentoLista();
		}
		else {
			this.proximo.inserir(equipamento);
		}
	}

	@Override
	/*
	 * Remove um Equipamento (caso exista) e recebe atributos do pr�ximo elemento 
	 */
	public void remover(String nome) throws EquipamentoNaoEncontradoException {
		if (this.equipamento != null && this.equipamento.getNome().equals(nome)) {
			 if (this.proximo != null) {
				this.equipamento = this.proximo.equipamento;
				this.proximo = this.proximo.proximo;
			}
		} else if (this.proximo != null){
			this.proximo.remover(nome);
		} else{
			throw new EquipamentoNaoEncontradoException();
		}
	}
	
	@Override
	/*
	 * Atualiza um Equipamento ja inserido
	 */
	public void atualizar(Equipamento equipamento) throws EquipamentoNaoEncontradoException {
		if (this.equipamento == null) {
			throw new EquipamentoNaoEncontradoException();
		} else if (this.equipamento.getNome().equals(equipamento.getNome())) {
			this.equipamento = equipamento;
		} else {
			this.proximo.atualizar(equipamento);
		}
	}
	@Override
	/*
	 * Procura e retorna o equipamento cajo esteja inserido
	 */
	public Equipamento procurar(String nome) throws EquipamentoNaoEncontradoException {
		if (this.equipamento == null) {
			throw new EquipamentoNaoEncontradoException();
		}
		else if (this.equipamento.getNome().equals(nome)) {
			return equipamento;
		} 
		return this.proximo.procurar(nome);
	}
	@Override
	/*
	 * Informa se o equipamento esta inserido na Lista
	 */
	public boolean existe(String nome) {
		if (this.equipamento != null && this.equipamento.getNome().equals(nome)) {
			return true;
		} else if (this.proximo != null){
			return this.proximo.existe(nome);
		} else{
			return false;
		}
	}
}