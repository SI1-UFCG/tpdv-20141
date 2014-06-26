package controllers;

import models.DescProduto;
import models.Venda;
import dao.GenericDAOImpl;

public class TPDVA {

	GenericDAOImpl dao = new GenericDAOImpl();

	public double getTotalAtual() {
		return getVendaAtual().getTotal();
	}

	public void novaVenda() {
		dao.persist(new Venda());
	}

	public void addItemVenda(int quantidade, long codigo) {
		getVendaAtual().addItemVenda(quantidade, getProduto(codigo));
	}

	private Venda getVendaAtual() {
		return dao.findLatest(Venda.class, "id");
	}

	private DescProduto getProduto(long codigo) {
		return dao.findByEntityId(DescProduto.class, codigo);
	}

	public void cadastraProduto(long codigo, String descricao, double preco) {
		dao.persist(new DescProduto(codigo, descricao, preco));
	}

}
