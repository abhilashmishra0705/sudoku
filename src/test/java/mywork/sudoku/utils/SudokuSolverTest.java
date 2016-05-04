package mywork.sudoku.utils;

import org.junit.Test;

import mywork.sudoku.model.Cell;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Abhilash on 03/05/2016.
 */

public class SudokuSolverTest {
	
	@Test
	public void testNotPossibleValue() {
		int[][] matrix = {{7, 0, 0, 0, 4, 0, 5, 3, 0},
				{0, 0, 5, 0, 0, 8, 0, 1, 0},
				{0, 0, 8, 5, 0, 9, 0, 4, 0},
				{5, 3, 9, 0, 6, 0, 0, 0, 1},
				{0, 0, 0, 0, 1, 0, 0, 0, 5},
				{8, 0, 0, 7, 2, 0, 9, 0, 0},
				{9, 0, 7, 4, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 5, 7, 0, 0, 0},
				{6, 0, 0, 0, 0, 0, 0, 5, 0}};

		SudokuSolver solver = new SudokuSolver(matrix);
		assertFalse(solver.setPossibleValue(new Cell(2,0),7));
		assertFalse(solver.isSolved());
	}
	
	@Test
	public void testPossibleValue() {
		int[][] matrix = {{7, 0, 0, 0, 4, 0, 5, 3, 0},
				{0, 0, 5, 0, 0, 8, 0, 1, 0},
				{0, 0, 8, 5, 0, 9, 0, 4, 0},
				{5, 3, 9, 0, 6, 0, 0, 0, 1},
				{0, 0, 0, 0, 1, 0, 0, 0, 5},
				{8, 0, 0, 7, 2, 0, 9, 0, 0},
				{9, 0, 7, 4, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 5, 7, 0, 0, 0},
				{6, 0, 0, 0, 0, 0, 0, 5, 0}};

		SudokuSolver solver = new SudokuSolver(matrix);
		Cell cell = new Cell(0,1);
		assertTrue(solver.setPossibleValue(new Cell(2,0),3));
		assertFalse(solver.isSolved());
		assertTrue(solver.setPossibleValue(new Cell(8,8),7));
		assertFalse(solver.isSolved());
	}

	@Test
	public void testIsSolved() {
		int[][] matrix = {{7, 9, 2, 1, 4, 6, 5, 3, 8},
				{4, 6, 5, 2, 3, 8, 7, 1, 9},
				{0, 1, 8, 5, 7, 9, 6, 4, 2},
				{5, 3, 9, 8, 6, 4, 2, 7, 1},
				{2, 7, 6, 9, 1, 3, 4, 8, 5},
				{8, 4, 1, 0, 2, 5, 9, 6, 3},
				{9, 5, 7, 4, 8, 1, 3, 2, 6},
				{1, 2, 3, 6, 5, 7, 8, 9, 4},
				{6, 8, 4, 3, 9, 2, 1, 5, 7}};

		SudokuSolver solver = new SudokuSolver(matrix);
		assertTrue(solver.setPossibleValue(new Cell(5,3),7));
		assertFalse(solver.isSolved());
		assertTrue(solver.setPossibleValue(new Cell(2,0),3));
		assertTrue(solver.isSolved());
	}


}
