package mywork.sudoku.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mywork.sudoku.model.BaseResponse;

/**
 * Created by Abhilash on 03/05/2016.
 */
@RestController
public class Controller {
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	static int[][] sudokuGrid = {{7, 0, 0, 0, 4, 0, 5, 3, 0},
				   {0, 0, 5, 0, 0, 8, 0, 1, 0},
				   {0, 0, 8, 5, 0, 9, 0, 4, 0},
				   {5, 3, 9, 0, 6, 0, 0, 0, 1},
				   {0, 0, 0, 0, 1, 0, 0, 0, 5},
				   {8, 0, 0, 7, 2, 0, 9, 0, 0},
				   {9, 0, 7, 4, 0, 0, 0, 0, 0},
				   {0, 0, 0, 0, 5, 7, 0, 0, 0},
				   {6, 0, 0, 0, 0, 0, 0, 5, 0}};

//	@RequestMapping("/sudoku")
//	public BaseResponse sudoku(
//			@RequestParam(value = "val", required = false) Integer val,
//			@RequestParam(value = "row", required = false) Integer row,
//			@RequestParam(value = "col", required = false) Integer col) 
//	{
//
//		return new BaseResponse();
//	}
}
