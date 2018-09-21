package leetcode;

import java.util.*;

public class NQueen {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        if(n == 0) return res;

        boolean[][] map = new boolean[n][n];

        helper(map, 0, res);

        return res;
    }

    public void helper(boolean[][] map, int start, List<List<String>> res){

        if(start >= map.length){
            res.add(convert(map));
            return;
        }

        for(int i = 0; i < map.length; i++){
            if(!check(map, start, i)) continue;
            map[start][i] = true;
            helper(map, start + 1, res);
            map[start][i] = false;
        }
    }

    public List<String> convert(boolean[][] map){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < map.length; i++ ){
            String s = "";
            for(int j = 0; j < map.length; j++){
                s += map[i][j] ? 'Q' : '.';
            }
            res.add(s);
        }
        return res;
    }

    public boolean check(boolean[][] map, int i, int j){

        for(int a = 0; a < i; a++){
            if(map[a][j]) return false;
        }

        for(int a = 1; a <= Math.min(i,j); a++){
            if(map[i-a][j-a]) return false;
        }

        for(int a = 1; a <= Math.min(i, map.length - j);a++){
            if(map[i-a][j+a]) return false;
        }

        return true;
    }
}