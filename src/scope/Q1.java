package scope;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Q1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.equals("1")) {
            System.out.println(br.readLine());
        } else {

            List<Integer> timeMinValue = new ArrayList<>();
            List<Integer> timeMaxValue = new ArrayList<>();


            for (int i = 0; i < Integer.parseInt(input); i++) {

                String[] tmpValue = br.readLine().split(" ~ ");

                String[] tmpMinValue = tmpValue[0].split(":");
                String[] tmpMaxValue = tmpValue[1].split(":");

                timeMinValue.add(Integer.parseInt(tmpMinValue[0] + tmpMinValue[1]));
                timeMaxValue.add(Integer.parseInt(tmpMaxValue[0] + tmpMaxValue[1]));
            }

            int maxValue = timeMinValue.stream().mapToInt(x -> x).max().orElseThrow(NoSuchElementException::new);
            int minValue = timeMaxValue.stream().mapToInt(x -> x).min().orElseThrow(NoSuchElementException::new);


            if (maxValue >= minValue)
                System.out.println("-1");
            else {

                String result;

                String strMax;
                String strMin;
                if(maxValue <100){
                    strMax = "00"+ maxValue;
                }
                else if(maxValue<1000){
                    strMax = "0"+ maxValue;
                }else{
                    strMax = String.valueOf(maxValue);
                }
                if(minValue <100){
                    strMin = "00"+minValue;
                }
                else if(minValue<1000){
                    strMin = "0"+minValue;
                }else{
                    strMin = String.valueOf(minValue);
                }

                StringBuilder maxSb = new StringBuilder(strMax);
                maxSb.insert(2, ":");

                StringBuilder minSb = new StringBuilder(strMin);
                minSb.insert(2, ":");

                result = maxSb.toString() + " ~ " + minSb.toString();
                System.out.println(result);
            }

        }
    }





}
