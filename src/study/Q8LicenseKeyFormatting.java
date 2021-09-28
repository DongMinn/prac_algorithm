package study;

public class Q8LicenseKeyFormatting {
    public static void main(String[] args) {
//        String S = "5F3Z-2e-9-w";
		String S = "2-5g-3-J";
        int k = 4;
        System.out.println(licenseKeyFormatting(S, k));
      //  System.out.println(mySolve(S, k));
    }

//틀린 풀이
    public static String mySolve(String S, int K){
        String tmpStr = S.replace("-","").toUpperCase();

        StringBuilder sb = new StringBuilder(tmpStr);

        return sb.substring(0, sb.toString().length()-K) + "-" + sb.substring(sb.toString().length()-K);

    }

    public static String licenseKeyFormatting(String S, int K) {

        String S1 = S.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(S1);

        int len = sb.toString().length();
        for (int i = K; i < len; i = i + K) {
            sb.insert(len - i, '-');
        }
        return sb.toString();
    }
}
