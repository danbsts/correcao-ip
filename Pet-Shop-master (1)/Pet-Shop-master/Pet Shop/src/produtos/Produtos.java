package produtos;

public class Produtos {
	private String nomeProduto;
	private String codeProduto;
	private double price;
	private int quantidade;
	private String fornecedor;
	
	public Produtos (String nomeProduto, String codeProduto, double price, int quantidade, String fornecedor) {
		this.nomeProduto=nomeProduto;
		this.codeProduto=codeProduto;
		this.price=price;
		this.quantidade=quantidade;
		this.fornecedor=fornecedor;
		
	}public String getNome() {
		return nomeProduto;
		
	}public void setNome(String nomeProduto) {
		this.nomeProduto = nomeProduto;
		
	}public String getCode() {
		return codeProduto;
		
	}public void setCode(String codeProduto) {
		this.codeProduto = codeProduto;
		
	}public double getPrice() {
		return price;
		
	}public void setPrice(double price) {
		this.price = price;
		
	}public int getQuantidade() {
		return quantidade;
		
	}public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
		
	}public String getFornecedor() {
		return fornecedor;
		
	}public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
		
	}
}

