package interview;

import java.util.*;

public class Solution {

    public static void main(String[] args){
        System.out.println(getPermutation(4,9));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> a = new ArrayList<>();
        int[] max = new int[n];

        for(int i = 0; i < n; i++){
            a.add(i+1);
            max[i] = i < 2 ? 1 : max[i-1] * i;
        }

        int count = n - 1;
        String res = "";
        k--;

        while(count >= 0 || a.size() != 0){

            System.out.println(k + "  " + max[count] + " " + res);

            int i = k / max[count];

            res += a.remove(i);

            k -= i * max[count];

            count--;
        }

        return res;
    }
}
