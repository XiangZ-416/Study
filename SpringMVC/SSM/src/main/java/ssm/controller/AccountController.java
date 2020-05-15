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
 * @Description: //TODO 表现层（Web层）：handler
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/15 17:40
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

    // 在Controller中注入业务层Service对象
    @Autowired
    private AccountService accountService;

    // 查询账户信息
    @RequestMapping(value = "/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有账户信息...");
        // 调用业务层service的方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    // 保存账户信息
    @RequestMapping(value = "/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll"); // 重定向到findAll页面
        return;
    }

}
