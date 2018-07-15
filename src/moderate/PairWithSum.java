package moderate;


/*Design an algorithm to find all pairs of integers within an array which sum to a
specified value.*/

import java.util.*;
import java.util.List;

public class PairWithSum {
    public static List<int[]> solve(List<Integer> integerList,  int sum){
        //assume it is unique

        List<int[]> res = new ArrayList<>();

        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < integerList.size(); i++) {
            if(map.contains(integerList.get(i))){
                res.add(new int[]{integerList.get(i), sum - integerList.get(i)});
            }
            map.add(sum - integerList.get(i));
        }

        return res;
    }

    public static void main(String[] args){
        List<Integer> list1 = new ArrayList<Integer>(){{
           add(3);
           add(4);
           add(5);
           add(6);
        }};
        List<int[]> res = PairWithSum.solve(list1, 8);
        res.forEach(i -> System.out.println(i[0] + "  " + i[1]));
    }

}
