package moderate;

public class ContiguousSequence {


    public static void main(String[] args){
        System.out.println(find(new int[]{2, -8, 3, -2, 4, -10}));
    }

    public static int find(int[] input){
        int max = 0;
        int tmpMax = 0;

        for(int i : input){

            if(tmpMax > 0) {
                tmpMax += i;
                max = Math.max(tmpMax, max);
            }else {
                tmpMax = i;
            }
        }

        return max;
    }
}
