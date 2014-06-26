package models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Venda {
	
	@Id
	@GeneratedValue
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable
	private List<ItemVenda> itensVenda = new LinkedList<ItemVenda>();

	public void addItemVenda(int quantidade, DescProduto produto) {
		ItemVenda item = new ItemVenda(quantidade, produto);
		this.itensVenda.add(item);
	}

	public double getTotal() {
		double total = 0.0;
		for (ItemVenda item : itensVenda) {
			total += item.getTotal();
		}
		return total;
	}

}
