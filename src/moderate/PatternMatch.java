package moderate;

import java.util.HashMap;
import java.util.Map;

public class PatternMatch {


    public static boolean findMatch(String word, String pattern){


        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();

        return helper(map, reverseMap, word, pattern);

    }

    public static boolean helper(Map<Character, String> map, Map<String, Character> reverseMap,
                                 String word, String pattern){

        if(word.length() == 0 && pattern.length() == 0) return true;
        if(word.length() == 0 || pattern.length() == 0) return false;

        char c = pattern.charAt(0);

        if(map.containsKey(c)){
            String s = map.get(c);
            if(word.startsWith(s)){
                return helper(map, reverseMap, word.substring(s.length()), pattern.substring(1));
            }

        }else{

            for(int i = 0; i <= word.length() - pattern.length(); i++){
                String s = word.substring(0, i+1);

                if(reverseMap.containsKey(s)) continue;

                map.put(c, s);
                reverseMap.put(s,c);

                if(helper(map, reverseMap, word.substring(s.length()), pattern.substring(1))) return true;


                map.remove(c);
                reverseMap.remove(s);
            }
        }

        return false;
    }


    public static void main(String[] args){

        String pattern = "aabb";
        String word = "abcdedabcdedabcdeabcde";
        System.out.println(findMatch(word, pattern));

        pattern = "aabb";
        word = "abcdedabcdedabcdeabcd";
        System.out.println(findMatch(word, pattern));

    }
}
