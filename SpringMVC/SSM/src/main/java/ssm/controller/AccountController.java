package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.domain.Account;
import ssm.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description: //TODO ���ֲ㣨Web�㣩��handler
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/15 17:40
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

    // ��Controller��ע��ҵ���Service����
    @Autowired
    private AccountService accountService;

    // ��ѯ�˻���Ϣ
    @RequestMapping(value = "/findAll")
    public String findAll(Model model) {
        System.out.println("���ֲ㣺��ѯ�����˻���Ϣ...");
        // ����ҵ���service�ķ���
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    // �����˻���Ϣ
    @RequestMapping(value = "/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll"); // �ض���findAllҳ��
        return;
    }

}
