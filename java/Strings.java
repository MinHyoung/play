import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

public class Strings {

    public static void main(String[] args) throws Exception {
        String x = "hello";
        String y = new String("hello");
        String[] xs = new String[]{"hello"};

        boolean result = "hello".startsWith("");
        System.out.println(result);

        // regionMatches
        String a = "abcdefgh";
        String b = "AB";
        int minLen = Math.min(a.length(), b.length());
        System.out.println(a.regionMatches(true, 0, b, 0, minLen));
        System.out.println(a.regionMatches(true, 0, b, 0, 0));

        System.out.println("---");

        // split
        String[] words = "     hello world   !!".split("\\s+");
        System.out.println(words.length);
        for (String word : words) {
            System.out.printf("'%s'", word);
        }
        System.out.println();

        System.out.println("---");

        // split - default implementation ignores the trailing separator
        String[] wordsWithCommas = ",a,,b,".split(",");
        System.out.println(wordsWithCommas.length);
        for (String word : wordsWithCommas) {
            System.out.printf("'%s'", word);
        }
        System.out.println();

        System.out.println("---");

        // Splitter that omits empty strings and trims them
        Iterable<String> strIterable = Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .split(",  a,,b,");
        for (String word : strIterable) {
            System.out.printf("'%s'", word);
        }
        System.out.println();

        System.out.println("---");

        // Joiner that omits null and empty strings
        List<String> strList = new ArrayList<>();
        strList.add("");
        strList.add("hello");
        strList.add(null);
        strList.add("world");
        String str = Joiner.on(", ")
                .skipNulls()
                .join(Iterables.filter(strList, new Predicate<String>() {
                    @Override
                    public boolean apply(java.lang.String s) {
                        return s != null && !s.isEmpty();
                    }
                }));
        System.out.println(str);
    }
}
