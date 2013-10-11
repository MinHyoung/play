import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.collect.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Guava {
    private static void p(String format, Object... args) {
        System.out.printf(format + "\n", args);
    }

    public static void main(String[] args) throws Exception {
        // Splitter that omits empty strings and trims them
        Iterable<String> words1 = Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .split(",  a,,b,");
        for (String word : words1) {
            p("'%s'", word);
        }

        p("---");

        // Joiner that omits null and empty strings
        List<String> words2 = Lists.newArrayList("", "hello", null, "world");
        String str = Joiner.on(", ")
                .skipNulls()
                .join(Iterables.filter(words2, new Predicate<String>() {
                    @Override
                    public boolean apply(final String word) {
                        return word != null && !word.isEmpty();
                    }
                }));
        p(str);

        p("---");

        // Trim more than on white space between and around words
        Iterable<String> words3 = Splitter.on(CharMatcher.BREAKING_WHITESPACE)
                .trimResults()
                .omitEmptyStrings()
                .split(" hello          world  ");
        for (String word : words3) {
            p("'%s'", word);
        }

        p("---");

        // Character Matcherc
        String out;
        // retain only digits
        out = CharMatcher.DIGIT.retainFrom("hello123world");
        p("'%s'", out);
        // trim whitespace at ends, and replace/collapse whitespace into single space
        out = CharMatcher.WHITESPACE.trimAndCollapseFrom("   hello         world ", ' ');
        p("'%s'", out);
        // star out all digits
        out = CharMatcher.JAVA_DIGIT.replaceFrom("hello123world", "*");
        p("'%s'", out);
        // eliminate all characters that aren't digits or lowercase
        out = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("Hello123World!");
        p("'%s'", out);

        p("---");

        // Case Format
        out = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "CONSTANT_NAME");
        p("'%s'", out);

        p("---");

        // transform
        List<Integer> intList = Lists.transform(ImmutableList.of("hello", "world", "!"), new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        });
        p("%s", Joiner.on(", ").join(intList));

        p("---");

        // Stopwatch
        Stopwatch stopwatch = Stopwatch.createStarted();
        p("%d", stopwatch.elapsed(TimeUnit.MICROSECONDS));
        stopwatch.stop();

        p("---");

        // Throwables
        try {
            try {
                try {
                    throw new RuntimeException("innermost exception");
                } catch (Exception e) {
                    throw new RuntimeException("middle exception", e);
                }
            } catch (Exception e) {
                throw new IllegalStateException("outermost exception", e);
            }
        } catch (Exception e) {
            p("rootcause = '%s'", Throwables.getRootCause(e));
            p("%s", Joiner.on(" <- ").join(Lists.transform(Throwables.getCausalChain(e), new Function<Throwable, String>() {
                @Override
                public String apply(Throwable throwable) {
                    return throwable.getMessage();
                }
            })));
            p("%s", Throwables.getStackTraceAsString(e));
        }

        p("---");

        // Forwarding Collection
        Collection<Integer> intCollection = new ForwardingCollection<Integer>() {
            private List<Integer> delegate = Lists.newArrayList();

            @Override
            protected Collection<Integer> delegate() {
                return delegate;
            }

            @Override
            public boolean add(Integer element) {
                if (element == null) {
                    return delegate.add(element);
                }
                if (element == 0) {
                    return delegate.add(0);
                }
                return delegate.add(-element) && delegate.add(element);
            }

            @Override
            public boolean addAll(Collection<? extends Integer> elements) {
                if (elements == null) {
                    return add(null);
                }
                boolean result = true;
                for (Integer element : elements) {
                    result = result && add(element);
                }
                return result;
            }
        };

        intCollection.add(2);
        intCollection.add(0);
        intCollection.add(4);

        p("%s", Joiner.on(", ").join(intCollection));

        p("---");

        // Iterables
        List<Integer> numList = ImmutableList.of(1, 2, 3, 0, -1, -2, -3);
        Number[] numbers;
        numbers = Iterables.toArray(numList, Number.class);
        p("%s", Joiner.on(", ").join(numbers));
        numbers = numList.toArray(new Number[]{});
        p("%s", Joiner.on(", ").join(numbers));

        p("---");

        // List<String> -> Map<Integer, String>
        Map<String, String> strMap1 = Maps.uniqueIndex(ImmutableList.of("foo", "bar", "foobar"), new Function<String, String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        });
        p("%s", Joiner.on(", ").withKeyValueSeparator(" -> ").join(strMap1));

        Map<String, String> strMap2 = Maps.asMap(ImmutableSet.of("foo", "bar", "foobar"), new Function<String, String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        });
        p("%s", Joiner.on(", ").withKeyValueSeparator(" -> ").join(strMap2));

        p("---");

        // List<String> -> Multimaps<String, String>
        Multimap<String, String> strMultimap1 = Multimaps.index(ImmutableList.of("foo", "bar", "foobar", "foobar"), new Function<String, String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        });
        p("%s", Joiner.on(", ").withKeyValueSeparator(" -> ").join(strMultimap1.asMap()));

        p("---");

        // Empty Immutable Collections
        p("%s", ImmutableList.of());
        p("%s", ImmutableSet.of());
        p("%s", ImmutableSortedSet.of());
        p("%s", ImmutableMultiset.of());
        p("%s", ImmutableSortedMultiset.of());
        p("%s", ImmutableMap.of());
        p("%s", ImmutableSortedMap.of());
        p("%s", ImmutableMultimap.of());
        p("%s", ImmutableListMultimap.of());
        p("%s", ImmutableSetMultimap.of());

        p("---");

        // Ordering
        Ordering<String> caseless = Ordering.from(String.CASE_INSENSITIVE_ORDER);
        List<String> sortedCopy = caseless.sortedCopy(ImmutableSet.of("foo", "bar", "foobar", "barfoo"));
        p("%s", Joiner.on(", ").join(sortedCopy));

        p("---");
    }

}

