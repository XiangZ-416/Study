package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @Description: //TODO 常用的注解
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/13 14:58
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) // 把msg=美美存入session域中
public class AnnoController {

    // 测试@RequestParam注解：参数名不一样时获取表单数据
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name") String username) {
        System.out.println("执行了...");
        System.out.println("用户名："+username);
        return "success";
    }

    // 测试@RequestBody注解：获取请求体
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("执行了...");
        System.out.println("请求体："+body);
        return "success";
    }

    // 测试@PathVariable：拥有绑定url中的占位符的。例如：url中有/delete/{id}，{id}就是占位符
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(value = "sid") String id) {
        System.out.println("执行了...");
        System.out.println("id："+id);
        return "success";
    }

    // 测试@RequestHeader：获取指定请求头（Accept）的值
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("执行了...");
        System.out.println("请求头："+header);
        return "success";
    }

    // 测试@CookieValue：用于获取指定cookie的名称的值
    // 属性value：cookie的名称
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("执行了...");
        System.out.println("JSESSIONID："+cookieValue);
        return "success";
    }

    // 测试@ModelAttribute
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "abc") User user) {
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }

//    // 该方法会先执行
//    @ModelAttribute
//    public User showUser(String uname) {
//        System.out.println("showUser执行了...");
//        // 通过用户名查询数据库（模拟）
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//
//        return user;
//    }

//    // 该方法会先执行
//    @ModelAttribute
//    public void showUser(String uname, Map<String, User> map) {
//        System.out.println("showUser执行了...");
//        // 通过用户名查询数据库（模拟）
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//        map.put("abc", user);
//    }

    // 测试@SessionAttributes
    // 将msg=美美 存入session域
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes...");
        model.addAttribute("msg", "美美");
        return "success";
    }
    // 测试@SessionAttributes
    // 从session域中取值
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    // 测试@SessionAttributes
    // 从session域中删除值
    @RequestMapping("/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus sessionStatus) {
        System.out.println("deleteSessionAttributes...");
        sessionStatus.setComplete(); // 清除session域中的值
        return "success";
    }

}
