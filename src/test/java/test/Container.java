package test;

import org.junit.Test;
import javax.script.ScriptException;
import java.util.concurrent.*;

/**
 * @Auth: lwj
 * @Date: 2019/1/23 8:48
 */
public class Container {
    @Test
    public void testQueue() throws InterruptedException, ScriptException, ExecutionException {
        BlockingQueue<String> queue1 = new LinkedBlockingQueue<>();
        BlockingQueue<String> queue2 = new ArrayBlockingQueue<>(2000000);
        long st1 = System.currentTimeMillis();
        for (int i = 0; i<1000000;i++){
            queue1.add("a");
        }
        System.out.println(" LinkedBlockingQueue :" + (System.currentTimeMillis()-st1));
        long st2 = System.currentTimeMillis();
        for (int j=0;j<1000000;j++){
            queue2.add("a");
        }
        System.out.println(" ArrayBlockingQueue :" + (System.currentTimeMillis()-st2));
        long st3 = System.currentTimeMillis();
        queue1.forEach((q1) -> q1 = q1+"a");
        System.out.println(" LinkedBlockingQueue foreach :" + (System.currentTimeMillis()-st3));
        long st4 = System.currentTimeMillis();
        queue1.forEach((q2) -> q2 = q2+"a");
        System.out.println(" ArrayBlockingQueue foreach :" + (System.currentTimeMillis()-st4));
    }
}
