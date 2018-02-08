package arrayStrings;

public class ZeroMatrix {
    
    //extra space
    public void remove(int[][] matrix) {
        
        if(matrix.length == 0 || matrix[0].length == 0) return;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] rows = new int[m];
        int[] cols = new int[n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        ZeroMatrix zm = new ZeroMatrix();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,0}};
        
        zm.remove(matrix);
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
                
            }
            System.out.println("");
        }
        
        matrix = new int[][]{{0,2,3,4},{5,6,7,8},{9,10,11,0}};
        
        zm.remove(matrix);
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
                
            }
            System.out.println("");
        }
        
    }
}
