package mywork.sudoku.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Abhilash on 03/05/2016.
 */
@JsonPropertyOrder({ "currentMatrix", "isSolved", "isPossibleValue" })
public class SudokuResponse extends BaseResponse {

    private boolean isValid;
    private boolean isPossibleValue;

    public SudokuResponse(int[][] currentMatrix, boolean isSolved, boolean isPossibleValue) {
        super(currentMatrix, isSolved);
        this.isPossibleValue = isPossibleValue;
    }
    
    @JsonProperty("isPossibleValue")
    public boolean isPossibleValue() {
        return isPossibleValue;
    }

    @JsonProperty("isPossibleValue")
    public void setPossibleSolution(boolean possibleValue) {
    	isPossibleValue = possibleValue;
    }

}
