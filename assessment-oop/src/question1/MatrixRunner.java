package question1;

public class MatrixRunner {
	public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 3);
        Matrix matrix2 = new Matrix(3, 2);

        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 2);
        matrix1.setElement(0, 2, 3);
        matrix1.setElement(1, 0, 4);
        matrix1.setElement(1, 1, 5);
        matrix1.setElement(1, 2, 6);

        matrix2.setElement(0, 0, 7);
        matrix2.setElement(0, 1, 8);
        matrix2.setElement(1, 0, 9);
        matrix2.setElement(1, 1, 10);
        matrix2.setElement(2, 0, 11);
        matrix2.setElement(2, 1, 12);

        System.out.println("Matrix 1:");
        matrix1.printMatrix();

        System.out.println("\nMatrix 2:");
        matrix2.printMatrix();

        System.out.println("\nMatrix 1 + Matrix 2:");
        Matrix sumMatrix = matrix1.add(matrix2);
        if (sumMatrix != null) {
            sumMatrix.printMatrix();
        }

        System.out.println("\nMatrix 1 * Matrix 2:");
        Matrix productMatrix = matrix1.multiply(matrix2);
        if (productMatrix != null) {
            productMatrix.printMatrix();
        }
    }
}
