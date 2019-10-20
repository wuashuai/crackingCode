package moderate;

import java.util.*;

public class LivePeople {

    public static void main(String[] args){

        List<People> crowd = new ArrayList<People>(){{
           add(new People(1900, 1920));
           add(new People(1910, 1950));
           add(new People(1920, 1950));
           add(new People(1930, 1950));
        }};


        System.out.println(findMaxYear(crowd));


    }

    public static int findMaxYear(List<People> crowd){

        int[] years = new int[101];

        int max = 0;
        int res = -1;

        for(People p : crowd){
            for(int i = p.birth; i <= p.death; i++){
                years[i - 1900]++;
            }
        }

        for(int i = 0; i < 101; i++ ){
            if(years[i] > max){
                max = years[i];
                res = i + 1900;
            }
        }
        return res;
    }

}

class People{

    int birth;
    int death;

    People(int birth, int death){
        this.birth = birth;
        this.death = death;
    }
}
