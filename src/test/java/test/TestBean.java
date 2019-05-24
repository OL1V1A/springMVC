package test;

import bean.MyTestBean;
import com.hazelcast.util.function.Supplier;
import com.lwj.aop.ConfigOfAop;
import com.lwj.aop.Div;
import com.lwj.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

public class TestBean {


    @Test
    public void testBean(){
//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext-test.xml"));
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        MyTestBean mt = (MyTestBean) ac.getBean("beanstr");
        Assert.assertEquals("beanstr",mt.getBeanstr());
    }

    @Test
    public void testaop(){
        AnnotationConfigApplicationContext aa = new AnnotationConfigApplicationContext(ConfigOfAop.class);
        Div div = (Div) aa.getBean("div");
        div.div(1,1);
//        Supplier<String> supplier = ()-> {if(2>1) return "0";return "1";};
        Supplier<User> supplier = User::new;
        User user1 = supplier.get();
        User user2 = supplier.get();
        System.out.println(user1 == user2);
//        System.out.println(supplier.get());
//        System.out.println(supplier.get());
    }

    @Test
    public void double1(){

        double a=2;
        double b=1.1;
        System.out.println(new BigDecimal(Double.toString(a)).subtract(new BigDecimal(Double.toString(b))));

    }

    @Test
    public void cmd() {
        Process p =null;
        Runtime runtime = Runtime.getRuntime();
        try {
            p = runtime.exec("cmd /c start gpedit.msc");
            Thread.sleep(10000);
            p.destroy();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
