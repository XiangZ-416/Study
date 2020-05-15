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
 * @Date:Create�� 2020/5/13 18:02
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    // ��Ӧ����������ͼ������ֵ��String
    @RequestMapping(value = "/testString")
    public String testString(Model model) {
        System.out.println("testString����ִ����...");
        // ģ������ݿ��в�ѯ��User����
        User user = new User();
        user.setUsername("����");
        user.setPassword("123");
        user.setAge(30);
        // ��user����洢��model�����У��ײ�Ҳ���user������뵽request������
        model.addAttribute("user", user);

        // ʹ����ͼ��������ת��ָ��ҳ��
        return "success";
    }

    // ��Ӧ����������ͼ������ֵ��Void
    // ����ת����һ�����󣬲��ñ�д��Ŀ������
    // �ض��򣺵������·���һ���µ�������Ҫд��Ŀ����
    @RequestMapping(value = "/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid����ִ����...");
        // 1.��д����ת���ĳ���(�ֶ�дת���Ͳ���������ͼ�������������Ҫд��ͼ��ȫ·��)
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        // 2.�ض���
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        // 3.ֱ�ӽ�����Ӧ����
        // ���ñ����ʽ�������������
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("hello");

        return;
    }

    // ��Ӧ����������ͼ������ֵ��ModelAndView����
    @RequestMapping(value = "/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView����ִ����...");
        // ����ModelAndView����
        ModelAndView mv = new ModelAndView();
        // ģ������ݿ��в�ѯ��User����
        User user = new User();
        user.setUsername("С��");
        user.setPassword("456");
        user.setAge(30);
        // ��user����洢��mv�����У��ײ�Ҳ���user������뵽request������
        mv.addObject("user", user);

        // ��ת��ָ��ҳ��
        mv.setViewName("success");

        return mv;
    }

    // ��Ӧjson����֮��Ӧjson��ʽ����
    // @ResponseBody User����user����ת��json����
    @RequestMapping(value = "/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax����ִ����...");
        // �ͻ��˷���ajax�����󣬴�����json�ַ�������˰�json�ַ�����װ��user����
        System.out.println(user);
        // ����Ӧ��ģ���ѯ���ݿ�
        user.setUsername("haha");
        user.setAge(40);
        // ����Ӧ
        return user;
    }
}
