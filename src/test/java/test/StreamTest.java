package test;

import org.junit.Test;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void testStream1(){
        Stream.of("1","22","3333","4444","55555").forEach(System.out::println);
    }

    @Test
    public void testStream2(){
        Stream.of("1","22","3333","4444","55555").filter(x->x.length()>2).forEach(System.out::println);

    }
}
