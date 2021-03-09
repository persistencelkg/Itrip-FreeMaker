import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @description:
 * @author: 浮~沉
 * @create: 2020-10-13 16:09
 */
public class TestTime {


    /**
     *
     */
    @Test
    public void testLocaleTime(){
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDateTime.now(Clock.systemUTC()));
        Map<String, String> map = System.getenv();
        //map.forEach((k,v)->System.out.println(k + "-" + v));
        String userName = map.get("USER");
        System.out.println(userName);


        TestTime a1 = new TestTime();
        TestTime a2 = new TestTime();
        System.out.println(a1.equals(a2));

        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println(osName);
        System.out.println(this.getClass().getClassLoader().getResource("ftl").getPath());

    }

}
