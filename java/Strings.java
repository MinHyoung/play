public class Strings {

    public static void main(String[] args) throws Exception {
        // string & string array
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

    }
}
