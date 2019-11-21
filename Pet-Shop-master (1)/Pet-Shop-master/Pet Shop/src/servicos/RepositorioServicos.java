package servicos;

public interface RepositorioServicos {
	public void inserir (Servicos servico) throws LimiteServicoAtingidoException, ServicoJaCadastradoException;
	public void remover (String codigo) throws ServicoNaoEncontradoException;
	public void atualizar (Servicos servico) throws ServicoNaoEncontradoException;
	public Servicos procurar (String codigo) throws ServicoNaoEncontradoException;
	public boolean existe (String codigo);
}
