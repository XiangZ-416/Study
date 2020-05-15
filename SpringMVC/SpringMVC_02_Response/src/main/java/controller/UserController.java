package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/13 18:02
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    // 响应数据与结果试图：返回值是String
    @RequestMapping(value = "/testString")
    public String testString(Model model) {
        System.out.println("testString方法执行了...");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(30);
        // 把user对象存储到model对象中，底层也会把user对象存入到request对象中
        model.addAttribute("user", user);

        // 使用视图解析器跳转到指定页面
        return "success";
    }

    // 响应数据与结果视图：返回值是Void
    // 请求转发：一次请求，不用编写项目的名称
    // 重定向：等于重新发了一个新的请求。需要写项目名称
    @RequestMapping(value = "/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了...");
        // 1.编写请求转发的程序(手动写转发就不会启用视图解析器，因此需要写视图的全路径)
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        // 2.重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        // 3.直接进行响应设置
        // 设置编码格式，解决中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("hello");

        return;
    }

    // 响应数据与结果视图：返回值是ModelAndView对象
    @RequestMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView方法执行了...");
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("小凤");
        user.setPassword("456");
        user.setAge(30);
        // 把user对象存储到mv对象中，底层也会把user对象存入到request对象中
        mv.addObject("user", user);

        // 跳转到指定页面
        mv.setViewName("success");

        return mv;
    }

    // 响应json数据之响应json格式数据
    // @ResponseBody User：将user对象转成json数据
    @RequestMapping(value = "/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        // 做响应
        return user;
    }
}
