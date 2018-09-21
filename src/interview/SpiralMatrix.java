package interview;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        if(matrix.length == 0 || matrix[0].length == 0) return res;

        int m = matrix.length-1;

        int a = m/2;
        int b = m/2;
        int c = m/2;
        int d = m/2;

        while(a >= 0 || b >= 0 || c < m || d < m){

            for(int i = c; i <= d; i++){
                res.add(matrix[a][i]);
            }

            d++;

            if(d >= m) break;

            for(int i = a; i <= b; i++){
                res.add(matrix[i][d]);
            }

            b++;

            if(b >= m) break;

            for(int i = d; i >= c; i--){
                res.add(matrix[b][i]);
            }

            c--;

            if(c < 0) break;

            for(int i = b; i >= a; i--){
                res.add(matrix[i][c]);
            }

            a--;

        }
        return res;
    }

    public static void main(String[] args){
        SpiralMatrix sm = new SpiralMatrix();

        //int[][] matrix = {{21,22,23,24,25},{20,7,8,9,10},{19,6,1,2,11},{18,5,4,3,12},{17,16,15,14,13}};
        int[][] matrix = {{7,8,9,10},{6,1,2,11},{5,4,3,12},{16,15,14,13}};

        List<Integer> res = sm.spiralOrder(matrix);
        res.stream().forEach(x -> System.out.print(x + " "));
    }

}
