package pessoas;
public interface Repositorio {
public boolean cadastrar(Pessoa pessoa) throws PessoaJaExistenteException;
public boolean remover(String cpf) throws PessoaNaoEncontradaException;
public boolean atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException;
public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException;
public boolean existe(String cpf);
}
