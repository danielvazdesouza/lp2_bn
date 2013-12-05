package com.senac.planilha;

import java.util.Scanner;

import com.senac.algoritmos.AvaliadorExpressao;
import com.senac.algoritmos.InvalidOperator;
import com.senac.algoritmos.InvalidToken;
import com.senac.lista.*;

public class Planilha {

	/**
	 * @param args
	 * @throws InvalidOperator
	 * @throws InvalidToken
	 */

	public static void main(String[] args) throws InvalidOperator, InvalidToken {

		String nome;
		String formula;
		double result = 0;
		Lista lista = new Lista();
		Celula celula = new Celula();
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("Digite a celula: ");
			nome = sc.next();
			
			if (nome.equalsIgnoreCase("fim")) {
				System.out.println("Fim do Programa");
				break;
			}

			System.out.println("Digite a formula para a celula");
			formula = sc.nextLine();

			celula.setnome(nome);
			celula.setformula(formula);


		}

	}

}
