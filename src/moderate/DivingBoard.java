package moderate;

import java.util.HashSet;
import java.util.Set;

public class DivingBoard {

    public static void main(String[] args){

    }

    public Set<Integer> findAll(int sb, int lb, int k){

        Set<Integer> res = new HashSet<>();

        if(k == 0){
            return res;
        }

        for(int i = 0; i < k; i++){
            res.add(sb * i + k * lb - i * lb);
        }

        return res;

    }


}
