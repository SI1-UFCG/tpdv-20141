import static org.junit.Assert.*;

import org.junit.Test;

import controllers.VemProCaixa;


public class VemProCaixaTest {

	@Test
	public void deveAtualizarTotalAoAddItem() {
		VemProCaixa vpc = new VemProCaixa();
		vpc.cadastraProduto(237864237864L, "Sabão", 5f);

		vpc.novaVenda();
		
		// OPCAO 1
		// DESCARTADA POR CAUSA DO CREATOR
		// ItemVenda item = new ItemVenda(...);
		// vpc.addItem(item);
		
		// OPCAO 2
		vpc.addItem(2, 237864237864L);
		
		// total tem que ser 10
		assertEquals(10f, vpc.getTotalAtual(), 0f);
	}

}
