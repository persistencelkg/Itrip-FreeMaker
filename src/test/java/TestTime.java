import org.junit.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    }
}
