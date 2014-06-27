package models;

public class ItemVenda {

	private int quantidade;
	private DescProduto descProduto;

	public ItemVenda(int quantidade, DescProduto descProduto) {
		this.quantidade = quantidade;
		this.descProduto = descProduto;
	}
	
	public float getTotal(){
		return quantidade * descProduto.getPreco();
	}

}
