package moderate;


/*Operations: Write methods to implement the multiply, subtract, and divide operations for integers.
The results of all of these are integers. Use only the add operator.*/
public class Operations {

    public int minus(int a , int b){
        return a + getNegetive(b);
    }

    public int getNegetive(int a){
        int sign = a < 0 ? 1 : -1;
        int res = 0;
        while(a != 0){
            a += sign;
            res += sign;
        }

        return res;
    }

    public int multiple(int a, int b){

        int sign = b < 0 ? 1 : -1;
        int res = 0;

        while(b != 0){
            res += a;
            b += sign;
        }

        if(sign == 1) res = getNegetive(res);

        return res;
    }

    public int divide(int a, int b){
        if(b == 0) return 0;

        if(a == 0 || b == 1) return a;

        int sign  = -1;

        if((a > 0)^(b > 0)) a = getNegetive(a);
        else  sign = 1;

        int res = 0;
        int count = 0;

        while(true){

            if((res >= a) ^ (res + b >= a)){
                break;
            }

            res += b;
            count++;
        }

        return sign == 1 ? count : getNegetive(count);

    }

    public static void main(String[] args){

        Operations op = new Operations();

        System.out.println(op.minus(5,6));
        System.out.println(op.minus(7,6));
        System.out.println(op.minus(-7,-6));
        System.out.println(op.minus(-5,-6));
        System.out.println(op.minus(-7,6));
        System.out.println(op.minus(7,-6));

        System.out.println();

        System.out.println(op.multiple(3,5));
        System.out.println(op.multiple(-3,5));
        System.out.println(op.multiple(-3,-5));
        System.out.println(op.multiple(-3,0));
        System.out.println(op.multiple(0,-3));

        System.out.println();

        System.out.println(op.divide(0,1));
        System.out.println(op.divide(6,2));
        System.out.println(op.divide(6,-1));
        System.out.println(op.divide(6,13));
        System.out.println(op.divide(6,-13));

    }

}
