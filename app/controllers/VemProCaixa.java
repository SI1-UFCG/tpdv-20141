package controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import dao.GenericDAOImpl;
import models.DescProduto;
import models.ItemVenda;
import models.Venda;

public class VemProCaixa {
	
	private GenericDAOImpl dao = new GenericDAOImpl();
	
	public void novaVenda(){
		Venda aVenda = new Venda();
		dao.persist(aVenda);
	}
	
	public void addItem(int quantidade, long codigo) {
		Venda vendaAtual = getVendaAtual();
		vendaAtual.addItem(quantidade, this.getDescProduto(codigo));
		dao.merge(vendaAtual);
	}

	private Venda getVendaAtual() {
		return dao.findLatest(Venda.class, "id");
	}

	private DescProduto getDescProduto(long codigo) {
		return dao.findByEntityId(DescProduto.class, codigo);
	}

	public float getTotalAtual() {
		return getVendaAtual().getTotal();
	}

	public void cadastraProduto(long codigo, String desc, float preco) {
		DescProduto oProduto = new DescProduto(codigo, desc, preco);
		dao.persist(oProduto);
	}

	public void addPagamento(float valor, Date data) {
		Venda vendaAtual = getVendaAtual();
		vendaAtual.addPagamento(valor, data);
		dao.merge(vendaAtual);
	}

	public float getSaldoAtual() {
		return getVendaAtual().getSaldo();
	}

}
