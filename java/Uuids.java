import java.util.Locale;
import java.util.UUID;

/**
 * UUID class to create an immutable universally unique identifier (UUID)
 * represented by a 128-bit value
 */
public class Uuids {

    public static void main(String[] args) throws Exception {
        String uuid;
        uuid = UUID.randomUUID().toString().toLowerCase(Locale.ROOT);
        System.out.println(uuid);
        System.out.println(UUID.fromString(uuid));
    }

}
