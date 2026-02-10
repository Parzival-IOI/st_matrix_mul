import java.util.ArrayList;
import java.util.Scanner;

public class SingleThread {

  private Matrix matrix;
  private Scanner scanner;
  private int choice;

  private ArrayList<ArrayList<Integer>> matrixA;
  private ArrayList<ArrayList<Integer>> matrixB;
  private int countMatrix;

  SingleThread() {
    matrix = new Matrix();
    scanner = new Scanner(System.in);
    choice = 5;
    countMatrix = 0;
  }

  private boolean validateMatrix() {
    System.out.println("Checking if matrices are created...");
    if (matrixA == null || matrixB == null) {
      System.out.println("Matrices are not created yet.");
      return false;
    }
    return true;
  }
  
  public void createMenu() {

    do {
      System.out.println("Menu:");
      System.out.println("1. Create Matrix");
      System.out.println("2. Auto Generate Matrices");
      System.out.println("3. Addition");
      System.out.println("4. Multiplication");
      System.out.println("5. Exit");


      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          if (countMatrix == 0) {
            matrixA = matrix.createMatrix();
            countMatrix++;
          } else if (countMatrix == 1) {
            matrixB = matrix.createMatrix();
            countMatrix++;
          } else {
            System.out.println("Both matrices are already created.");
          }
          break;
        case 2:
          if (countMatrix == 0) {
            matrixA = matrix.randomMatrix();
            countMatrix++;
          } else if (countMatrix == 1) {
            matrixB = matrix.randomMatrix();
            countMatrix++;
          } else {
            System.out.println("Both matrices are already created.");
          }
          break;
        case 3:
          if (validateMatrix()) {
            matrix.add(matrixA, matrixB);
          }
          break;
        case 4:
          if (validateMatrix()) {
            matrix.multiply(matrixA, matrixB);
          }
          break;
        case  5:
          System.out.println("Exiting...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice. Please try again.");
      }

      // wait for user press any key before showing the menu again
       scanner.nextLine(); 

      // clear screen+
      // System.out.print("\033[H\033[2J");
      // System.out.flush();

    } while (choice != 5);
  }
}