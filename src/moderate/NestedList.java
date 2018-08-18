package moderate;

import java.util.ArrayList;
import java.util.List;

public class NestedList {
    int res;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        res = 0;
        helper(nestedList);
        return res;
    }

    public int helper(List<NestedInteger> nestedList){
        int val = 0;
        int level = 0;
        for(NestedInteger nestedInteger : nestedList){
            if(nestedInteger.isInteger()){
                val += nestedInteger.getInteger();
            }else{
                level = Math.max(level, helper(nestedInteger.getList()));
            }
        }
        res += ((level + 1) * val);
        System.out.println(res + " " + level);
        return level + 1;
    }

    public static void main(String[] args){
        NestedInteger a = new NestedInteger();
        NestedInteger b = new NestedInteger();
        NestedInteger c = new NestedInteger(-1);
        NestedInteger d = new NestedInteger();
        NestedInteger e = new NestedInteger();
        NestedInteger f = new NestedInteger(-5);
        NestedInteger g = new NestedInteger();
        b.add(c);
        a.add(b);
        d.add(e);
        e.add(f);
        a.add(d);

        g.add(a);

        NestedList nl = new NestedList();

        System.out.println(nl.depthSumInverse(g.getList()));
    }
}

class NestedInteger{

    List<NestedInteger> list;
    Integer val;
    boolean isInteger;

    public NestedInteger(){
        list = new ArrayList<>();
        isInteger = false;
    }
    public NestedInteger(int value){
        val = value;
        isInteger = true;
    }
    public boolean isInteger(){
        return isInteger;
    }
    public Integer getInteger(){
        return val;
    }
    public void setInteger(int value){
        val = value;
    }
    public void add(NestedInteger ni){
        list.add(ni);
    }
    public List<NestedInteger> getList(){
        return list;
    }
}