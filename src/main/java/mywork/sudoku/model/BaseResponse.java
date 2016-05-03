package mywork.sudoku.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Abhilash on 03/05/2016.
 */

@JsonPropertyOrder({ "currentGrid", "isSolved" })
public class BaseResponse {

    protected int[][] currentGrid;
    protected boolean isSolved;

    public BaseResponse(int[][] currentGrid, boolean isSolved) {
        this.currentGrid = currentGrid;
        this.isSolved = isSolved;
    }

    @JsonProperty("currentGrid")
    public int[][] getGrid() {
        return currentGrid;
    }

    @JsonProperty("currentGrid")
    public void setGrid(int[][] currentGrid) {
        this.currentGrid = currentGrid;
    }

    @JsonProperty("isSolved")
    public boolean isSolved() {
        return isSolved;
    }

    @JsonProperty("isSolved")
    public void setSolved(boolean solved) {
        isSolved = solved;
    }

}
