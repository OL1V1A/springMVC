package test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.junit.Test;

import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auth: lwj
 * @Date: 2018/12/5 15:52
 */
public class testJson {

    @Test
    public void test(){
        String str = "{\n" +
                "\t\"297ec9076777f49a0167780e9b830006\": [\"297ec9076777f49a0167780e9baa0008\", \"297ec9076777f49a0167780e9bbe0009\"],\n" +
                "\t\"297ec907677c0fef01677c17964f0005\": [\"297ec907677c0fef01677c17966d0007\", \"297ec907677c0fef01677c17967c0008\"]\n" +
                "}\n";

        Map<String, List<String>> map = (Map<String, List<String>>) JSONObject.parse(str);
        map.forEach((key,value)->{
            List<String> list = new ArrayList<>();
            value.stream().forEach((x)->list.add(x));
            System.out.println("key = "+key+";value = "+list);
        });
    }
}
