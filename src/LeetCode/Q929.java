package LeetCode;

import java.util.HashSet;

/**
 * Created by alvin on 2020/03/17.
 */
public class Q929 {

    public static void main(String[] args) {
        String[] a = {"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"};
        System.out.println(numUniqueEmails(a));
    }

    public static int numUniqueEmails(String[] emails) {

        HashSet<String> result = new HashSet<>();

        for (String email : emails) {
            String[] tmp = email.split("@");
            String tmpLocalName = tmp[0].replace(".", "");
            String[] tmpLocal = tmpLocalName.split("\\+");

            result.add(tmpLocal[0] + "@" + tmp[1]);
        }


        return result.size();
    }
}
