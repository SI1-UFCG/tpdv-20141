package controllers;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import models.DescProduto;
import models.ItemVenda;
import models.Venda;

public class VemProCaixa {
	
	private Map<Long, DescProduto> produtos = new TreeMap<Long, DescProduto>();
	private Venda vendaAtual;
	
	public void novaVenda(){
		vendaAtual = new Venda();
	}
	
	public void addItem(int quantidade, long codigo) {
		vendaAtual.addItem(quantidade, this.getDescProduto(codigo));
	}

	private DescProduto getDescProduto(long codigo) {
		return produtos.get(codigo);
	}

	public float getTotalAtual() {
		return vendaAtual.getTotal();
	}

	public void cadastraProduto(long codigo, String desc, float preco) {
		DescProduto oProduto = new DescProduto(codigo, desc, preco);
		produtos.put(oProduto.getCodigo(), oProduto);
	}

}
