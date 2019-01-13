package interview.quip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ReadData {

    Map<String, Set<String>> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    public static void main(String[] args){
        ReadData r = new ReadData();
        r.initialize();


        System.out.println(r.read("Aar").size());
        System.out.println(r.read("Aaren"));
        System.out.println(r.read("线"));
        System.out.println(r.read("显示"));
    }

    public void initialize(){
        readFile();
    }

    public Set<String> read(String s){
        String tmp = s.toLowerCase();

        return map.get(tmp);
    }



    public void readFile() {
        File file = new File("/Users/tony/Desktop/quip/words.txt");

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));

            String st;

            while ((st = br.readLine()) != null){

                if(set.contains(st)) continue;

                set.add(st);

                String s = "";

                for(char c : st.toCharArray()){

                    s += Character.toLowerCase(c);

                    if(!map.containsKey(s)){
                        map.put(s, new HashSet<>());
                    }
                    map.get(s).add(st);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
