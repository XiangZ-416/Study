package controller;

import domain.Account;
import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description: //TODO ���������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/12 21:10
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    // �������������
    @RequestMapping("/testParam")
    public String testParam(String username, int password) {
        System.out.println("ִ����...");
        System.out.println("�û���:"+username);
        System.out.println("����:"+password);
        return "success";
    }

    // ��������󶨰����ݷ�װ��JavaBean�С�JavaBean�а�����������
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("ִ����...");
        System.out.println(account);
        return "success";
    }

    // ��������󶨣��Զ�������ת����
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println("ִ����...");
        System.out.println(user);
        return "success";
    }

    // ��ȡԭ����servlet����
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ִ����...");
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }

}
