package interview.quip;

import java.util.*;

public class LongestWordInDict {

    public int find(String start, Set<String> dict){
        Queue<String> queue = new LinkedList<>();

        queue.offer(start);

        int count = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                dfs(queue.poll(), dict, queue);
            }

            count++;
        }

        return count;
    }

    public void dfs(String s, Set<String> dict, Queue<String> queue){

        for(int i = 0; i <= s.length(); i++){
            String a = s.substring(0, i);
            String b = s.substring(i);

            for(char c = 'a'; c <= 'z'; c++){
                String tmp = a + c + b;
                if(dict.contains(tmp)){
                    queue.offer(tmp);
                    dict.remove(tmp);
                }
            }
        }

    }

    public static void main(String[] args){
        LongestWordInDict l = new LongestWordInDict();

        Set<String> set = new HashSet<String>(){
            {
                //add("chat");
                add("hat");
                add("chats");
                add("bat");

            }
        };

        System.out.println(l.find("at", set));
    }


}
