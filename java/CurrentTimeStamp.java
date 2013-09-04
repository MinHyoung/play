import java.sql.Timestamp;

public class CurrentTimeStamp {
    public static void main(String[] args) {
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}
