package interview;

import com.sun.tools.internal.xjc.Driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UberDriver {

    public List<List<Double>> readData(String path){
        BufferedReader br = null;
        String line = "";
        String csvSpliter = ",";


        List<List<Double>> list = new ArrayList<>();

        try{
            br = new BufferedReader(new FileReader(path));
            line = br.readLine();

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] infos = line.split(csvSpliter);
                List<Double> info = Arrays.stream(infos).map(n -> Double.valueOf(n)).collect(Collectors.toList());

                list.add(info);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public List<Double> solve(String path1, String path2){
        List<List<Double>> drivers = readData(path1);
        List<List<Double>> riders = readData(path2);

        List<Integer> possible = new ArrayList<>();

        for(int i = 0; i < riders.size(); i++){
            if(riders.get(i).get(1) > 0.1){
                possible.add(i);
            }
        }

        for(int i : possible){

            for(int k = 0; k < drivers.size(); k++){

                double a = 0.0;
                double b = 0.0;

                for(int j = 0; j < riders.size() - i; j++){


                    if(j + k >= drivers.size()){
                        break;
                    }

                    a += riders.get(i + j).get(1);
                    b += drivers.get(k + j).get(1);
                }



                if(a != 0.0 && b != 0.0 && Math.abs(a - b) < 3){
                    System.out.println(a+ "  " + b + "  " + i + "   " + k);

                    if(Math.abs(riders.get(i).get(3) - drivers.get(k).get(3)) < 0.01
                            && Math.abs(riders.get(i).get(4) - drivers.get(k).get(4)) < 0.01){
                        return riders.get(i);
                    }

                }
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args){
        UberDriver ub = new UberDriver();
        String input1 = "/Users/tony/Documents/找工作/面经/uber/driverData.csv";
        String input2 = "/Users/tony/Documents/找工作/面经/uber/riderData.csv";
        ub.solve(input1, input2);
    }


}


