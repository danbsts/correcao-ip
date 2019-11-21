package vendedores;

import exceptions.*;
import dados.*;

public class CadastroVendedor {

    private RepositorioVendedor rv;

    public CadastroVendedor(RepositorioVendedor rv) {
        this.rv = rv;
    }

    public void cadastrar(Vendedor vendedor) throws VCException, MATException, TELException, CPFException {
        if (this.existe(vendedor.getMatricula()) == false) {
            if (vendedor.getMatricula() < 10000 || vendedor.getMatricula() > 99999) {
                throw new MATException();
            } else {
            	if (vendedor.getTelefone().length() == 8) {
            		char[] c = new char[8];
            		for (int i = 0; i < 8; i++) {
            			c[i] = vendedor.getTelefone().charAt(i);
            			if (!Character.isDigit(c[i])) {
            				throw new TELException();
            			} else {
            				if (c[i] < 0) {
            					throw new TELException();
            				}
            			}
            		}
            	} else {
            		throw new TELException();
            	}
            	if (vendedor.getCpf().length() == 11) {
            		char[] d = new char[11];
            		for (int i = 0; i < 11; i++) {
            			d[i] = vendedor.getCpf().charAt(i);
            			if (!Character.isDigit(d[i])) {
            				throw new CPFException();
            			} else {
            				if (d[i] < 0) {
            					throw new CPFException();
            				}
            			}
            		}
            		this.rv.inserir(vendedor);
            	} else {
            		throw new CPFException();
            	}

            }

        } else {
            throw new VCException();
        }
    }

    public void remover(int matricula) throws FNEException {
        if (this.existe(matricula)) {
            this.rv.remover(matricula);
        } else {
            throw new FNEException();
        }
    }

    public void atualizar(Vendedor vendedor, int matricula) throws MATException, MNException, TELException, CPFException {
        if (this.existe(matricula)) {
            if (vendedor.getMatricula() != matricula) {
                if (vendedor.getMatricula() < 10000 || vendedor.getMatricula() > 99999) {
                    throw new MNException();
                }
            }
            if (vendedor.getTelefone().length() == 8) {
            	char[] c = new char[8];
            	for (int i = 0; i < 8; i++) {
            		c[i] = vendedor.getTelefone().charAt(i);
            		if (!Character.isDigit(c[i])) {
            			throw new TELException();
            		} else {
            			if (c[i] < 0) {
            				throw new TELException();
            			}
            		}
            	}
            } else {
            	throw new TELException();
            }
           if (vendedor.getCpf().length() == 11) {
        	   char[] d = new char[11];
        	   for (int i = 0; i < 11; i++) {
        		   d[i] = vendedor.getCpf().charAt(i);
        		   if (!Character.isDigit(d[i])) {
        			   throw new CPFException();
        		   } else {
        			   if (d[i] < 0) {
        				   throw new CPFException();
        			   }
        		   }
            }
        	   this.rv.atualizar(vendedor, matricula);
           } else {
        	   throw new CPFException();
           }
        } else {
            throw new MATException();
        }
            
    }

    public Vendedor procurar(int matricula) throws VNCException {
        if (this.existe(matricula)) {
            return this.rv.procurar(matricula);
        } else {
            throw new VNCException();
        }
    }

    public boolean existe(int matricula) {
        return rv.existeMatricula(matricula);
    }
}
