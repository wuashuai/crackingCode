package interview.quip;

public class MinWindowSum {

    public static int find(int[] array, int sum){

        int j = 0;
        int current = 0;

        if(array.length == 0 || sum == 0) return 0;

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++){

            current += array[i];

            while(current >= sum){
                res = Math.min(res, i - j + 1);
                current -= array[j++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args){

    }


}

