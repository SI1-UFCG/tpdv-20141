import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.callAction;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.status;

import org.junit.Test;

import play.mvc.Http;
import play.mvc.Result;
import play.twirl.api.Content;

/**
 * 
 * Simple (JUnit) tests that can call all parts of a play app. If you are
 * interested in mocking a whole application, see the wiki for more details.
 * 
 */
public class ApplicationTest {

	@Test
	public void deveIniciarComVendaVazia() {
		Result result = callAction(controllers.routes.ref.Application.index(),
				fakeRequest());
		assertThat(status(result)).isEqualTo(Http.Status.OK);
		//assertThat(contentAsString(result)).contains("0 itens na venda");
	}

	// @Test
	// public void deveAdicionarItemNaVenda() {
	// int quantidade = 2;
	// long codigo = 49183L;
	//
	// Result result =
	// callAction(controllers.routes.ref.Application.adicionaItem(),
	// fakeRequest());
	// assertThat(status(result)).isEqualTo(Http.Status.OK);
	// assertThat(contentAsString(result)).contains("1 itens na venda");
	// }

	@Test
	public void renderTemplate() {
		Content html = views.html.index
				.render("Your new application is ready.");
		assertThat(contentType(html)).isEqualTo("text/html");
		assertThat(contentAsString(html)).contains(
				"Your new application is ready.");
	}

}
