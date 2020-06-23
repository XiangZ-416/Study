package Pakg_02_ServletConfig;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/7 20:48
 */
public class helloServletConfig extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 得到servlet配置对象，专门用于在配置servlet的一些信息
        ServletConfig servletConfig = getServletConfig();

        // 1.得到servlet配置对象里servlet-name的文本内容
        String servletName = servletConfig.getServletName();
        System.out.println("servletName:"+servletName);

        // 2.可以获取具体的某一个参数
        String address = servletConfig.getInitParameter("address");
        System.out.println("address:"+address);

        // 3.获取所有的参数名称
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        // 遍历取出所有的参数名称
//        Iterator<String> iterator = initParameterNames.asIterator();
//        while (iterator.hasNext()) {
//            String key = initParameterNames.nextElement();
//            String initParameter = servletConfig.getInitParameter(key);
//            System.out.println("initParameter:"+initParameter);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
