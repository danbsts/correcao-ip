package venda;
public class VendaNaoEncontradaException extends Exception {
       public VendaNaoEncontradaException () {
    	   super("Venda nao encontrada!");
       }
}