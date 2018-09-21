package leetcode;

public class ReverseBit {

    public int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++){
            res = res << 1 + ((n >>> 1) & 1);
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args){
        ReverseBit rb = new ReverseBit();

        rb.reverseBits(43261596);
    }
}
