package servicos;
public class CadastroServicos {
	private RepositorioServicos reposervico;
	
	public CadastroServicos (RepositorioServicos reposervico) {
		this.reposervico = reposervico;
	}
	public void cadastrar (Servicos servico) throws ServicoJaCadastradoException, LimiteServicoAtingidoException{
		if(!this.reposervico.existe(servico.getCodigo())) {
			this.reposervico.inserir(servico);
		}
		else {
			ServicoJaCadastradoException e = new ServicoJaCadastradoException();
			throw e;
		}
	}
	public void remover (String codigo) throws ServicoNaoEncontradoException{
		this.reposervico.remover(codigo);
	}
	public void atualizar (Servicos servico) throws ServicoNaoEncontradoException{
		this.reposervico.atualizar(servico);
	}
	public Servicos procurar (String codigo) throws ServicoNaoEncontradoException{
		return this.reposervico.procurar(codigo);
	}
	public boolean existe (String codigo) {
		return this.reposervico.existe(codigo);
	}
}
