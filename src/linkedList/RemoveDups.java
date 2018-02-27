package linkedList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RemoveDups {
    public static void main(String[] args) {
        RemoveDups rd = new RemoveDups();
        LinkedList<Integer> list = new LinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(3);
            add(4);
        }};
        rd.remove(list);
        
        for(Integer i : list) {
            System.out.println(i);
        }
        
    }
    
    //extra space
    public void remove(LinkedList<Integer> list) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < list.size(); i++) {
            if(set.contains(list.get(i))) {
                list.remove(i);
                i--;
            }
            set.add(list.get(i));
            
            //System.out.println(list.size());
        }
    }
}
