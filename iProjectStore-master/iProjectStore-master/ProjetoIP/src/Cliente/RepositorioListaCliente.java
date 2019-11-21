package Cliente;
public class RepositorioListaCliente implements RepositorioCliente{
		
		private Cliente cliente;
		private RepositorioListaCliente prox;
		
		public RepositorioListaCliente(){
			this.cliente = null;
			this.prox = null;
		}
		
		public void inserir(Cliente cliente) {
			if(this.cliente == null) {
				this.cliente = cliente;
				this.prox = new RepositorioListaCliente();
			}else {
				this.prox.inserir(cliente);
			}
		}
		public void remover(String cpf) 
	            throws ClienteNaoEncontradoException {
	        Cliente clienteEncontrado = this.procurar(cpf);
	        if (this.cliente != null) {
	            if (this.cliente.equals(clienteEncontrado)) {
	                this.cliente = this.prox.cliente;
	                this.prox = this.prox.prox;
	            } else {
	                this.prox.remover(cpf);
	            }
	        } else {
	        	ClienteNaoEncontradoException a;
	            a = new ClienteNaoEncontradoException();
	            throw a;
        }
	    }
		public Cliente procurar(String cpf)
	            throws ClienteNaoEncontradoException {
	    	Cliente retorno;
	        retorno = null;
	        if (this.cliente != null) {
	            if (this.cliente.getCpf().equals(cpf)) {
	                retorno = this.cliente;
	            } else {
	                retorno = this.prox.procurar(cpf);
	            }
	        } else {
	            ClienteNaoEncontradoException e;
	            e = new ClienteNaoEncontradoException();
	            throw e;
	        }
	        return retorno;
	    }
		
		 public void atualizar(Cliente cliente)
		            throws ClienteNaoEncontradoException {
		        Cliente clienteAnterior = procurar(cliente.getCpf());
		        this.remover(clienteAnterior.getCpf());
		        this.inserir(cliente);
		    }
		
		 public boolean existe(String cpf) {
		        if (this.cliente != null) {
		            if (this.cliente.getCpf().equals(cpf)) {
		                return true;
		            } else {
		                return this.prox.existe(cpf);
		            }
		        } else {
		            return false;
		        }
		    }
		
	}
