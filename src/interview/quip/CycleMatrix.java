package interview.quip;

import java.util.*;

public class CycleMatrix {
    public boolean hasCycle(String[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0) return false;


        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] || matrix[i][j].length() == 0){
                    continue;
                }

                visited[i][j] = true;

                int a = i;
                int b = j;

                Set<String> set = new HashSet<>();
                set.add(i+ " " + j);

                while(matrix[a][b].length() != 0){
                    int[] index = convert(matrix[a][b]);

                    if(index[0] >= m || index[1] >= n) break;

                    if(set.contains(index[0] + " " + index[1])) return false;

                    if(visited[index[0]][index[1]]) break;

                    a = index[0];
                    b = index[1];
                }
            }
        }

        return true;
    }

    public boolean topologic(String[][] matrix){

        if(matrix.length == 0 || matrix[0].length == 0) return false;


        int m = matrix.length;
        int n = matrix[0].length;

        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> in = new HashMap<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                String index = convert(i, j);

                if(!in.containsKey(index)) in.put(index, 0);

                if(matrix[i][j].length() != 0){
                    if(!in.containsKey(matrix[i][j])) in.put(matrix[i][j], 0);
                    if(!map.containsKey(index)) map.put(index, new ArrayList<>());

                    map.get(index).add(matrix[i][j]);
                    in.put(matrix[i][j], in.get(matrix[i][j]) + 1);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();

        int count = 0;

        for(String s : map.keySet()){
            if(in.get(s) == 0){
                queue.offer(s);
            }
        }

        while(!queue.isEmpty()){
            String s = queue.poll();
            count++;

            for(String ss : map.getOrDefault(s, new ArrayList<>())){
                in.put(ss, in.get(ss) - 1);
                if(in.get(ss) == 0 && map.containsKey(ss)) queue.offer(ss);
            }
        }

        return count == m * n;
    }

    public String convert(int i, int j){
        String res = "";
        while(i != 0){
            res = (char)(i % 26 + 'A') + res;
            i = i /26;
        }
        return res+j;
    }

    public int[] convert(String s){
        int i = 0;

        int[] res = new int[2];

        for(; i < s.length(); i++){
            if(!Character.isAlphabetic(s.charAt(i))){
                break;
            }

            res[0] = res[0] * 26 + (s.charAt(i) - 'A');
        }

        res[1] = Integer.valueOf(s.substring(i));

        return res;
    }


    public static void main(String[] args){

        CycleMatrix c = new CycleMatrix();

        String[][] matrix = {
                {"A1","A2","A3","A4","A5"},
                {"B1","B2","B3","B4","B5"},
                {"C1","C2","C3","C4","C5"},
                {"D1","DD2","D3","D4","D5"},
                {"E1","E2","E3","E43","E5"}};

        System.out.println(c.hasCycle(matrix));

        System.out.println(c.topologic(matrix));

    }
}


