package com.lwj.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
    private Date date;
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
