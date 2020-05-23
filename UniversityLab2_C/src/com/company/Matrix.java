package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    public int[][] matrix;
    int matrixSize;

    public Matrix() {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Введите размерность матрицы");
        int size = in.nextInt();
        matrixSize = size;
        matrix = new int[size][size];
        for(int i = 0; i < size; i++) {
            //System.out.println("Введите " + (i+1) + " строку матрицы");
            for(int j = 0; j < size; j++) {
                //int temp = in.nextInt();
                matrix[i][j] = r.nextInt(2*matrixSize + 1) - matrixSize;
            }
        }
    }

    public void Output() {
        for(int i = 0; i < matrixSize; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void Transpose() {
        int temp[][] = new int[matrixSize][matrixSize];
        for(int i = 0; i < matrixSize; i++) {
            for(int j = 0; j <matrixSize; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        for(int i=0; i<matrixSize; i++){for(int j=0; j<matrixSize; j++){matrix[j][i]=temp[i][j];}}
    }
}
