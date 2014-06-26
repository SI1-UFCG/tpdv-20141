import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import base.AbstractTest;
import controllers.TPDVA;

public class TPDVATest extends AbstractTest {

	private TPDVA tpdv;

	@Before
	public void setup() {
		tpdv = new TPDVA();
		tpdv.cadastraProduto(423423L, "Iogurte", 5.0);
	}

	@Test
	public void deveIniciarComVendaVazia() {
		tpdv.novaVenda();
		assertEquals(tpdv.getTotalAtual(), 0.0, 0.0);
	}

	@Test
	public void deveAtualizarTotalAoAdicionarItem() throws Exception {
		tpdv.novaVenda();
		tpdv.addItemVenda(3, 423423L);
		assertEquals(tpdv.getTotalAtual(), 15.0, 0.0);
		tpdv.addItemVenda(2, 423423L);
		assertEquals(tpdv.getTotalAtual(), 25.0, 0.0);
	}

}
