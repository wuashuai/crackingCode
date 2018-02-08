package arrayStrings;


//String Compression: Implement a method to perform basic string compression using the counts
//of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
//"compressed" string would not become smaller than the original string, your method should return
//the original string. You can assume the string has only uppercase and lowercase letters (a - z).
//

public class StringCompression {
    public String compress(String input) {
        if(input == null || input.length() == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        
        int j = 0;
        
        for(int i = 0; i <= input.length(); i++) {
            if(i == input.length() || input.charAt(i) != input.charAt(j)) {
                sb.append(input.charAt(j));
                sb.append((i-j));
                j = i;
            }
            
        }
        
        return sb.length()  < input.length() ? sb.toString() : input; 
    }
    
    
    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        
        System.out.println(sc.compress("aabcccccaaa"));
        
        System.out.println(sc.compress("abcde"));
        
    }
}
