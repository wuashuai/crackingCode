package binarySearch;

public class SearchRange {
    public static int solve(int[] array, int target){
        int last = findLast(array, target);
        int first = findFirst(array, target);
        return last == -1 ? 0 : last - first + 1;
    }

    public static int findFirst(int[] array, int target){
        int start = 0;
        int end = array.length-1;

        while(start < end) {
            int mid = (start + end) / 2;

            if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return array[start] == target ? start : -1;
    }

    public static int findLast(int[] array, int target){
        int start = 0;
        int end = array.length-1;

        while(start < end) {
            int mid = (start + end + 1) / 2;

            if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return array[start] == target ? start : -1;
    }

    public static void main(String[] args){
       int[] a = {1,2,3,4,4,4,5,7,7,7,7,8};
       System.out.println(solve(a, 7));
       System.out.println(solve(a, 6));

       a = new int[]{100,106,110,1001};
       System.out.println(solve(a, 1110));
        System.out.println(solve(a, 110));

       a = new int[]{1,2,3,4,4,4,5,7,7,7,7,8};
       System.out.println(solve(a, 0));
    }
}
