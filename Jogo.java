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
				+ TANQUE + "\nPosição no Mapa: " + posicao
				+ "\nQuantidade de Combustivel: " + combustivel
				+ "\nQuantidade de Combustiveis Nessa Posição: "
				+ mapa[combustivel];
		return saida;

	}

	// método que avança uma posição quando é chamado
	public void avancar() {
		if ((combustivel > 0) && (posicao < TAMANHO - 1)) {
			System.out.println("Você avançou uma posição.");
			combustivel--;
			posicao++;
			if (posicao == TAMANHO - 1) {
				System.out.println("Você Venceu!");
				System.exit(0);
			}
		} else if (posicao == 0) {
			combustivel = 6;

		} else if ((combustivel == 0) && (mapa[posicao] > 0)) {
			System.out
					.println("Há combustível nesta posição e você pode reabastecer!");
		} else {
			System.out
					.println("Você não possui combustivel Suficiente, e não pode recarregar.");
			System.out.println("----------------Game Over----------------");
			System.exit(0);
		}
	}

	// método que recua uma posição quando é chamado
	public void recuar() {

		if (posicao == 0) {
			System.out.println("Você já está no inicio");
			combustivel = 6;
		} else {
			if ((combustivel > 0)) {
				System.out.println("Você recuou uma posição.");
				combustivel--;
				posicao--;

			} else if ((combustivel == 0) && (mapa[posicao] > 0)) {
				System.out
						.println("Você está com o Tanque vazio mas pode reabastecer.");
			} else {
				System.out
						.println("Você não possui combustivel Suficiente, e não pode recarregar.\nGame Over");
				System.exit(0);
			}
		}
	}

	// método que carrega o tanque caso houver combustivel na posição do mapa
	public void carregar() {
		if (posicao == 0) {
			System.out.println("Você reabasteceu.");
			combustivel = 6;
		} else if (mapa[posicao] > 0) {
			System.out.println("Você reabasteceu 1 combustível.");
			combustivel++;
			mapa[posicao]--;
		} else {
			System.out
					.println("Nesta parte do mapa não possui Combustiveis Disponiveis.");
		}
	}

	// método que descarrega um tanque na posição
	public void descarregar() {
		if (posicao == 0) {

			System.out
					.println("Você está no inicio do Mapa não pode descarregar");

		} else if (mapa[posicao] < combustivel) {

			mapa[posicao]++;
			combustivel--;
			System.out.println("Você descarregou 1 combustível.");
		}
	}

	public String status() {
		String saida = "";
		saida += "\nPosição no Mapa: " + posicao
				+ "\nQuantidade de Combustivel: " + combustivel
				+ "\nQuantidade de Combustiveis Nessa Posição: "
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
			System.out.println("Digite a letra para a sua respectiva ação:\n"
					+ "Avançar (a)\n" + "Recuar (r)\n" + "Carregar (c)\n"
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
				System.out.println("Valor inválido!");
			}

		} while (loop != true);

		sc.close();

	}
}