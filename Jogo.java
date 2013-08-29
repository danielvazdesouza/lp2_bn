import java.util.Scanner;

public class Jogo {
	private int TAMANHO = 10;
	private int[] mapa = new int[] {999,0,0,0,0,0,0,0,0,0};
	private int TANQUE = 6;
	private int posicao = 0;
	private int combustivel = 6;

	public String start() {
		String saida = "";
		saida += "Tamanho do Mapa: " + TAMANHO + "\nTamanho do Tanque: "
				+ TANQUE + "\nPosi��o no Mapa: " + posicao
				+ "\nQuantidade de Combustivel: " + combustivel
				+ "\nQuantidade de Combustiveis Nessa Posi��o: "
				+ mapa[combustivel];
		return saida;

	}

	// m�todo que avan�a uma posi��o quando � chamado
	public void avancar() {
		if ((combustivel > 0) && (posicao < TAMANHO - 1)) {
			System.out.println("Voc� avan�ou uma posi��o.");
			combustivel--;
			posicao++;
			if (posicao == TAMANHO - 1) {
				System.out.println("Voc� Venceu!");
				System.exit(0);
			}
		} else if (posicao == 0) {
			combustivel = 6;

		} else if ((combustivel == 0) && (mapa[posicao] > 0)) {
			System.out
					.println("H� combust�vel nesta posi��o e voc� pode reabastecer!");
		} else {
			System.out
					.println("Voc� n�o possui combustivel Suficiente, e n�o pode recarregar.");
			System.out.println("----------------Game Over----------------");
			System.exit(0);
		}
	}

	// m�todo que recua uma posi��o quando � chamado
	public void recuar() {

		if (posicao == 0) {
			System.out.println("Voc� j� est� no inicio");
			combustivel = 6;
		} else {
			if ((combustivel > 0)) {
				System.out.println("Voc� recuou uma posi��o.");
				combustivel--;
				posicao--;

			} else if ((combustivel == 0) && (mapa[posicao] > 0)) {
				System.out
						.println("Voc� est� com o Tanque vazio mas pode reabastecer.");
			} else {
				System.out
						.println("Voc� n�o possui combustivel Suficiente, e n�o pode recarregar.\nGame Over");
				System.exit(0);
			}
		}
	}

	// m�todo que carrega o tanque caso houver combustivel na posi��o do mapa
	public void carregar() {
		if (posicao == 0) {
			System.out.println("Voc� reabasteceu.");
			combustivel = 6;
		} else if (mapa[posicao] > 0) {
			System.out.println("Voc� reabasteceu 1 combust�vel.");
			combustivel++;
			mapa[posicao]--;
		} else {
			System.out
					.println("Nesta parte do mapa n�o possui Combustiveis Disponiveis.");
		}
	}

	// m�todo que descarrega um tanque na posi��o
	public void descarregar() {
		if (posicao == 0) {

			System.out
					.println("Voc� est� no inicio do Mapa n�o pode descarregar");

		} else if (mapa[posicao] < combustivel) {

			mapa[posicao]++;
			combustivel--;
			System.out.println("Voc� descarregou 1 combust�vel.");
		}
	}

	public String status() {
		String saida = "";
		saida += "\nPosi��o no Mapa: " + posicao
				+ "\nQuantidade de Combustivel: " + combustivel
				+ "\nQuantidade de Combustiveis Nessa Posi��o: "
				+ mapa[posicao];
		return saida;

	}

	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		boolean loop = false;
		Scanner sc = new Scanner(System.in);
		System.out.println(jogo.start());

		do {

			String opcao = "";
			System.out.println("Digite a letra para a sua respectiva a��o:\n"
					+ "Avan�ar (a)\n" + "Recuar (r)\n" + "Carregar (c)\n"
					+ "Descarregar (d)\n" + "Imprimir Status (s)");
			opcao = sc.next();

			switch (opcao) {

			case "a":
				jogo.avancar();
				System.out.println(jogo.status());
				break;

			case "r":
				jogo.recuar();
				System.out.println(jogo.status());
				break;

			case "c":
				jogo.carregar();
				System.out.println(jogo.status());
				break;

			case "d":
				jogo.descarregar();
				System.out.println(jogo.status());
				break;

			case "s":
				System.out.println(jogo.status());
				break;

			default:
				System.out.println("Valor inv�lido!");
			}

		} while (loop != true);

		sc.close();

	}
}