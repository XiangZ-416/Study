package controller;

import exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/14 21:03
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/testException")
    public String testException() throws Exception {
        System.out.println("testException...");

        try {
            // ģ���쳣
            int a = 10/0;
        } catch (Exception e) {
            // �ڿ���̨��ӡ�쳣��Ϣ
            e.printStackTrace();
            // �׳��Զ����쳣��Ϣ
            throw new SysException("��ѯ�����û����ִ�����...");
        }

        return "success";
    }
}
