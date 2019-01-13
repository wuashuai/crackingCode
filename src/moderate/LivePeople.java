package moderate;

import java.util.*;

public class LivePeople {

    public static void main(String[] args){




    }

    public int findMaxYear(List<People> crowd){
        Collections.sort(crowd, new Comparator<People>(){
            public int compare(People p1, People p2){
                return p1.birth - p2.birth;
            }
        });

        for(int ){

        }
    }





}

class People{


    int birth;
    int death;

    People(){}




}
