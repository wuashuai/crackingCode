package math;

import java.util.Stack;

class Calculate {
    public static int calculate(String s) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int num = 0;
        char[] cs = s.toCharArray();

        for(int i = 0; i < cs.length; i++){

            if(cs[i] == ' ') continue;

            if(cs[i] <= '9' && cs[i] >= '0'){
                while(i < cs.length && cs[i] <= '9' && cs[i] >= '0'){
                    num = num * 10 + (cs[i] - '0');
                    i++;
                }

                values.push(num);
                num = 0;
            }


            if(i == cs.length) break;

            if(cs[i] == ')'){
                while(ops.peek() != '('){
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            }else if(cs[i] == '('){
                ops.push(cs[i]);
            }else if(cs[i] == '+' || cs[i] == '-' || cs[i] == '*' || cs[i] == '/'){
                while(!ops.isEmpty() && hasPrecedence(cs[i], ops.peek())){
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(cs[i]);
            }

        }
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    public static int applyOp(char op, int b, int a){
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static boolean hasPrecedence(char op1, char op2){
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static void main(String[] args)
    {
//        System.out.println(Calculate.calculate("1 + 1"));
//        System.out.println(Calculate.calculate("10 + 2 * 6"));
//        System.out.println(Calculate.calculate("100 * 2 + 12"));
        System.out.println(Calculate.calculate("100 * ( 2 + 12 )"));
        System.out.println(Calculate.calculate("100 * ( 2 + 12 ) / 14"));
    }
}
