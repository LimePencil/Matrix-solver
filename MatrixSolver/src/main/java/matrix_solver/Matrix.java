package matrix_solver;

public class Matrix {
    double[][] mat;
    int numVar;
    public Matrix(double[][] mat){
        this.mat = mat;
        numVar = mat.length;
    }
    public void solveMatrix(){
        System.out.println("START");
        System.out.println("________________________");
        //make into identity matrix
        for(int i = 0; i < numVar; i++){
            for(int j = 0; j < numVar;j++){
                if(i!=j && mat[j][i] !=0){
                    printMatrix(mat);
                    multiplyRow(i, -1*mat[j][i]/mat[i][i]);
                    addRow(j, i);
                    System.out.println("________________________");
                }
            }
            printMatrix(mat);
            multiplyRow(i, 1/mat[i][i]);
            System.out.println("________________________");
        }
        //rount to 10000th digit
        for(int i = 0; i < numVar;i++){
            for (int j = 0; j < numVar+1; j++) {
                mat[i][j] = Math.round(mat[i][j] * 100000.0) / 100000.0;
            }
        }
        printMatrix(mat);
    }
    private void multiplyRow(int row, double a){
        System.out.println("Mulitply row " + (row +1) + " by " + a );
        for(int i=0;i<=numVar;i++){
            mat[row][i] *= a;
        }
    }
    private void addRow(int first,int second){
        System.out.println("Add row " + (second +1)+ " to row " + (first+1) );
        for(int i=0;i<=numVar;i++){
            mat[first][i] += mat[second][i]; 
        }
    }
    static public void printMatrix(double[][] matrix){
        for(int i = 0; i < matrix.length;i++){
            for (int j = 0; j < matrix.length+1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("________________________");
    }

}
