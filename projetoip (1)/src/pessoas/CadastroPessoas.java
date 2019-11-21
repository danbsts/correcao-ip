package pessoas;
public class CadastroPessoas {
	Repositorio Repositorio;
	public CadastroPessoas(Repositorio Repositorio) {
		this.Repositorio=Repositorio;
	}
	public void cadastrar(Pessoa pessoa) throws PessoaJaExistenteException,CpfInvalidoException{
		if(pessoa.getCpf().length()!=14) {//123.456.789-10 (14 caracteres)
			throw new CpfInvalidoException();
		}else if(Repositorio.existe(pessoa.getCpf())){
			throw new PessoaJaExistenteException();
		}else {			
			this.Repositorio.cadastrar(pessoa);
		}
	}
	public void remover (String cpf) throws PessoaNaoEncontradaException,CpfInvalidoException{
		if(cpf.length()!=14) {
			throw new CpfInvalidoException();
		}else if(!Repositorio.existe(cpf)) {
			throw new PessoaNaoEncontradaException();
		}else {
			this.Repositorio.remover(cpf);
		}
	}
	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException,CpfInvalidoException{
		if(pessoa.getCpf().length()!=14) {
			throw new CpfInvalidoException();
		}else if(!Repositorio.existe(pessoa.getCpf())) {
			throw new PessoaNaoEncontradaException();
		}else {
			this.Repositorio.atualizar(pessoa);
		}
	}
	public Pessoa procurar (String cpf) throws PessoaNaoEncontradaException,CpfInvalidoException{
		if(cpf.length()!=14) {
			throw new CpfInvalidoException();
		}else if(!Repositorio.existe(cpf)) {
			throw new PessoaNaoEncontradaException();
		}else {
			return this.Repositorio.procurar(cpf);
		}
	}
	public boolean existe (String cpf) {
		return this.Repositorio.existe(cpf);
	}
}
