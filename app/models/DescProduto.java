package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DescProduto {

	@Id
	private long codigo;

	private String descricao;
	private double preco;

	public DescProduto() {

	}

	public DescProduto(long codigo, String descricao, double preco) {
		this.codigo = codigo;
		this.setDescricao(descricao);
		this.setPreco(preco);
	}

	public double getPreco() {
		return this.preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
