package question1;
public class Matrix {
    private int numRows;
    private int numColumns;
    private int[][] elements;

    public Matrix(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.elements = new int[numRows][numColumns];
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setElement(int i, int j, int value) {
        if (i >= 0 && i < numRows && j >= 0 && j < numColumns) {
            elements[i][j] = value;
        } else {
            System.out.println("Invalid position for setting element.");
        }
    }

    public int getElement(int i, int j) {
        if (i >= 0 && i < numRows && j >= 0 && j < numColumns) {
            return elements[i][j];
        } else {
            System.out.println("Invalid position for getting element.");
            return -1;
        }
    }

    public Matrix add(Matrix otherMatrix) {
        if (numRows == otherMatrix.getNumRows() && numColumns == otherMatrix.getNumColumns()) {
            Matrix sumMatrix = new Matrix(numRows, numColumns);
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numColumns; j++) {
                    sumMatrix.setElement(i, j, elements[i][j] + otherMatrix.getElement(i, j));
                }
            }
            return sumMatrix;
        } else {
            System.out.println("Matrices cannot be added.");
            return null;
        }
    }

    public Matrix multiply(Matrix otherMatrix) {
        if (numColumns == otherMatrix.getNumRows()) {
            Matrix productMatrix = new Matrix(numRows, otherMatrix.getNumColumns());
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < otherMatrix.getNumColumns(); j++) {
                    int sum = 0;
                    for (int k = 0; k < numColumns; k++) {
                        sum += elements[i][k] * otherMatrix.getElement(k, j);
                    }
                    productMatrix.setElement(i, j, sum);
                }
            }
            return productMatrix;
        } else {
            System.out.println("Matrices cannot be multiplied.");
            return null;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
    }

}
