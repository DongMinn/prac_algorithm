//package scope;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
//public class Q2 {
//
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        int roomSize = Integer.parseInt(input);
//
//        int[][] array = new int[roomSize+1][roomSize+1];
//
//        for (int i = 1; i < roomSize+1; i++) {
//            String tmpValue = br.readLine();
//            for (int j = 1; j < roomSize+1; j++) {
//                array[i][j] = tmpValue.charAt(j);
//            }
//        }
//
//
//        int total = 0;
//        Map<String, Integer> resultMap = new HashMap<>();
//
//        for (int productSize = 1; productSize <= roomSize; productSize++) {
//            int tmpValue = resultValue(array, productSize);
//            total +=tmpValue;
//
//
//
////            for (int counting = 0; counting < (roomSize - productSize + 1) * (roomSize - productSize + 1); counting++)
////                if (productSize * productSize == sumValue(array, counting, productSize)) {
////                    total += 1;
////                    tmpValue += 1;
////                }
//            if (tmpValue != 0) {
//                resultMap.put(String.valueOf(productSize), tmpValue);
//            }
//        }
//
//        System.out.println("total: " + total);
//        for (String key : resultMap.keySet()) {
//            System.out.println("size[" + key + "]:" + resultMap.get(key));
//        }
//    }
//
//    private static int resultValue(int [][] array, int productSize){
//        int result = 0;
//        int size = array[0].length;
//
//        for(int i =0; i<size; i++){
//
//        }
//
//
//    }
//
//    private static int sumValue(int[][] array, int counting, int productSize) {
//
//        int sumValue = 0;
//        int size = array[0].length;
//
//
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//
//
//
//            }
//        }
//
//        return sumValue;
//    }
//
//}
