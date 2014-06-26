import static org.junit.Assert.*;

import java.util.List;

import models.DescProduto;
import models.Venda;

import org.junit.Test;

import base.AbstractTest;
import dao.GenericDAOImpl;

public class DaoTest extends AbstractTest {

	GenericDAOImpl dao = new GenericDAOImpl();

	@Test
	public void deveSalvarProduto() throws Exception {
		DescProduto umProduto = new DescProduto(3, "produto", 1.0);
		dao.persist(umProduto);

		List<DescProduto> prods = dao.findAllByClassName(DescProduto.class);
		
		assertEquals(1, prods.size());
	}

	@Test
	public void deveSalvarVenda() {
		DescProduto umProduto = new DescProduto(3, "produto", 1.0);
		dao.persist(umProduto);
		
		Venda v = new Venda();
		dao.persist(v);
		
		v.addItemVenda(2, umProduto);
		
		dao.merge(v);
		
		Venda atual = dao.findLatest(Venda.class, "id");
		
		assertNotNull(atual);
		assertNotEquals(0.0, atual.getTotal());
	}
}
