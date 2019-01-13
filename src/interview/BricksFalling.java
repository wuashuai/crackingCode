package interview;

public class BricksFalling {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public int[] hitBricks(int[][] grid, int[][] hits) {

        int c = hits.length;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = m-1; i >= 0; i--){
            for(int j = n -1; j >= 0; j--){


            }
        }

        int[] res = new int[c];

        for(int i = 0; i < c; i++){
            int x = hits[i][0];
            int y = hits[i][1];

            if(grid[x][y] != 0){

                boolean[][] visited = new boolean[m][n];

                boolean valid = checkAll(grid, x, y, visited);

                System.out.println();

                grid[x][y] = 0;

                if(!valid) continue;

                visited = new boolean[m][n];

                if(!checkAll(grid, x+1, y, visited)) res[i] += remove(visited, grid);

                System.out.println();

                visited = new boolean[m][n];

                if(!checkAll(grid, x, y+1, visited)) res[i] += remove(visited, grid);

            }
        }

        return res;
    }

    public boolean check(int[][] grid, int x, int y){
        if(x == 0 || y == 0) return true;

        if(grid[x-1][y] == 1 && check(grid, x-1, y)) return true;
        if(grid[x][y-1] == 1 && check(grid, x, y-1)) return true;

        return false;
    }

    public boolean checkAll(int[][] grid, int x, int y, boolean[][] visited){

        if(x == 0 || y == 0) return true;

        System.out.println(x + "  " + y);

        if(x == grid.length || y == grid[0].length || grid[x][y] == 0 || visited[x][y]){
            return false;
        }

        visited[x][y] = true;

        for(int[] dir : dirs){
            int a = x - dir[0];
            int b = y - dir[1];

            if(checkAll(grid, a, b, visited)) return true;
        }

        return false;
    }

    public int remove(boolean[][] visited, int[][] grid){

        int count = 0;

        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[0].length; j++){
                if(visited[i][j]){
                    grid[i][j] = 0;
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args){
        BricksFalling bf = new BricksFalling();

        int[][] grid = {{0,0,0,1},{0,1,1,1},{0,1,0,0}};
        int[][] hits = {{1,1}};

        bf.hitBricks(grid, hits);

    }
}
