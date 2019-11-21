package servicoDeEntrega;

public class CadastroServicoDeEntrega {

      private RepositorioServicoEntrega fretes;
      private int contador;

public CadastroServicoDeEntrega(RepositorioServicoEntrega repositorioServicoEntrega) {
	this.fretes = repositorioServicoEntrega;
}

public int getContador() {
	return contador;
}

public void cadastrarFrete(ServicoDeEntrega frete) throws FreteJaExistenteException, FreteVazioException, DIException,IdentException,tipoEntException {
	if (frete == null) {
		throw new FreteVazioException();
	}else if (frete.getDistancia()<0||frete.getDistancia()>Integer.MAX_VALUE) {
		throw new DIException(frete.getDistancia());
	} else if (frete.getIdentificador()<0||frete.getIdentificador()>Integer.MAX_VALUE) {
		throw new IdentException(frete.getIdentificador());
	}else if (!frete.getTipoDeEntrega().equals("Normal")&&!frete.getTipoDeEntrega().equals("Ligeiro")&&!frete.getTipoDeEntrega().equals("Very Fast")) {
		throw new tipoEntException();
	}
	else if (!fretes.existeFrete(frete.getIdentificador())) {
		fretes.inserirFrete(frete);
		contador++;
	} else {
		throw new FreteJaExistenteException();
	}
}
public boolean existeFrete(int identificador) throws IdentException{
	 if (identificador<0||identificador>Integer.MAX_VALUE) {
			throw new IdentException(identificador);
		}
	 else if (fretes.existeFrete(identificador)==true) {
		return true;
	}else {
		return false;
	}
}
public void removerFrete(int identificador) throws FreteInexistenteException,IdentException{
	 if (identificador<0||identificador>Integer.MAX_VALUE) {
			throw new IdentException(identificador);
		}
	 else if (fretes.existeFrete(identificador)==true) {
		fretes.removerFrete(identificador);
		contador--;
	}else {
		throw new FreteInexistenteException();
	}
}
public ServicoDeEntrega procurarFrete(int identificador) throws FreteInexistenteException,IdentException{
	 if (identificador<0||identificador>Integer.MAX_VALUE) {
			throw new IdentException(identificador);
		}
	if (fretes.existeFrete(identificador)==true) {
		return fretes.procurarFrete(identificador);
	}else {
		throw new FreteInexistenteException();
	}
}
public void atualizarFrete(int identificador,ServicoDeEntrega newFrete)throws FreteInexistenteException,IdentException{
	 if (identificador<0||identificador>Integer.MAX_VALUE) {
			throw new IdentException(identificador);
		}
	if (fretes.existeFrete(identificador)==true) {
		fretes.atualizarFrete(identificador, newFrete);
	}else {
		throw new FreteInexistenteException();
	}
}
}
