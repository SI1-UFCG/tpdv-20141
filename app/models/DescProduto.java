package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DescProduto {

	@Id
	private long codigo;
	private String desc;
	private float preco;

	public DescProduto(long codigo, String desc, float preco) {
		this.codigo = codigo;
		this.desc = desc;
		this.preco = preco;
	}

	public long getCodigo() {
		return codigo;
	}

	public float getPreco() {
		return preco;
	}

}
