package recursion;

public class MagicNumber {
    public static void main(String[] args) {
        int[] test1 = {-10,1,2,4,6,9};
        int[] test2 = {0};
        int[] test3 = {-10, 1};
        int[] test4 = {-10, 0, 5};
        
        System.out.println(find(test1));
        System.out.println(find(test2));
        System.out.println(find(test3));
        System.out.println(find(test4));
        
    }
    
    public static int find(int[] value) {
        
        int start = 0;
        int end = value.length-1;
        
        while(start < end) {
            int mid = (end-start)/2 + start;
            
            if(value[mid] < mid) {
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        
        return value[end] == end ? end : -1;
    }
}
