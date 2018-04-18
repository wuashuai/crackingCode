package recursion;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    public static void main(String[] args) {
        int m = 100;
        int n = 100;
        
        int[][] array = new int[m][n];
        
        generateBarrier(array);
        
        List<int[]> path = findPath(array, 0, 0);
        
        for(int[] p : path) {
            System.out.println(p[0] + "   " +  p[1]);
            
        }
    }
    
    
    private static void generateBarrier(int[][] array) {
        // TODO Auto-generated method stub
        
    }


    public static List<int[]> findPath(int[][] array, int x, int y){
        if(x == array.length && y == array[0].length) {
            return new ArrayList<>();
        }
        
        if(array[x][y] == -1) {
            return null;
        }
        
        return findPath(array, x+1, y);
        
    }
    
}
