package leetcode;

import java.util.*;

class NextCloest {
    public String nextClosestTime(String time) {

        Set<Integer> set = new TreeSet<>();

        int input = 0;

        for(char c : time.toCharArray()){
            if(c != ':') {
                set.add(c-'0');
                input = input * 10 + (c -'0');
            }
        }

        List<Integer> list = new ArrayList<>(set);

        List<Integer> res = new ArrayList<>();

        helper(list, 0, res, 0);

        int index = Collections.binarySearch(res, input);

        int value = res.get((index + 1) % res.size());

        return compose(value);

    }

    public String compose(int value){

        int first = value / 100;
        int second = value % 100;

        String f = first < 10 ? "0" + first : "" + first;
        String s = second < 10 ? "0" + second : "" + second;

        return f + ":" + s;
    }

    public void helper(List<Integer> list, int index, List<Integer> res, int num){

        if(index == 4){

            if(isValid(num)) res.add(num);
            return;
        }

        for(int i = 0; i < list.size(); i++){
            helper(list, index+1, res, num * 10 + list.get(i));
        }

    }

    public boolean isValid(int num){
        if(num / 100 > 23) return false;
        if(num % 100 > 59) return false;
        return true;
    }


    public static void main(String[] args){
        NextCloest n = new NextCloest();

        n.nextClosestTime("19:34");
    }
}