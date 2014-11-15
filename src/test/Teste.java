package test;

import com.pdm.projeto2.gameManager.GameManager;

public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 50; i++) {
			GameManager gameManager = new GameManager();
			gameManager.criaNavios();
			gameManager.criarSubmarinos();
			gameManager.criarSubmarinos();
			gameManager.criarTanques();
			gameManager.criarTanques();
			gameManager.imprimeMatriz();
			System.out.println("");
			System.out.println("");
			System.out.println("");

		}

	}

}
