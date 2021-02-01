package LeetCode;

import java.util.ArrayList;

/**
 * Created by alvin on 2020/03/24.
 */
public class Q204 {

    public static void main(String[] args) {

        System.out.println(countPrimes(10000));

    }

    static public int countPrimes(int n) {

        int result = 0;
        ArrayList<Boolean> primeList;
        if (n <= 2) return 0;

        primeList = new ArrayList<Boolean>(n + 1);
        primeList.add(false);
        primeList.add(false);

        for (int i = 2; i <= n; i++)
            primeList.add(i, true);

        for (int i = 2; (i * i) <= n; i++) {
            if (primeList.get(i)) {
                for (int j = i * 2; j <= n; j += i) primeList.set(j, false);
                //i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
            }
        }
        for (Boolean aBoolean : primeList) {
            if (aBoolean) result++;
        }

        return result;
    }

//    static public int countPrimes(int n) {
//
//        int result = 0;
//
//        if (n <= 2) return 0;
//
//        for (int i = 2; i < n; i++) {
//            if (i == 2 || i == 3 || i == 5 || i == 7) result++;
//
//            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
//                System.out.println("ste>>>>>>>>>>: " + i);
//            } else {
//                System.out.println("ste: " + i);
//                result++;
//                System.out.println("result::" + result);
//            }
//        }
//
//        return result;
//    }

}
