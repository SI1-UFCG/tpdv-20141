package models;

import java.util.LinkedList;
import java.util.List;

public class Venda {

	private List<ItemVenda> itens = new LinkedList<ItemVenda>();

	public void addItem(int quantidade, DescProduto descProduto) {
		this.itens .add(new ItemVenda(quantidade, descProduto));
	}

	public float getTotal() {
		float total = 0f;
		for (ItemVenda item: itens) {
			total += item.getTotal();
		}
		return total;
	}

}
