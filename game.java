/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

/**
 *
 * @author chinmay-kulkarni-ubuntu
 */
public class game {
       //static String[][] newArraytoCheck;
    
   
    public String[][] generateSudoku(int size, int level) {
        String[][] grid = new String[size][size];

        
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = "";

        
        int[] baseRow = new int[size];
        for (int i = 0; i < size; i++)
            baseRow[i] = i + 1;

        
        shuffleArray(baseRow);

        
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int value = baseRow[(col + row) % size];
                grid[row][col] = Integer.toString(value);
                //newArraytoCheck[row][col] = grid[row][col];
            }
        }

        
        System.out.println("100");
        int totalToRemove = (int)Math.floor((int)(size * size * 0.1 * level));
        System.out.println(totalToRemove + " totalToRemove");
        //System.out.print(totalToRemove);
        removeRandomElements(grid, totalToRemove);

        return grid;
    }

    
    public void shuffleArray(int[] array) {
     
        for (int i = array.length - 1; i > 0; i--) {
            int j = getRandom(i + 1);
            
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

   
    public void removeRandomElements(String[][] grid, int toRemove) {
        
        int size = grid.length;
        int removed = 0;

        while (removed < toRemove) {
            int i = getRandom(size);
            System.out.println("i " + i);
            int j = getRandom(size);
            System.out.println("j " + j);
            
            if (!grid[i][j].equals("")) {
                grid[i][j] = "";
                removed++;
            }
        }
        System.out.println("Yes");
    }
    
    private int getRandom(int num){
        long seed = System.nanoTime();
        return  Math.abs((int)seed % num);
    }
}
