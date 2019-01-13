package interview.google;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        if(position.length == 0) return 0;

        int n = position.length;

        double[][] cars = new double[n][2];

        for(int i = 0; i < n; i++){
            cars[i][0] = (double) position[i];
            cars[i][1] = (double) speed[i];
        }

        int count = n;

        Arrays.sort(cars, new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                if(a[0] == b[0]){
                    return a[1] > b[1] ?  -1 : 1;
                }
                return a[0] > b[0] ?  1 : -1;
            }
        });

        for(int i = n - 1; i > 0; i++){
            if(cars[i-1][1] <= cars[i][1]) continue;

            double time1 = (target - cars[i][0]) / cars[i][1];
            double time2 = (target - cars[i-1][0]) / cars[i-1][1];

            if(time1 >= time2){
                count--;
                cars[i-1][0] = cars[i][0] - (cars[i][0] - cars[i-1][0]) / (cars[i-1][1] - cars[i][1]) * cars[i][1];
                cars[i-1][1] = cars[i][1];
            }
        }

        return count;
    }
}
