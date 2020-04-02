package cn.itcast.controller;


import com.sun.xml.internal.bind.v2.runtime.output.Encoded;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping( "/param")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParam(String username,String password,String money){
        System.out.println("testParam方法执行了");
        System.out.println("用户名"+username);
        System.out.println("密码"+password);
       // System.out.println("金钱"+money);
        return "success";
    }


    @RequestMapping("/TestRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("testParam方法执行了");

            System.out.println(body);
        return "success";
    }
}
