package interview.quip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodNumber {

    public static void main(String[] args){


        long value = (long)Integer.MAX_VALUE + (long)100;

        System.out.println(value);

        List<int[]> res = find(100);

        res.stream().forEach(x -> System.out.println(x[0] + " " + x[1] +  " " + x[2] +  " " + x[3]));

    }


    public static List<int[]> find(int max){
        Map<Long, int[]> map = new HashMap<>();

        List<int[]> res = new ArrayList<>();

        for(int i = 1; i <= max; i++){

            for(int j = max; j > i; j--){

                long key = (long)(i*i*i) + (long) (j*j*j);

                if(map.containsKey(key)){
                    int[] validres = new int[4];

                    validres[0] = map.get(key)[0];
                    validres[1] = map.get(key)[1];
                    validres[2] = i;
                    validres[3] = j;

                    res.add(validres);
                }

                map.put(key, new int[]{i, j});
            }

        }

        return res;
    }
}
