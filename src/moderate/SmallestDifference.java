package moderate;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestDifference {

    /*
    Smallest Difference: Given two arrays of integers,
    compute the pair of values (one value in each array) with the smallest (non-negative) difference.
    Return the difference.
    EXAMPLE
    Input: {1, 3, 15, 11, 2}, {23, 127, 235, 19, 8} Output: 3. That is, the pair (11 , 8).
    */

    public static int[] solve(List<Integer> input1, List<Integer> input2){

        int i, j, m, n;
        i = j = 0;
        m = input1.size();
        n = input2.size();
        int[] res = new int[2];
        int diff = Integer.MAX_VALUE;

        Collections.sort(input1);
        Collections.sort(input2);

        while(i < m && j < n){
            if(Math.abs(input1.get(i) - input2.get(j)) < diff){
                res[0] = input1.get(i);
                res[1] = input2.get(j);
                diff = Math.abs(input1.get(i) - input2.get(j));
            }
            if(input1.get(i) < input2.get(j)){
                i++;
            }else{
                j++;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[] a = {1, 3, 15, 11, 2};
        int[] b = {23, 127, 235, 19, 8};

        int[] res = solve(Arrays.stream(a).boxed().collect(Collectors.toList()), Arrays.stream(b).boxed().collect(Collectors.toList()));
        System.out.println(res[0] + " " + res[1]);
    }
}
