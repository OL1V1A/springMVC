package test;

import jodd.mail.*;
import org.junit.Test;

import javax.mail.internet.AddressException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    @Test
    public void testList(){
        List<String> list = new ArrayList<String>();
        List<String> list1= new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("3");

        list.stream().forEach(x -> {
            if (x.equals("3")){
//                list.remove(x);
                list1.add(x);
            }
        });
        list.removeAll(list1);

//        Iterator it = list.iterator();
//        while (it.hasNext()){
//            String value = (String) it.next();
//            if(value.equals("3")){
//                it.remove();
//            }
//
//        }
        System.out.println(list.toString());
    }

    @Test
    public void testMail() throws Exception {
        Email email = Email.create();
        email.from("foreverdnmy@163.com").to("754524103@qq.com");
        email.subject("主题测试");
        email.textMessage("看看text");
        email.htmlMessage("<html><META http-equiv=Content-Type content=\"text/html; charset=utf-8\"><body><h1>测试一下</h1></body></html>","utf-8");
        email.embeddedAttachment(EmailAttachment.with().content(new File("C:\\Users\\Lenovo\\Desktop\\招标\\招标公告.pdf")));
        SmtpServer server = MailServer.create().host("smtp.163.com").auth("foreverdnmy@163.com","lywyjy1314").buildSmtpMailServer();
        SendMailSession session = server.createSession();

        session.open();
        session.sendMail(email);
        session.close();
        System.out.println("========");
    }
}
