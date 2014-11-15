package com.pdm.projeto2.gameManager;

import java.util.Random;

public class GameManager {

	private char[][] mar = new char[9][9];

	public GameManager() {
		instanciateMatrix();
	}

	private void instanciateMatrix() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				this.mar[i][j] = '_';
			}
		}
	}

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt((9 - 1) + 1);
	}

	public int getEixo() {
		Random random = new Random();
		return random.nextInt((2 - 1) + 1) + 1;
	}

	public void criaNavios() {
		if (getEixo() == 1) {
			// Vertical
			int inicioV = getRandomNumber();
			int inicioH = getRandomNumber();
			while (inicioV > 6 || inicioH > 6
					|| this.mar[inicioV][inicioH] != '_'
					|| this.mar[inicioV][inicioH + 1] != '_'
					|| this.mar[inicioV][inicioH + 2] != '_') {
				inicioV = getRandomNumber();
				inicioH = getRandomNumber();
			}

			this.mar[inicioV][inicioH] = 'N';
			this.mar[inicioV][++inicioH] = 'N';
			this.mar[inicioV][++inicioH] = 'N';
		} else {
			// // Horizontal
			int inicioV = getRandomNumber();
			int inicioH = getRandomNumber();
			while (inicioV > 6 || inicioH > 6
					|| this.mar[inicioV][inicioH] != '_'
					|| this.mar[inicioV + 1][inicioH] != '_'
					|| this.mar[inicioV + 2][inicioH] != '_') {
				inicioV = getRandomNumber();
				inicioH = getRandomNumber();
			}

			this.mar[inicioV][inicioH] = 'N';
			this.mar[++inicioV][inicioH] = 'N';
			this.mar[++inicioV][inicioH] = 'N';
		}
	}
	
	public void criarSubmarinos(){
		int inicioV = getRandomNumber();
		int inicioH = getRandomNumber();
		while (inicioV > 7 || inicioH > 7
				|| this.mar[inicioV][inicioH] != '_'
				|| this.mar[inicioV+1][inicioH] != '_') {
			inicioV = getRandomNumber();
			inicioH = getRandomNumber();
		}

		this.mar[inicioV][inicioH] = 'S';
		this.mar[++inicioV][inicioH] = 'S';
	}
	
	public void criarTanques(){
		int inicioV = getRandomNumber();
		int inicioH = getRandomNumber();
		while (this.mar[inicioV][inicioH] != '_') {
			inicioV = getRandomNumber();
			inicioH = getRandomNumber();
		}

		this.mar[inicioV][inicioH] = 'T';
	}

	public void imprimeMatriz() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(this.mar[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

}
