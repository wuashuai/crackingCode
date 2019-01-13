package interview.google;

public class CardGame {

    /*
    *拿纸牌游戏， 纸牌上面有值，比如说 100， 1， -1， 2， 200， 1.
    * 然后两个人轮流拿，直到拿完。 但是每次只能拿从左边数起的前三个，
    * 但是如果你要拿第三个，就必须前两个都拿了，你要拿第二个，
    * 就必须第一个也拿了，大家都最优策略，
    * 问最后第一个人能拿多少分。dfs 加 cache做了
    *
    *
    * */


    public static int solve(int[] array){

        int m = array.length;

        int[][] count = new int[m + 1][2];

        int[] sum = new int[m + 1];

        for(int i = m - 1; i >= 0; i--){
            sum[i] = sum[i + 1] + array[i];
        }

        for(int i = m-1; i >= 0; i--){

            count[i][0] = Integer.MIN_VALUE;
            count[i][1] = Integer.MIN_VALUE;

            for(int j = 1; j <= Math.min(m-i, 3); j++) {
                count[i][0] = Math.max(count[i][0], sum[i] - count[i + j][1]);
                count[i][1] = Math.max(count[i][1], sum[i] - count[i + j][0]);
            }
        }

        return count[0][0];
    }

    public static void main(String[] args){
        int[] array = {100,1, -1, 2,200,0};
        System.out.println(solve(array));


    }
}
