package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda {

	@Id
	@GeneratedValue
	private Long id;
	
	private int quantidade;
	
	@ManyToOne
	private DescProduto produto;

	public ItemVenda(int quantidade, DescProduto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public double getTotal() {
		return quantidade * produto.getPreco();
	}

}
