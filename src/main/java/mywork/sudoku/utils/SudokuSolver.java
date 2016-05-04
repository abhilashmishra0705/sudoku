package mywork.sudoku.utils;

import mywork.sudoku.model.Cell;

public class SudokuSolver {

	private int matrix[][];
	private int solvedMatrix[][] = new int[9][9];

	public SudokuSolver(int[][] matrix) {
		this.matrix = matrix;
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				this.solvedMatrix[i][j]=matrix[i][j];
			}
		}
		if (!solve(new Cell(0, 0))) {
			throw new RuntimeException("No possible solution!");
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public int[][] getSolvedMatrix() {
		return solvedMatrix;
	}

	/**
	 * Check if the Sudoku matrix is solved.
	 *
	 * @return true if it is solved otherwise false.
	 */
	public boolean isSolved() {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (matrix[row][col] != solvedMatrix[row][col]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Solve the Sudoku matrix
	 *
	 * @param Cell containing row and column
	 * @return false if no values are found for this cell.
	 */
	public boolean solve(Cell cur) {

		if (cur == null)
			return true;

		// if matrix[cur] already has a value, there is nothing to solve here,
		// continue on to next cell
		if (solvedMatrix[cur.getRow()][cur.getCol()] != 0) {
			return solve(getNextCell(cur));
		}

		// if matrix[cur] doesn't have a value, try each value from 1 to 9
		for (int i = 1; i <= 9; i++) {
			if (isValid(cur, i)){
				solvedMatrix[cur.getRow()][cur.getCol()] = i; //set the valid value in the cell
				// if solved, return true, else try other values
				if (solve(getNextCell(cur)))
					return true;
			}
		}
		solvedMatrix[cur.getRow()][cur.getCol()] = 0;
		return false;
	}

	public Cell getNextCell(Cell cur) {

		int row = cur.getRow();
		int col = cur.getCol();
		col++;

		if (col > 8) {
			col = 0;
			row++;
		}

		if (row > 8)
			return null; 

		Cell next = new Cell(row, col);
		return next;
	}


	/**
	 * Check if a number for the given cell is valid as per the rules.
	 */

	public boolean isValid(Cell cell, int value) {

		if (solvedMatrix[cell.getRow()][cell.getCol()] == value) {
			return true;
		}

		return isValid(cell.getRow(), cell.getCol(), value);
	}
	private boolean isValid(int row, int col, int value) {
		int x = 3 * (row/ 3);
		int y = 3 * (col/ 3);

		for (int i = 0; i < 9; i++) {
			if (solvedMatrix[row][i] == value || solvedMatrix[i][col] == value ||
					solvedMatrix[x+(i%3)][y+(i/3)] == value) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Check if a number for the given cell is part of a possible Sudoku solution.
	 */
	public boolean setPossibleValue(Cell cur, int value) {
		if (solvedMatrix[cur.getRow()][cur.getCol()] == value) {
			matrix[cur.getRow()][cur.getCol()] = value;
			return true;
		}
		return false;
	}

}