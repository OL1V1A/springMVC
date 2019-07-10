package test;

import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestLambda {
    @Test
    public void test5() {
        Stream.generate(() -> (int) (Math.random() * 100)).limit(20).forEach(System.out::println);
    }


    //Predicate<T> 断言型接口
    @Test
    public void test4() {
        List<String> arr = Arrays.asList("q", "qw", "qwe", "qwer", "qwert");
        List<String> ll = app(arr, (s) -> s.length() > 3);
        ll.forEach(System.out::println);

    }

    private List<String> app(List<String> list, Predicate<String> predicate) {
        List<String> list1 = new ArrayList<>();
        for (String l : list) {
            if (predicate.test(l)) {
                list1.add(l);
            }
        }
        return list1;
    }

    //Function<T,R> 函数式接口
    @Test
    public void test3() {
        int num = getStrNum("asdwerwetwerwqetqrtew", s -> s.length());
        System.out.println(num);
    }

    @SuppressWarnings("SameParameterValue")
    private int getStrNum(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    //Supplier 供给型接口
    @Test
    public void test2() {
        List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
        list.forEach(System.out::println);
        Random r = new Random();
        r.nextInt();
//        for(Integer aa : list2){
//            System.out.println(aa);
//        }
    }

    @SuppressWarnings("SameParameterValue")
    private List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer a = supplier.get();
            list.add(a);
        }
        return list;
    }

    //Consumer 消费型接口
    @Test
    public void test1() {
        ap(100, (x -> System.out.println("这个数是" + x)));
    }

    @SuppressWarnings("SameParameterValue")
    private void ap(int x, Consumer<Integer> consumer) {
        consumer.accept(x);
    }

    @Test
    public void getCal() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(4));
        System.out.println(File.separator);
    }
}
