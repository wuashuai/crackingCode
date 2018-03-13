package bit;


//Binary to String: Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
//the binary representation. If the number cannot be represented accurately in binary with at most 32
//characters, print "ERROR:'
public class BinaryToString {
    public static String convert(double v) {
        
        int i = 32;
        String res = ".";
        
        while(i > 0) {
            double r = v * 2;
            
            if(r >= 1) {
                res += 1;
                v = r - 1;
                
            }else {
                res += 0;
            }
            
            System.out.println(res + "   " +  v + "   " + i);
            
           
            i--;
            
            if(v == 0) {
                break;
            }
        }
        
        if(v != 0) return "error";
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(convert(0.72));
        //System.out.println(convert(0.33));
        //System.out.println(convert(0.25));
    }
}
