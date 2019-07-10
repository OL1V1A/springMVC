package com.lwj.rpc.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import javax.imageio.ImageIO;
import java.io.*;
import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

/**
 * @Auth: lwj
 * @Date: 2019/6/25 10:36
 */
public class TestKryo {

    public static void main(String[] args) throws Exception {
//        Kryo kryo = new Kryo();
//        Output output = new Output(new FileOutputStream("student.txt"));
//        Student name = new Student("lwj");
//        kryo.writeClassAndObject(output,name);
//        output.close();
//
//        Input input = new Input(new FileInputStream("student.txt"));
//        Object name1 = kryo.readClassAndObject(input);
//        input.close();
//        if (name1 instanceof Student){
//            assert "lwj".equals(((Student)name1).getName());
//            System.out.println("111");
//        }else{
//            System.out.println("222");
//        }

        KryoSerializer kryoSerializer = new KryoSerializer();
        byte[] bytes = kryoSerializer.serialize(new Student("qwe", BigDecimal.valueOf(9.91)));
        Student s = kryoSerializer.deserialize(bytes);
        System.out.println(s.getName() + " | " + s.getMoney());

        HessianSerialization h = new HessianSerialization();
        byte[] bytesh = h.serialize(new Student("qwe", BigDecimal.valueOf(9.91)));
        Student student = h.deserialize(bytesh, Student.class);
        System.out.println(student.getName() + " | " + student.getMoney());
    }

}

class Student implements Serializable {
    private String name;

    private BigDecimal money;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, BigDecimal age) {
        this.name = name;
        this.money = age;
    }

    public Student() {

    }
}
