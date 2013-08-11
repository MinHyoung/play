import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * URL (Uniform Resource Locator) Encoding and Decoding
 *
 * Reference:
 * - http://blog.lunatech.com/2009/02/03/what-every-web-developer-must-know-about-url-encoding
 * - http://illegalargumentexception.blogspot.com/2009/12/java-safe-character-handling-and-url.html
 *
 * Terminology:
 *  - URI
 *  - URL
 *  - URN
 * Components of a URL:
 *  Scheme
 *  User
 *  Password
 *  Host Address (Domain Name)
 *  Port
 *  Path (Path Segment)
 *  Path Parameters
 *  Query Parameters
 *  Fragment
 *
 *  Scheme and Host part are separated by "://"
 *  Host and path fragments are separated by "/"
 *  Path parameters are located at the end of the path segment after a ";", and
 *  separated from other path parameters by a ";" character
 *  Query parameters are located at the end of path part after a "?", and separated
 *  from other parameters by a "&" character
 *
 * Common Encodings
 *  "?"  - %3F
 *  " "  - %20 or "+"
 *  "+"  - %2B
 *  "/"  - %2F
 *  "&"  - %26
 *
 * Takeaways:
 *  - Reserved characters are different for each part.
 *  - Don't analyze a URL after decoding
 *  - Decoded URLs cannot be re-encoded to the same form
 *  - Don't use java.net.URLEncoder or java.net.URLDecoder for whole URLs. They only escape/un-escape
 *    'application/x-www-form-urlencoded' (form-data) data, but won't parse parameters
 *  - Don't construct URLs without encoding each part
 *  - Don't expect URI.getPath() to give you structured data; Use URI.getRawPath() instead
 *
 *  Dependencies:
 *  jsr311-api.jar
 */
public class URLCodec {

    public static void urlEncoderAndDecoderTest(String oStr) throws Exception {
        String eStr; // encoded string
        String dStr; // decoded string
        eStr = URLEncoder.encode(oStr, "UTF-8");
        dStr = URLDecoder.decode(eStr, "UTF-8");
        System.out.printf("oStr = '%s'\n", oStr);
        System.out.printf("eStr = '%s'\n", eStr);
        System.out.printf("dStr = '%s'\n", dStr);
        System.out.printf("--\n");
    }

    public static void main(String[] args) throws Exception {
        /**
         * Do not use java.net.URLEncoder or java.net.URLDecoder for whole
         * URLs. At the best you can use URLEncoder and URLDecoder for
         * encoding and decoding only the query part
         */
        String[] query = new String[]{
                "blue+light blue",
                "a/b?c",
                "a&b==c",
                "[* TO 2000]",
                ":",
                "+",
                "title:\"The Right Way\" AND text:go",
        };

        for (String q : query) {
            urlEncoderAndDecoderTest(q);
        }

    }
}
