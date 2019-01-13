package interview.google;

import java.util.*;

class CalcEquation {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        Map<String, Money> map = new HashMap<>();

        if(queries.length == 0) return new double[0];

        for(int i = 0; i < equations.length; i++){
            String[] equation = equations[i];
            double rate = values[i];

            Money top0 = find(equation[0], map);
            Money top1 = find(equation[1], map);

            if(top0.b.equals(top1.b)) continue;

            union(top0, top1, rate, map);
        }

        double[] res = new double[queries.length];

        for(int i = 0; i < queries.length; i++){
            res[i] = query(queries[i][0], queries[i][1], map);
        }
        return res;
    }

    public Money find(String child, Map<String, Money> map){
        if(!map.containsKey(child) || child.equals(map.get(child).b)){
            Money m = new Money(child, child, 1.0);
            map.put(child, m);
            return m;
        }
        Money c = map.get(child);

        Money m = find(c.b, map);
        Money res = new Money(child, m.b, c.rate * m.rate);

        map.put(child, res);
        return res;
    }

    public void union(Money m0, Money m1, double rate, Map<String, Money> map){

        Money f = new Money(m0.b, m1.b, rate * m1.rate / m0.rate);

        map.put(m0.b, f);
    }

    public double query(String a, String b, Map<String, Money> map ){

        if(!map.containsKey(a) || !map.containsKey(b)) {
            return -1.0;
        }

        Money top0 = find(a, map);
        Money top1 = find(b, map);

        if(!top0.b.equals(top1.b)) return -1.0;

        return top0.rate / top1.rate;
    }

    public static void main(String[] args) {

        CalcEquation c = new CalcEquation();

        String[][] equations = {{"a","b"},{"b","c"}};
        double[]  values = {2.0,3.0};
        String[][] queries = {{"a","c"},{"b","c"},{"a","e"},{"a","a"},{"x","x"}};


        c.calcEquation(equations, values, queries);
    }
}

class Money{
    String a;
    String b;
    double rate;

    Money(String a, String b, double rate){
        this.a = a;
        this.b = b;
        this.rate = rate;
    }
}