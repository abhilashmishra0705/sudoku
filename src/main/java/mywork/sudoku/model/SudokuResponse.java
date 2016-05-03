package mywork.sudoku.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Abhilash on 03/05/2016.
 */
@JsonPropertyOrder({ "currentGrid", "isSolved", "isValidCandidate", "isPossibleSolution" })
public class SudokuResponse extends BaseResponse {

    private boolean isValidCandidate;
    private boolean isPossibleSolution;

    public SudokuResponse(int[][] currentGrid, boolean isSolved, boolean isValidCandidate, boolean isPossibleSolution) {
        super(currentGrid, isSolved);
        this.isValidCandidate = isValidCandidate;
        this.isPossibleSolution = isPossibleSolution;
    }

    @JsonProperty("isValidCandidate")
    public boolean isValidCandidate() {
        return isValidCandidate;
    }

    @JsonProperty("isValidCandidate")
    public void setValidCandidate(boolean validCandidate) {
        isValidCandidate = validCandidate;
    }

    @JsonProperty("isPossibleSolution")
    public boolean isPossibleSolution() {
        return isPossibleSolution;
    }

    @JsonProperty("isPossibleSolution")
    public void setPossibleSolution(boolean possibleSolution) {
        isPossibleSolution = possibleSolution;
    }

}
