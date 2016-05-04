package mywork.sudoku.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mywork.sudoku.model.BaseResponse;
import mywork.sudoku.model.Cell;
import mywork.sudoku.model.SudokuResponse;
import mywork.sudoku.utils.SudokuSolver;

/**
 * Created by Abhilash on 03/05/2016.
 */
@RestController
public class Controller {
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	static int[][] sudokuMatrix = {{7, 0, 0, 0, 4, 0, 5, 3, 0},
			{0, 0, 5, 0, 0, 8, 0, 1, 0},
			{0, 0, 8, 5, 0, 9, 0, 4, 0},
			{5, 3, 9, 0, 6, 0, 0, 0, 1},
			{0, 0, 0, 0, 1, 0, 0, 0, 5},
			{8, 0, 0, 7, 2, 0, 9, 0, 0},
			{9, 0, 7, 4, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 5, 7, 0, 0, 0},
			{6, 0, 0, 0, 0, 0, 0, 5, 0}};

	@RequestMapping("/sudoku")
	public BaseResponse sudoku(
			@RequestParam(value = "val", required = false) Integer val,
			@RequestParam(value = "row", required = false) Integer row,
			@RequestParam(value = "col", required = false) Integer col) 
	{

		SudokuSolver solver = new SudokuSolver(sudokuMatrix);
		Cell cell = new Cell(row,col);
		if (val != null && row != null && col != null) {
			boolean isValid = solver.isValid(cell,val);
			boolean isPossibleValue = solver.setPossibleValue(cell,val);
			return new SudokuResponse(solver.getMatrix(), solver.isSolved(), isValid, isPossibleValue);
		}
		return new BaseResponse(solver.getMatrix(), solver.isSolved());
	}
}
