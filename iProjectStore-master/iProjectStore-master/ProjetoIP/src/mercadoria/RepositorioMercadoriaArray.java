package mercadoria;


public class RepositorioMercadoriaArray implements RepositorioMercadoria {
	private Mercadoria[] arrayMercadorias;
	private int index;

	public RepositorioMercadoriaArray() {
		this.index = 0;
		this.arrayMercadorias = new Mercadoria[index];	
	}

	public void inserir(Mercadoria mercadoria) throws MercadoriaJaCadastradaException {
		Mercadoria[] aux = new Mercadoria[index + 1];
		for (int i = 0; i <= index; i++) {
			if (i < index)
				aux[i] = arrayMercadorias[i];
			else if(i!=index&&arrayMercadorias[i].getId()==(mercadoria.getId())) {
				i=index+1;
				throw new MercadoriaJaCadastradaException();
			}
			else
				aux[i] = mercadoria;
		}
		index++;
		arrayMercadorias = aux;
	}

	public void remover(int id) throws MercadoriaNaoEncontradaException {
		int i = this.getIndex(id);
		if (this.arrayMercadorias.length - 1 - i >= 0) {
			System.arraycopy(arrayMercadorias, i + 1, this.arrayMercadorias, i, this.arrayMercadorias.length - 1 - i);
		}
		if(index>0) {
		this.arrayMercadorias[this.arrayMercadorias.length - 1] = null;
		this.index -= 1;
		}
		else if(index==0) {
			throw new MercadoriaNaoEncontradaException();
		}
	}

	public void atualizar(Mercadoria mercadoria) throws MercadoriaNaoEncontradaException {
        for (int i = 0; i < index; i++) {
            if (arrayMercadorias[i].getId()==(mercadoria.getId())) {
                arrayMercadorias[i] = mercadoria;
                i=index;
            }
            else if (i == index - 1)
                throw new MercadoriaNaoEncontradaException();
        }
    }

	public Mercadoria procurar(int id) throws MercadoriaNaoEncontradaException {
		Mercadoria encontrada = null;
		boolean achou = false;
		for (int i = 0; i < this.index && !achou; i++) {
			if (this.arrayMercadorias[i].getId() == id) {
				encontrada = this.arrayMercadorias[i];
				achou = true;
			}
		}
		if (achou) {
			return encontrada;
		} else {
			MercadoriaNaoEncontradaException e;
			e = new MercadoriaNaoEncontradaException();
			throw e;
		}

	}

	public boolean existe(int id) {
		boolean achou = false;
		for (int i = 0; i < this.index && !achou; i++) {
			if (this.arrayMercadorias[i].getId() == id) {
				achou = true;
			} else {
				achou = false;
			}
		}
		return achou;
	}

	public Mercadoria[] getArrayMercadorias() {
		return arrayMercadorias;
	}

	public void setArrayMercadorias(Mercadoria[] arrayMercadorias) {
		this.arrayMercadorias = arrayMercadorias;
	}

	public int getIndex(int id) {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
