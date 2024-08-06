package idGenerator_matrixSum;

import java.util.Scanner;

public class SumMatrix {

    public static void main(String[] args) {

        matrixSum();

    }


    //--------------------------------------------------------------------//
    //--------------------------------------------------------------------//
    //Functions


    //--------------------------------------------------------------------//
    //Diagonal to matrix sum

    static void matrixSum (){

        // We request number for row and column of the square matrix

        Scanner console = new Scanner(System.in);

        System.out.print("Insert number of the square matrix: ");

        int rC;

        rC = Integer.parseInt(console.nextLine());

        //We define the matrix

        int [][] matrix = new int[rC][rC];

        //We request to user, insert values of the matrix

        System.out.println("Insert values of the matrix");

        for (int rows = 0; rows < rC; rows++){
            for(int columns = 0; columns < rC; columns++){
                System.out.print("Row "+ rows + " column "+columns+" : ");
                matrix[rows][columns] = Integer.parseInt(console.nextLine());
            }
        }

        //We print the matrix

        for (int rows = 0; rows < rC; rows++){
            for(int columns = 0; columns < rC; columns++){
                System.out.print(matrix[rows][columns]+"  ");
            }
            System.out.println(" ");
        }

        //We add the numbers on the line
        int sum = 0;
        for(int rows = 0; rows < rC; rows++){
            for(int columns = 0; columns < rC; columns++){
                if(matrix[rows] == matrix[columns]){
                    sum+= matrix[rows][columns];
                }
            }
        }
        System.out.println("The sum of the matrix diagonal is: " + sum);
    }

}
