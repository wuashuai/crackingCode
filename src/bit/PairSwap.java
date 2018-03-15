package bit;


//Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as
//possible (e.g., bit 13 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).


public class PairSwap {
    public static int swap(int v) {
        return ( (v & 0xaaaaaaaa) >>> 1 ) | ( (v & 0x55555555) << 1 );
    }
    
    public static void main(String[] args) {
        System.out.println(swap(0xaaaaaaaa));
    }
}
