package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/5/14 21:03
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/testInterceptor")
    public String testInterceptor() {
        System.out.println("controller...");

        return "success";
    }
}
