package moderate;

public class SubSort {
    public static void main(String[] args){

        int[] input = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};

        int[] res = find(input);

        System.out.println(res[0] + "   "  + res[1]);

        int[] input2 = {9,8,7,6,5,6,1,3,2,1};

        res = find(input2);

        System.out.println(res[0] + "   "  + res[1]);
    }

    public static int[] find(int[] input){
        int left = -1;

        int right = input.length;

        for(int i = 0; i < input.length-1; i++){
            if(input[i] > input[i+1]){
                left = i;
                break;
            }
        }

        for(int i = input.length - 1; i > 0; i--){
            if(input[i] < input[i-1]){
                right = i;
                break;
            }
        }

        if(left == -1){
            return new int[]{-1,-1};
        }

        int min = input[left];
        int max = input[left];

        for(int i = left; i <= right; i++){
            min = Math.min(min, input[i]);
            max = Math.max(max, input[i]);
        }

        int[] res = new int[2];

        for(int i = 0; i < left; i++){
            if(input[i] > min){
                res[0] = i;
                break;
            }
        }

        for(int i = input.length - 1; i > 0; i--){
            if(input[i] < max){
                res[1] = i;
                break;
            }
        }

        return res;
    }

}
