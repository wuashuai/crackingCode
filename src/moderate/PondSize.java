package moderate;

import java.util.ArrayList;
import java.util.List;

public class PondSize {

    static int[][] dirs = {{0,1},{0,-1},{1,-1},{1,1},{-1,1},{-1,-1},{1,0},{-1,0}};


    public static List<Integer> find(int[][] area){

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < area.length; i++){
            for(int j = 0; j < area[0].length; j++){

                if(area[i][j] == 0) {
                    res.add(connect(area, i, j));
                }
            }
        }

        return res;
    }

    public static int connect(int[][] area, int i, int j ){

        if(i >= area.length || i < 0 || j < 0 || j >= area[0].length || area[i][j] != 0) return 0;

        int res = 1;

        area[i][j] = -1;

        for(int[] dir : dirs){
            int x = i - dir[0];
            int y = j - dir[1];

            res += connect(area, x, y);

        }

        return res;
    }

    public static void main(String[] args){

    //,{},{},{},{},{},{},{}
        int[][] area = {{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};

        List<Integer> res = find(area);

        res.stream().forEach(x -> System.out.println(x));

    }
}
