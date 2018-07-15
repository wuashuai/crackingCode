package moderate;

/*Number Max: Write a method that finds the maximum of two numbers. You should not use if-else
or any other comparison operator.*/
public class NumberMax {

    public static int solve(int a, int b){
        int sign = ((a-b) >> 31) & 1;
        return a * (1 - sign) + sign * b;
    }

    public static void main(String[] args){
        System.out.println(solve(100, 500));
    }


}



