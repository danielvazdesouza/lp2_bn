import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TravessiaDesertoTeste {

	private TravessiaDeserto travessia = null;

	@Before
	public void setUp() {
		travessia = new TravessiaDeserto();
	}

	@After
	public void tearDown() {
		travessia = null;
	}

	@Test
	public void initGameTest() {
		travessia.initGame();
		assertEquals(0, travessia.getPos());
		assertEquals(travessia.MAX_FUEL, travessia.getFuel());
		assertEquals(travessia.MAP_SIZE, travessia.getMap().length);
	}

	@Test
	public void avancarTest() {
		travessia.initGame();

		// Salva estado atual
		int combustivel = travessia.getFuel();
		int posicao = travessia.getPos();

		travessia.avancar();

		assertEquals(combustivel - 1, travessia.getFuel());
		assertEquals(posicao + 1, travessia.getPos());
	}

	@Test
	public void voltarTest() {
		travessia.initGame();
		travessia.avancar();

		int combustivel = travessia.getFuel();
		int posicao = travessia.getPos();

		travessia.voltar();

		assertEquals(combustivel, travessia.getFuel() - 1);
		assertEquals(posicao - 1, travessia.getPos());
	}

	@Test
	public void descarregarTest() {
		travessia.initGame();
		travessia.avancar();

		int combustivel = travessia.getFuel();
		int posicao = travessia.getPos();
		int[] mapa = travessia.getMap();

		travessia.descarregar();

		assertEquals(combustivel - 1, travessia.getFuel());
		assertEquals(1, mapa[posicao]);
	}

	@Test
	public void carregarTest() {
		travessia.initGame();
		travessia.avancar();
		travessia.descarregar();

		int combustivel = travessia.getFuel();
		int posicao = travessia.getPos();
		int[] mapa = travessia.getMap();

		travessia.carregar();

		assertEquals(combustivel + 1, travessia.getFuel());
		assertEquals(0, mapa[posicao]);
	}

	@Test
	public void translateCommandTest() {

		assertEquals(travessia.translateCommand("avancar"), travessia.AVANCAR);
		assertEquals(travessia.translateCommand("voltar"), travessia.VOLTAR);
		assertEquals(travessia.translateCommand("carregar"), travessia.CARREGAR);
		assertEquals(travessia.translateCommand("descarregar"),
				travessia.DESCARREGAR);
		assertEquals(travessia.translateCommand("ajuda"), travessia.AJUDA);
		assertEquals(travessia.translateCommand("acelerar"), travessia.ERROR);
	}
	
	@Test
	public void processCommandTest(){
		
		//avancar
		travessia.initGame();
		int combustivel = travessia.getFuel();
		int posicao = travessia.getPos();		
		travessia.processCommand(0);
		assertEquals(combustivel - 1, travessia.getFuel());
		assertEquals(posicao + 1, travessia.getPos());

		//voltar
		combustivel = travessia.getFuel();
		posicao = travessia.getPos();
		travessia.processCommand(1);
		voltarTest();
		assertEquals(combustivel, travessia.getFuel() - 1);
		assertEquals(posicao - 1, travessia.getPos());
		
		//carregar
		travessia.processCommand(2);
		travessia.descarregar();
		combustivel = travessia.getFuel();
		posicao = travessia.getPos();
		int[] mapa = travessia.getMap();
		travessia.carregar();
		assertEquals(combustivel + 1, travessia.getFuel());
		assertEquals(0, mapa[posicao]);

		//descarregar
		travessia.processCommand(3); //descarregar
		combustivel = travessia.getFuel();
		posicao = travessia.getPos();
		mapa = travessia.getMap();
		travessia.descarregar();
		assertEquals(combustivel - 1, travessia.getFuel());
		
	}
}
