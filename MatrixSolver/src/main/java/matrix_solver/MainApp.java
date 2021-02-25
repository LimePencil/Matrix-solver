package matrix_solver;
import java.util.Scanner;
public class MainApp{
    static Scanner sc = new Scanner(System.in);
    static double[][] targetMatrix;
    public static void main(String[] args) {        
        boolean rightMatrix = false;
        while(!rightMatrix){
            System.out.println("How many variables are there?");
            int variableNum = (int)askDouble();
            targetMatrix = new double[variableNum][variableNum+1];
            for (int i = 0; i < targetMatrix.length; i++) {
                for (int j = 0; j < targetMatrix.length + 1; j++) {
                    System.out.println("What is element a" + (i+1) + (j+1)+"?");
                    targetMatrix[i][j] = askDouble();
                }
            }
            Matrix.printMatrix(targetMatrix);
            System.out.println("Is this you matrix? Type 1 if it is right and Type 2 if you want to set the matrix again");
            if(askDouble() == 1){
                rightMatrix = true;
            }
        }
        
        Matrix mat1 = new Matrix(targetMatrix);
        mat1.solveMatrix();
        System.out.println("Done");
        askDouble();
    }
    public static double askDouble(){
        System.out.print("> ");
        double ans = scanDouble();
        System.out.println();
        return ans;
    }
    public static double scanDouble() {
        double num = 0;
        boolean state = false;
        while (!state){
            try {
                num = sc.nextDouble();
                sc.nextLine();
                state = true;
                
            } catch (Exception e) {
                System.out.println("Wrong input type. Try again.");
                sc.nextLine();
                state = false;
                System.out.print("> ");
            }
        }
        return num; 
    }
}