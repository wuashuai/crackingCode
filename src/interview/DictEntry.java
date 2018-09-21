package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

interface DictEntry {
    public boolean isDict();
}

class Dict implements DictEntry {
    private Map<String, DictEntry> map;


    public Dict(Map<String, DictEntry> map) {
        this.map = map;
    }

    public boolean isDict() {
        return true;
    }

    public Set<String> getKeys() {
        return map.keySet();
    }

    public DictEntry get(String key) {
        return map.get(key);
    }
}

class StringWrapper implements DictEntry {
    private String str;

    public StringWrapper(String str) {
        this.str = str;
    }

    public boolean isDict() {
        return false;
    }

    public String getValue(){
        return str;
    }
}

class Test {
    public static void main(String[] args){
        Map<String, DictEntry> map = new HashMap<String, DictEntry>();
        map.put("a", new StringWrapper("apple"));
        map.put("b", new Dict(new HashMap<String, DictEntry>(){{put("b", new StringWrapper("blueberry"));}}));

        for(String s : map.keySet()){
            DictEntry d = map.get(s);

            if(d.isDict()){
                System.out.println(s + ":" + ((StringWrapper) ((Dict)d).get(s)).getValue());
            }else{
                System.out.println(s + ":" + ((StringWrapper) d).getValue());
            }
        }

    }



}
