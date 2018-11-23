package test;

import bean.MyTestBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
public class TestBean {


    @Test
    public void testBean(){
//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext-test.xml"));
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-test.xml");
        MyTestBean mt = (MyTestBean) ac.getBean("beanstr");
        Assert.assertEquals("beanstr",mt.getBeanstr());
    }
}
