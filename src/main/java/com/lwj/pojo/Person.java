package com.lwj.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Auth: lwj
 * @Date: 2019/1/22 8:35
 */
@Data
public class Person implements Serializable {
    @NotNull(message = "id不能为空")
    private Long id;
    private String name;
}

class Widget{
    public synchronized void dot(){
        System.out.println("parent dot()");
    }
}
class pWidget extends Widget{
    public synchronized void dot(){
        System.out.println("child dot()");
        super.dot();
    }

    public static void main(String[] args) {
        pWidget p = new pWidget();
        p.dot();
    }
}
