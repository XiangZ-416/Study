package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/12 14:38
 */
@Controller
public class HelloController {

    // RequestMapping注解的作用是建立请求URL和处理方法之间的对应关系
    @RequestMapping(value = "/hello", params = {"username=hana"})
    public String sayHello() {
        System.out.println("Hello SpringMVC!!");
        return "success";
    }

}
