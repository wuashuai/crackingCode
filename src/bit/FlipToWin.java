package bit;


//Flip Bit to Win: You have an integer and you can flip exactly one bit from a 13 to a 1. Write code to
//find the length of the longest sequence of ls you could create.
//EXAMPLE
//Input: 1775 (or: 1110111101111)
//Output: 8

public class FlipToWin {

    public static void main(String[] args) {
        int a = 1775;
        
        int b = 1024;
        
        System.out.println(convert(a));
        System.out.println(convert(b));
        
        
    }
    
    public static int convert(int val) {
        
        int pre = 0;
        int max = 0;
        int cur = 0;
        
        while(val != 0) {
            
            if((val & 1) == 1) {
                cur++;
                max = Math.max(max, cur + 1 + pre);
            }else {
                max = Math.max(max, cur + 1 + pre);
                pre = cur;
                cur = 0;
            }
            val = val >> 1;
        }
        return max;
    }
    
}
