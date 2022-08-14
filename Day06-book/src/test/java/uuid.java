import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class uuid {
    public static void main(String[] args) {
//        UUID leastSignificantBits = UUID.randomUUID();
//        System.out.println(leastSignificantBits);

        Date date = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simple.format(date);
        System.out.println(format);
    }
}
