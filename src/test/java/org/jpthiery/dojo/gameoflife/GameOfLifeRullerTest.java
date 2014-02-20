package org.jpthiery.dojo.gameoflife;

import static org.jpthiery.dojo.gameoflife.Cell.ALIVE;
import static org.jpthiery.dojo.gameoflife.Cell.DEAD;
import static org.jpthiery.dojo.gameoflife.GameOfLifeRuller.nextGeneration;
import static org.jpthiery.dojo.gameoflife.GameOfLifeRuller.printEnvironnement;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameOfLifeRullerTest {

	@Test
	public void fewer_than_two_neighbours_die_with_one_cell() {
		Cell[][] initEnvironnement = new Cell[][] { //
		{ DEAD, DEAD, DEAD }, //
				{ DEAD, ALIVE, DEAD }, //
				{ DEAD, DEAD, DEAD }, //
		};

		Cell genCell = nextGeneration(initEnvironnement, 1, 1);

		assertEquals(DEAD, genCell);
	}

	@Test
	public void with_two_neighbours_a_living_cell_should_live() {
		Cell[][] initEnvironnement = new Cell[][] { //
		{ ALIVE, DEAD, ALIVE }, //
				{ DEAD, ALIVE, DEAD }, //
				{ DEAD, DEAD, DEAD }, //
		};

		Cell genCell = nextGeneration(initEnvironnement, 1, 1);

		assertEquals(ALIVE, genCell);
	}

	@Test
	public void with_three_neighbours_a_living_cell_should_live() {
		Cell[][] initEnvironnement = new Cell[][] { //
		{ ALIVE, DEAD, ALIVE }, //
				{ ALIVE, ALIVE, DEAD }, //
				{ DEAD, DEAD, DEAD }, //
		};

		Cell genCell = nextGeneration(initEnvironnement, 1, 1);

		assertEquals(ALIVE, genCell);
	}

	@Test
	public void with_four_neighbours_aliving_cell_should_die() {
		Cell[][] initEnvironnement = new Cell[][] { //
		{ ALIVE, DEAD, ALIVE }, //
				{ ALIVE, ALIVE, DEAD }, //
				{ DEAD, ALIVE, DEAD }, //
		};

		Cell genCell = nextGeneration(initEnvironnement, 1, 1);

		assertEquals(DEAD, genCell);
	}

	@Test
	public void with_three_neighbours_a_dead_cell_should_born() {
		Cell[][] initEnvironnement = new Cell[][] { //
		{ ALIVE, DEAD, DEAD }, //
				{ ALIVE, DEAD, DEAD }, //
				{ DEAD, ALIVE, DEAD }, //
		};

		Cell genCell = nextGeneration(initEnvironnement, 1, 1);

		assertEquals(ALIVE, genCell);
	}

	@Test
	public void with_two_neighbours_a_dead_cell_should_born() {
		Cell[][] initEnvironnement = new Cell[][] { //
		{ DEAD, DEAD, DEAD }, //
				{ ALIVE, DEAD, DEAD }, //
				{ DEAD, ALIVE, DEAD }, //
		};

		Cell genCell = nextGeneration(initEnvironnement, 1, 1);

		assertEquals(DEAD, genCell);
	}

	@Test
	public void acceptance_rule1() {
		Cell[][] initEnvironnement = new Cell[][] { //
		{ DEAD, ALIVE, DEAD }, //
				{ DEAD, ALIVE, DEAD }, //
				{ DEAD, ALIVE, DEAD }, //
		};
		Cell[][] expectedEnvironnement = new Cell[][] { //
		{ DEAD, DEAD, DEAD }, //
				{ ALIVE, ALIVE, ALIVE }, //
				{ DEAD, DEAD, DEAD }, //
		};

		Cell[][] nextEnvironnement = new Cell[initEnvironnement.length][initEnvironnement[0].length];
		for (int i = 0; i < initEnvironnement.length; i++) {
			Cell[] currentLine = initEnvironnement[i];
			for (int j = 0; j < currentLine.length; j++) {
				nextEnvironnement[i][j] = nextGeneration(initEnvironnement, i,
						j);
			}
		}

		for (int i = 0; i < expectedEnvironnement.length; i++) {
			Cell[] currentLine = expectedEnvironnement[i];
			for (int j = 0; j < currentLine.length; j++) {
				assertEquals(expectedEnvironnement[i][j], currentLine[j]);
			}
		}
		
		printEnvironnement(nextEnvironnement);
		
	}
	
	

}
