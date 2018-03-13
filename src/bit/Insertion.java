package bit;


public class Insertion {
    
    public static void main(String[] args){
        int n = 1 << 10;
        int m = 19;

        System.out.println(convert(n, m , 2, 6));
    }

    public static int convert(int n, int m, int i, int j) {
        int mask = (1 << (j+1)) - (1 << i);
        n = n & (~mask);

        m = m << i;
        n = n + m;

        return n; 
    }

}