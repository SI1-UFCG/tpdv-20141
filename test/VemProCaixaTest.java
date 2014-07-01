import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import base.AbstractTest;
import controllers.VemProCaixa;

public class VemProCaixaTest extends AbstractTest {

	private static final long CODIGO_EXEMPLO = 237864237864L;
	private VemProCaixa vpc;

	@Before
	public void setup() {
		vpc = new VemProCaixa();
		vpc.cadastraProduto(CODIGO_EXEMPLO, "Sabão", 5f);
	}

	@Test
	public void deveAtualizarTotalAoAddItem() {

		vpc.novaVenda();

		// OPCAO 1
		// DESCARTADA POR CAUSA DO CREATOR
		// ItemVenda item = new ItemVenda(...);
		// vpc.addItem(item);

		// OPCAO 2
		vpc.addItem(2, CODIGO_EXEMPLO);

		// total tem que ser 10
		assertEquals(10f, vpc.getTotalAtual(), 0f);
	}

	@Test
	public void deveAtualizarSaldoAposPagamento() throws Exception {
		vpc.novaVenda();
		
		vpc.addItem(1, CODIGO_EXEMPLO);
		
		vpc.addPagamento(2f, Calendar.getInstance().getTime());
		
		assertEquals(5f, vpc.getTotalAtual(), 0f);
		assertEquals(3f, vpc.getSaldoAtual(), 0f);
	}
}
