package moderate;


/*Given an arithmetic equation consisting of positive integers, +, -, * and / (no parentheses).
compute the result.
Input: 2*3+5/6*3+15
Output: 23.5
*/

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Calculator {

    static Set<Character> set = new HashSet<Character>(){{
        add('+');
        add('-');
        add('*');
        add('/');
    }};

    public static double solve(String s){

        if(s == null || s.trim().length() == 0) return -1.0;

        s = s.trim();

        Stack<Double> stack = new Stack<>();

        int preIndex = 0;
        char preOp = '+';

        for(int i = 0; i <= s.length(); i++){
            if(i == s.length() || set.contains(s.charAt(i))){
                if(i == preIndex){
                    return -1.0;
                }

                int preNumber = Integer.parseInt(s.substring(preIndex, i));

                if(preOp == '+'){
                    stack.push((double)preNumber);
                }else if(preOp == '-'){
                    stack.push((double)(-preNumber));
                }else if(preOp == '*'){
                    double p = stack.pop();
                    stack.push(p * ((double) preNumber));
                }else {
                    double p = stack.pop();
                    stack.push(p / ((double) preNumber));
                }
                if(i != s.length()){
                    preOp = s.charAt(i);
                    preIndex = i+1;
                }
            }

        }
        double res = 0.0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(solve("2*3+5/6*3+15"));
        System.out.println(solve("2+3-6+9*2/2"));
    }


}
