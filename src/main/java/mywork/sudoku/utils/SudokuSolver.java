package mywork.sudoku.utils;

import mywork.sudoku.model.Cell;

public class SudokuSolver {

	private static int matrix[][];
	private static int solvedMatrix[][] = new int[9][9];

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
		printMatrix(solvedMatrix);
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
	static boolean solve(Cell cur) {

		if (cur == null)
			return true;

		// if matrix[cur] already has a value, there is nothing to solve here,
		// continue on to next cell
		if (matrix[cur.getRow()][cur.getCol()] != 0) {
			return solve(getNextCell(cur));
		}
		
		// if matrix[cur] doesn't have a value, try each value from 1 to 9
		for (int i = 1; i <= 9; i++) {
			boolean valid = isValid(cur, i);

			if (!valid) 
				continue;
			solvedMatrix[cur.getRow()][cur.getCol()] = i; //set the valid value in the cell
			boolean solved = solve(getNextCell(cur));
			
			// if solved, return true, else try other values
			if (solved)
				return true;
			else
				solvedMatrix[cur.getRow()][cur.getCol()] = 0; // reset
		}
		return false;
	}

	public static Cell getNextCell(Cell cur) {

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
	
	public static boolean isValid(Cell cell, int value) {

		// if the value is present in the row, return false
		for (int c = 0; c < 9; c++) {
			if (solvedMatrix[cell.getRow()][c] == value)
				return false;
		}

		// if the value is present in the column, return false
		for (int r = 0; r < 9; r++) {
			if (solvedMatrix[r][cell.getCol()] == value)
				return false;
		}

		// if value is present in the region(3*3), return false
		int x1 = 3 * (cell.getRow() / 3);
		int y1 = 3 * (cell.getCol() / 3);
		int x2 = x1 + 2;
		int y2 = y1 + 2;

		for (int x = x1; x <= x2; x++)
			for (int y = y1; y <= y2; y++)
				if (solvedMatrix[x][y] == value)
					return false;

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


	public static void printMatrix(int matrix[][]) {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++)
				System.out.print(matrix[row][col]);
			System.out.println();
		}
	}
}