package interview;

import java.util.*;

public class phoneNumber {

    String[] map = {"" , "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    Map<String, Set<String>> dict = new HashMap<>();


    public static void main(String[] args){

        phoneNumber pn = new phoneNumber();
        Set<String> set = new HashSet<String>(){{
            add("drop");
            add("box");
        }};

        String input = "3767269";

        List<List<String>> res = pn.find(input, set);
        Set<String> res1 = pn.find1(input, set);
        res.stream().forEach(x -> x.stream().forEach(y -> System.out.println(y)));
        res1.stream().forEach(x -> System.out.println(x));
    }

    public List<List<String>> find(String input, Set<String> set){

        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        helper(input, "", res, list, set);

        return res;
    }

    public void helper(String input, String str, List<List<String>> res, List<String> list, Set<String> set){
        if(input.length() == 0){
            if(str.length() == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        String s = map[input.charAt(0) - '0'];

        for(char c : s.toCharArray()){
            String newInput = input.substring(1);
            String newStr = str + c;
            if(set.contains(newStr)){
                list.add(newStr);
                helper(newInput, "", res, list, set);
                list.remove(list.size() - 1);
            }
            helper(newInput, newStr, res, list, set);
        }
    }


    public Set<String> find1(String input, Set<String> set){

        return findHelper(input, "", set);
    }

    public Set<String> findHelper(String input, String str, Set<String> set){

        Set<String> res = new HashSet<>();

        if(str.length() == 0 || set.contains(str)){
            if(input.length() == 0){
                res.add(str);
                return res;
            }
            if(dict.containsKey(input)) return dict.get(input);
        }

        if(input.length() == 0) return new HashSet<>();

        String s = map[input.charAt(0) - '0'];
        for(char c : s.toCharArray()) {
            String newInput = input.substring(1);
            String newStr = str + c;
            if (set.contains(newStr)) {
                Set<String>  next = findHelper(newInput, "", set);

                for (String l : next) {
                    res.add(newStr + l);
                }
                dict.put(newInput, next);

            }
            findHelper(newInput, newStr, set);
        }


        return res;
    }
}
