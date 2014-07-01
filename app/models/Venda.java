package models;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Venda {
	
	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemVenda> itens = new LinkedList<ItemVenda>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Pagamento> pagamentos = new LinkedList<Pagamento>();

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

	public float getSaldo() {
		return getTotal() - getPago();
	}

	private float getPago() {
		float pago = 0;
		for (Pagamento pagamento : pagamentos) {
			pago += pagamento.getValor();
		}
		return pago;
	}

	public void addPagamento(float valor, Date data) {
		this.pagamentos .add(new Pagamento(valor, data));
	}

}
