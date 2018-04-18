package recursion;

public class recursiveMultiply {
    public static void main(String[] args) {
        System.out.println(multiply(9,8));
        System.out.println(multiply(1001,9));
        System.out.println(multiply(8,9));
        
        System.out.println(multiply(1,8));
        
    }
    
    public static int multiply(int a, int b) {
        if(a == 0 || b == 0) return 0;
        
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        if((b & 1) == 1) {
            return a + multiply((a+a), (b >> 1));
        }else {
            return multiply((a+a), (b >> 1));
        }
    }
}
