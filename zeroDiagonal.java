import java.util.Scanner;
public class zeroDiagonal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the order of the square matrix: ");
        int order = input.nextInt();

        int[][] matrix = new int[order][order];
        System.out.print("Enter the matrix\n");

        for(int i=0;i<order;i++){
            for(int j=0;j<order;j++){
                matrix[i][j] = input.nextInt();     
            }
        }

      

        for(int i=0;i<order;i++)
            for(int j=0;j<order;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        input.close();
    }
}
    