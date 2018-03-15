package bit;

//Next Number: Given a positive integer, print the next smallest and the next largest number that
//have the same number of 1 bits in their binary representation.





public class NextNumber {
    public static int[] solve(int v) {
        int[] res = new int[2];
        
        res[0] = getNextMax(v);
        res[1] = getNextMin(v);

        return res;
    }
    
    public static void main(String[] args) {
        
        int n = 16;
        
        int[] res = solve(13948);
        int[] res1 = solve(10115);
        
        
        System.out.println( res[0] + "   " + res[1]);
        System.out.println( res1[0] + "   " + res1[1]);
        
    }
    
    public static int getNextMax(int v) {
        int c = v;
        int c0 = 0;
        int c1 = 0;
        
        while(((c & 1) == 0) && c != 0 ) {
            c0++;
            c >>= 1;
        }
        
        while((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        
        if((c0 + c1) == 31 || (c0 + c1) == 0) return -1;
        
        int p = c0 + c1;
        
        int mask = ~ ((1 << p) - 1);
        
        v = v & mask;
        
        v = v + (1 << (c1-1)) - 1 + (1 << p) ;
        
        return v;
    }
    
    public static int getNextMin(int v) {
        int c = v;
        int c0 = 0;
        int c1 = 0;
        
        while(((c & 1) == 1) && c != 0 ) {
            c0++;
            c >>= 1;
        }
        
        while((c & 1) == 0) {
            c1++;
            c >>= 1;
        }
        
        if((c0 + c1) == 31 || (c0 + c1) == 0) return -1;
        
        int p = c0 + c1;
        
        int mask = ~ ((1 << p) - 1);
        
        v = v & mask;
        
        System.out.println(v);
        
        v = v + (((1 << (c0+1)) - 1) << (c1 - 1)) - (1 << p);
        
        return v;
       
    }
}
