package ssm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssm.service.AccountService;

/**
 * @Description: //TODO 测试Spring框架
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/15 18:08
 */
public class testSpring {

    @Test
    public void run1() {
        // 加载spring配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 获取service对象
        AccountService as = (AccountService) ac.getBean("accountService");
        // 调用方法
        as.findAll();
    }

}
