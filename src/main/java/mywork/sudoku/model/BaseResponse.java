package mywork.sudoku.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Abhilash on 03/05/2016.
 */

@JsonPropertyOrder({ "currentMatrix", "isSolved" })
public class BaseResponse {

    protected int[][] currentMatrix;
    protected boolean isSolved;

    public BaseResponse(int[][] currentMatrix, boolean isSolved) {
        this.currentMatrix = currentMatrix;
        this.isSolved = isSolved;
    }

    @JsonProperty("currentMatrix")
    public int[][] getMatrix() {
        return currentMatrix;
    }

    @JsonProperty("currentMatrix")
    public void setMatrix(int[][] currentMatrix) {
        this.currentMatrix = currentMatrix;
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
