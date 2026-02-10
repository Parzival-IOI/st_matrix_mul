import java.util.ArrayList;
import java.util.Scanner;

class Matrix {

  private Scanner scanner;

  Matrix() {
    scanner = new Scanner(System.in);
  }

  public void display(ArrayList<ArrayList<Integer>> matrix) {

    System.out.println("Matrix:");
    for (ArrayList<Integer> row : matrix) {
      for (Integer value : row) {
        System.out.print(value + " ");
      }
      System.out.println();
    }

  }

  public boolean validateMatrix(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB) {
    System.out.println("Checking if matrices are created...");
    if (matrixA == null || matrixB == null) {
      System.out.println("Matrices are not created yet.");
      return false;
    }

    if (matrixA.size() != matrixB.size() || matrixA.get(0).size() != matrixB.get(0).size()) {
      System.out.println("Matrix addition is not possible: dimensions mismatch.");
      return false;
    }

    return true;
  }

  public ArrayList<ArrayList<Integer>> createMatrix() {
    int columns, rows;
    System.out.print("Enter number of columns: ");
    columns = scanner.nextInt();
    System.out.print("Enter number of rows: ");
    rows = scanner.nextInt();

    ArrayList<ArrayList<Integer>> dynamicArray = new ArrayList<>();

    for (int i = 0; i < columns; i++) {
      ArrayList<Integer> row = new ArrayList<>();
      for (int j = 0; j < rows; j++) {
        System.out.print("Enter value for [" + i + "][" + j + "]: ");
        row.add(scanner.nextInt());
      }
      dynamicArray.add(row);
    }
    System.out.println("Matrix created.");

    display(dynamicArray);

    return dynamicArray;
  }

  public void add(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB) {

    if (!validateMatrix(matrixA, matrixB)) {
      return;
    }

    int rows = matrixA.size();
    int columns = matrixB.get(0).size();

    ArrayList<ArrayList<Integer>> resultMatrix = new ArrayList<>();

    for (int i = 0; i < rows; i++) {
      ArrayList<Integer> row = new ArrayList<>();
      for (int j = 0; j < columns; j++) {
        row.add(0);
      }
      resultMatrix.add(row);
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        resultMatrix.get(i).set(j, matrixA.get(i).get(j) + matrixB.get(i).get(j));
      }
    }

    display(resultMatrix);
    System.out.println("Matrices added.");
  }

  public void multiply(ArrayList<ArrayList<Integer>> matrixA, ArrayList<ArrayList<Integer>> matrixB) {

    validateMatrix(matrixA, matrixB);

    int rows = matrixA.size();
    int columns = matrixB.get(0).size();

    ArrayList<ArrayList<Integer>> resultMatrix = new ArrayList<>();

    for (int i = 0; i < rows; i++) {
      ArrayList<Integer> row = new ArrayList<>();
      for (int j = 0; j < columns; j++) {
        row.add(0);
      }
      resultMatrix.add(row);
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        for (int k = 0; k < columns; k++) {
          resultMatrix.get(i).set(j, resultMatrix.get(i).get(j) + matrixA.get(i).get(k) * matrixB.get(k).get(j));
        }
      }
    }

    display(resultMatrix);
    System.out.println("Matrices multiplied.");
  }

  public ArrayList<ArrayList<Integer>> randomMatrix() {

    int columns, rows;
    System.out.print("Enter number of columns: ");
    columns = scanner.nextInt();
    System.out.print("Enter number of rows: ");
    rows = scanner.nextInt();

    ArrayList<ArrayList<Integer>> dynamicArray = new ArrayList<>();
    for (int i = 0; i < columns; i++) {
      ArrayList<Integer> row = new ArrayList<>();
      for (int j = 0; j < rows; j++) {
        row.add((int) (Math.random() * 10)); // Random values between 0 and 9
      }
      dynamicArray.add(row);
    }

    display(dynamicArray);

    return dynamicArray;
  }

}