package org.ajeet.learnings.algorithms.uf;

public final class PercolationDFS {

    public static boolean percolate(boolean[][] input){
        if(input == null)
            throw new IllegalArgumentException("Input grid cant be null.");

        int n = input.length;
        boolean[][] isFull = new boolean[n][n];
        for (int j=0; j< n; j++){
            percolate(isFull, input, 0, j);
        }
        for (int j=0; j< n; j++){
            if(isFull[n-1][j]) return true;
        }
        return false;
    }

    private static void percolate(boolean[][] isFull, boolean[][] input, int row, int column) {
        int n = input.length;
        //Validate
        if (row < 0 || row >= n) return;
        if (column < 0 || column >= n) return;
        if(input[row][column]) return; // Blocked cell, no path from here
        if(isFull[row][column]) return; //Already went through this cell

        //Mark it as path
        isFull[row][column] = true;

        //Move
        percolate(isFull, input, row-1, column); //TOP
        percolate(isFull, input, row+1, column); //BOTTOM
        percolate(isFull, input, row, column-1); //LEFT
        percolate(isFull, input, row, column+1); //RIGHT
    }

    public static void main(String[] args) {
/*
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int rows = Integer.valueOf(line[0]);
        int cols = Integer.valueOf(line[1]);

        boolean[][] input = new boolean[rows][cols];
        for(int i=0; i< rows; i++){
           // line = scanner.nextLine().split(" ");
            for(int j=0; j<Integer.valueOf(line[1]); j++){
                //"1" is for blocked and "0" for open
                input[i][j] = scanner.nextInt()==1 ? true:false;
            }
        }
*/
        //true for blocked and false for open
        boolean[][] test1 =
                {{false, true, false},
                {false, false, false},
                {true, true, false}};
        System.out.println(percolate(test1));

        boolean[][] test2 =
                {{false, true, false},
                {false, false, false},
                {true, true, true}};
        System.out.println(percolate(test2));

        boolean[][] test3 =
                {{false, true, true},
                {false, false, false},
                {true, true, false}};
        System.out.println(percolate(test3));

    }
}
