import com.google.common.base.Joiner;
import com.google.common.base.Predicate;

import java.util.ArrayList;
import java.util.List;

public class StringTest {
    public static void main(String[] args) throws Exception {
        boolean result = "hello".startsWith("");
        System.out.println(result);

        String[] words = "     hello world   !!".split("\\s+");
        System.out.println(words.length);
        for (String word : words) {
            System.out.println(word);
        }

        System.out.println("---");

        String a = "abcdefgh";
        String b = "AB";
        int minLen = Math.min(a.length(), b.length());
        System.out.println(a.regionMatches(true, 0, b, 0, minLen));

        System.out.println("---");

        System.out.println(a.regionMatches(true, 0, b, 0, 0));

        List<String> l = new ArrayList<>();
        l.add("");
        l.add("hello");
        l.add(null);
        l.add("world");
        Predicate<String> isEmpty = new Predicate<String>() {
            @Override
            public boolean apply(String str) {
                return str != null && str.isEmpty();
            }
        };
        System.out.println(Joiner.on(",").skipNulls().join(l));
    }
}
