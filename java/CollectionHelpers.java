import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public class CollectionHelpers {
    public static void main(String[] args) throws Exception {
        // List.toArray() - method that acts as a bridge between array-based and collection-based api
        List<String> strList = Lists.newArrayList("a", "ab", "abc", "abcd", "abcde", "abcdef");
        String[] strArray1 = strList.toArray(new String[10]);
        String[] strArray2 = strList.toArray(new String[0]);
        System.out.println(strArray1.length);
        System.out.println(strArray2.length);

        System.out.println();
        System.out.println("strArray1:");
        for (String s : strArray1) {
            System.out.println(s);
        }

        System.out.println();
        System.out.println("strArray2:");
        for (String s : strArray2) {
            System.out.println(s);
        }

        // Arrays.asList() - creates a fixed sized list backed by the specified array
        System.out.println();
        List<String> strList1 = Arrays.asList(strArray1);
        List<String> strList2 = Arrays.asList(strArray2);
        System.out.println(strList1.size());
        System.out.println(strList2.size());
        strArray1[0] = "xyz";
        System.out.println();
        System.out.println("strList1:");
        for (String s : strList1) {
            System.out.println(s);
        }

        List<String> strList3 = Arrays.asList("alice", "bob", "eve");
        System.out.println();
        for (String s : strList3) {
            System.out.println(s);
        }
    }
}
