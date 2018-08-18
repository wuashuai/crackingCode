package moderate;

/*Rand7 from RandS: Implement a method rand7() given rand5 ().
That is, given a method that generates a random number between 0 and 4 (inclusive),
write a method that generates a random number between 0 and 6 (inclusive).*/

import java.util.Random;

public class RandomNumber {

    Random r = new Random();

    public int rand7(){
        while(true){
            int num = 5 * rand5() + rand5();
            if(num < 21){
                return num % 7;
            }
        }
    }

    public int rand5(){
        int res = r.nextInt(5);
        return res;
    }

    public static void main(String[] args){
        RandomNumber rn = new RandomNumber();

        for(int i = 0; i < 100; i++) {
            System.out.println(rn.rand7());
        }

        int[] res = new int[7];

        for(int i = 0; i < 10000000; i++){
            res[rn.rand7()]++;
        }

        for(int i = 0; i < 7; i++){
            System.out.println(i + "  "  + res[i]);
        }
    }

}
