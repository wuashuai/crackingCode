package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ConcatenWord {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Node head = new Node();
        build(head, words);
        return find(head);
    }

    public void build(Node head, String[] words){
        for(String s : words){
            buildOne(head, s);
        }
    }

    public void buildOne(Node head, String word){
        char[] cs = word.toCharArray();

        for(char c : cs){
            if(head.children[c-'a'] == null){
                head.children[c-'a'] = new Node();
            }
            head = head.children[c-'a'];
        }
        head.word = word;
        head.isEnd = true;
    }

    public List<String> find(Node head){
        List<String> res = new ArrayList<>();
        dfs(head, head, head, res);
        return res;
    }

    public void dfs(Node one, Node compare, Node head, List<String> res){
        if(one.isEnd && compare.isEnd && !one.word.equals(compare.word)){
            res.add(one.word);
        }

        if(compare.isEnd) dfs(one, head, head, res);

        for(int i = 0; i < 26; i++){
            if(one.children[i] != null && compare.children[i] != null){
                dfs(one.children[i], compare.children[i], head, res);
            }
        }
    }

    public static void main(String[] args){
        ConcatenWord cw = new ConcatenWord();
        String[] input = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> res = cw.findAllConcatenatedWordsInADict(input);
        res.stream().forEach(x -> System.out.println(x));
    }

}

class Node{
    Node[] children;
    boolean isEnd;
    String word;

    Node(){
        isEnd = false;
        children = new Node[26];
    }
}