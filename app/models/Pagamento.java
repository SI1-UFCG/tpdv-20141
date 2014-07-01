package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pagamento {

	@Id
	@GeneratedValue
	private Long id; 
	
	private float valor;
	
	@Temporal(value = TemporalType.DATE)
	private Date data;

	public Pagamento() {
	}
	
	public Pagamento(float valor, Date data) {
		this.valor = valor;
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

}
