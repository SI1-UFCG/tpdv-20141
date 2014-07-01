package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class ItemVenda {

	@Id
	@GeneratedValue
	private Long id;

	private int quantidade;
	
	@OneToOne
	private DescProduto descProduto;

	public ItemVenda() {
	}

	public ItemVenda(int quantidade, DescProduto descProduto) {
		this.quantidade = quantidade;
		this.descProduto = descProduto;
	}

	public float getTotal() {
		return quantidade * descProduto.getPreco();
	}

}
