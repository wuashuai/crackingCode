package moderate;

public class MasterMind {

    public static void main(String[] args){


        String correct = "RGGB";
        String answer = "GGRR";

        int[] res = solve(answer, correct);

        System.out.println(res[0] + "   " + res[1]);

        correct = "RGBGY";
        answer = "GRRYG";

        res = solve(answer, correct);

        System.out.println(res[0] + "   " + res[1]);

    }


    public static int[] solve(String answer, String correct){


        if(answer.length() != correct.length()) return null;

        int n = answer.length();

        int count = 0;
        int[] nums = new int[4];

        for(int i = 0; i < n; i++){
            int a = getNumber(answer.charAt(i));
            int c = getNumber(correct.charAt(i));

            if(a == c) count++;

            nums[a]++;
            nums[c]--;
        }


        int[] res = new int[2];

        int diff = 0;

        for(int i = 0; i < 4; i++){

            if(nums[i] > 0)
                diff += nums[i];
        }

        res[0] = n - diff - count;
        res[1] = count;

        return res;
    }

    public static int getNumber(char c){
        switch (c){
            case 'G' : return 0;
            case 'B' : return 1;
            case 'Y' : return 2;
            case 'R' : return 3;
            default : return -1;
        }
    }



}
