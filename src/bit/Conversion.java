package bit;

public class Conversion {
    public static int getNum(int n, int m) {
        int v = n ^ m;
        
        int count = 0;
        while(v != 0) {
            count++;
            v = (v-1) & v;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(getNum(29, 15));
    }
    
}
