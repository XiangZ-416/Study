package controller;

import exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/14 21:03
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/testException")
    public String testException() throws Exception {
        System.out.println("testException...");

        try {
            // 模拟异常
            int a = 10/0;
        } catch (Exception e) {
            // 在控制台打印异常信息
            e.printStackTrace();
            // 抛出自定义异常信息
            throw new SysException("查询所有用户出现错误了...");
        }

        return "success";
    }
}
