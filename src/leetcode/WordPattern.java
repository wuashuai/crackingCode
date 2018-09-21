package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPatternMatch(String pattern, String str) {

        Map<String, Character> m1 = new HashMap<>();
        Map<Character, String> m2 = new HashMap<>();

        return helper(pattern, str, m1, m2);
    }

    public boolean helper(String pattern, String str, Map<String, Character> m1, Map<Character,String> m2){
        if(pattern.length() == 0 && str.length() == 0) return true;
        if(pattern.length() == 0 || str.length() == 0) return false;

        char c = pattern.charAt(0);
        String pNext = pattern.substring(1);

        if(m2.containsKey(c)){
            if(!str.startsWith(m2.get(c))) return false;
            return helper(pNext, str.substring(m2.get(c).length()), m1, m2);
        }

        char[] cs = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= cs.length - pattern.length(); i++){
            sb.append(cs[i]);
            String s = sb.toString();
            if(m1.containsKey(s)) continue;

            m1.put(s, c);
            m2.put(c, s);
            if(helper(pNext, sb.substring(i+1), m1, m2)) return true;
            m1.remove(s);
            m2.remove(c);
        }
        return false;
    }

    public static void main(String[] args){
        WordPattern wp = new WordPattern();
        wp.wordPatternMatch("abab", "redblueredblue");
    }
}


