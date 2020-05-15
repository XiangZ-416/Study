package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @Description: //TODO ���õ�ע��
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/13 14:58
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) // ��msg=��������session����
public class AnnoController {

    // ����@RequestParamע�⣺��������һ��ʱ��ȡ������
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name") String username) {
        System.out.println("ִ����...");
        System.out.println("�û�����"+username);
        return "success";
    }

    // ����@RequestBodyע�⣺��ȡ������
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("ִ����...");
        System.out.println("�����壺"+body);
        return "success";
    }

    // ����@PathVariable��ӵ�а�url�е�ռλ���ġ����磺url����/delete/{id}��{id}����ռλ��
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(value = "sid") String id) {
        System.out.println("ִ����...");
        System.out.println("id��"+id);
        return "success";
    }

    // ����@RequestHeader����ȡָ������ͷ��Accept����ֵ
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {
        System.out.println("ִ����...");
        System.out.println("����ͷ��"+header);
        return "success";
    }

    // ����@CookieValue�����ڻ�ȡָ��cookie�����Ƶ�ֵ
    // ����value��cookie������
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println("ִ����...");
        System.out.println("JSESSIONID��"+cookieValue);
        return "success";
    }

    // ����@ModelAttribute
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "abc") User user) {
        System.out.println("testModelAttributeִ����...");
        System.out.println(user);
        return "success";
    }

//    // �÷�������ִ��
//    @ModelAttribute
//    public User showUser(String uname) {
//        System.out.println("showUserִ����...");
//        // ͨ���û�����ѯ���ݿ⣨ģ�⣩
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//
//        return user;
//    }

//    // �÷�������ִ��
//    @ModelAttribute
//    public void showUser(String uname, Map<String, User> map) {
//        System.out.println("showUserִ����...");
//        // ͨ���û�����ѯ���ݿ⣨ģ�⣩
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//        map.put("abc", user);
//    }

    // ����@SessionAttributes
    // ��msg=���� ����session��
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("testSessionAttributes...");
        model.addAttribute("msg", "����");
        return "success";
    }
    // ����@SessionAttributes
    // ��session����ȡֵ
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    // ����@SessionAttributes
    // ��session����ɾ��ֵ
    @RequestMapping("/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus sessionStatus) {
        System.out.println("deleteSessionAttributes...");
        sessionStatus.setComplete(); // ���session���е�ֵ
        return "success";
    }

}
