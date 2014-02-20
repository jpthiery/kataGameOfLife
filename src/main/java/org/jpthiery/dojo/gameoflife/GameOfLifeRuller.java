package org.jpthiery.dojo.gameoflife;

import static org.jpthiery.dojo.gameoflife.Cell.ALIVE;
import static org.jpthiery.dojo.gameoflife.Cell.DEAD;

public class GameOfLifeRuller {

	private static final String SEPARATOR = "\t";

	public static Cell nextGeneration(Cell[][] initMatrix, int i, int j) {

		int aliveNeighbours = aliveNeigbour(initMatrix, i, j);

		if (aliveNeighbours == 2) {
			Cell currentCell = initMatrix[i][j];
			return currentCell;
		}
		if (aliveNeighbours == 3) {
			return ALIVE;
		}
		if (aliveNeighbours > 3) {
			return DEAD;
		}
		return DEAD;
	}

	private static int aliveNeigbour(Cell[][] initEnvironnement, int i, int j) {
		int nbNeighbours = 0;
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				int x = k + i - 1;
				int y = l + j - 1;
				if (isValideCoordonne(x, initEnvironnement.length) && isValideCoordonne(y, initEnvironnement[x].length)) {
					if (x != i || y != j) {
						Cell currentNeighbour = initEnvironnement[x][y];
						if (currentNeighbour == ALIVE) {
							nbNeighbours++;
						}
					}
				}
			}

		}
		return nbNeighbours;
	}

	private static boolean isValideCoordonne(int index, int lenghtAxe) {
		return index >= 0 && index < lenghtAxe;
	}
	
	public static void printEnvironnement(Cell[][] environnement) {
		for (int i = 0; i < environnement.length; i++) {
			Cell[] currentLine = environnement[i];
			for (int j = 0; j < currentLine.length; j++) {
				StringBuilder message = new StringBuilder();
				message.append(SEPARATOR).append(currentLine[j]).append(SEPARATOR);
				System.out.print(message.toString());
			}
			System.out.println("");
		}
	}

}
