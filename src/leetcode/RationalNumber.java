package leetcode;

public class RationalNumber {

    public boolean isRationalEqual(String S, String T) {

        if(!S.contains(".")) S = S + ".0";
        if(!T.contains(".")) T = T + ".0";

        String[] ss = S.split("[.]");
        String[] tt = T.split("[.]");

        if(ss[1] == null || ss[1].length() == 0) ss[1] = "0";
        if(tt[1] == null || tt[1].length() == 0) tt[1] = "0";

        long s0 = Long.valueOf(ss[0]);
        long t0 = Long.valueOf(tt[0]);

        int add = check(ss[1]);

        while(add > 0){
            if(ss[1].charAt(add - 1) == '9'){
                add--;
                ss[1] = ss[1].substring(0, add - 1) + '0' + ss[1].substring(add);
            }else{
                ss[1] = ss[1].substring(0, add - 1) + (ss[1].charAt(add - 1) + 1) + ss[1].substring(add);
                add = 0;
            }
        }

        if(add != -1){
            s0++;
            ss[1] = "0";
        }


        add = check(tt[1]);

        while(add > 0){
            if(tt[1].charAt(add - 1) == '9'){
                add--;
                tt[1] = tt[1].substring(0, add - 1) + '0' + tt[1].substring(add);
            }else{
                tt[1] = tt[1].substring(0, add - 1) + (tt[1].charAt(add - 1) + 1) + tt[1].substring(add);
                add = 0;
            }
        }

        if(add != -1){
            t0++;
            tt[1] = "0";
        }

        if(s0 != t0) return false;

        return compare(ss[1], tt[1]);

    }

    public int check(String a){

        int add = -1;

        for(int i = 0; i < a.length(); i++){

            if(a.charAt(i) == '(') add = i;
            if(a.charAt(i) == ')') continue;

            if(add != -1 && a.charAt(i) != '9') return -1;

        }

        return add;
    }

    public boolean compare(String s, String t){

        if(s.equals(t)) return true;

        int index = s.indexOf('(');

        String a, b, c, d;
        a = b = c = d = "";

        if(index != -1){
            a = s.substring(0, index);
            b = s.substring(index + 1, s.length() - 1);
        }else {
            a = s;
            b = "0";
        }

        index = t.indexOf('(');

        if(index != -1){
            c = t.substring(0, index);
            d = t.substring(index + 1, t.length() - 1);
        }else {
            c = t;
            d = "0";
        }

        int i = 0;

        while(i < s.length() + t.length()){
            char x = i < a.length() ? a.charAt(i) : b.charAt((i - a.length()) % b.length());
            char y = i < c.length() ? c.charAt(i) : d.charAt((i - c.length()) % d.length());

            if(x != y) return false;

            i++;

        }

        return true;
    }

    public static void main(String[] args){

        RationalNumber rationalNumber = new RationalNumber();

        System.out.println(rationalNumber.isRationalEqual("0.8(9)","0.9"));

    }
}