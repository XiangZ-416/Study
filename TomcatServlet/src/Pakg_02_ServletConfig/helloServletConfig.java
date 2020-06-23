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
 * @Date:Create�� 2020/5/7 20:48
 */
public class helloServletConfig extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // �õ�servlet���ö���ר������������servlet��һЩ��Ϣ
        ServletConfig servletConfig = getServletConfig();

        // 1.�õ�servlet���ö�����servlet-name���ı�����
        String servletName = servletConfig.getServletName();
        System.out.println("servletName:"+servletName);

        // 2.���Ի�ȡ�����ĳһ������
        String address = servletConfig.getInitParameter("address");
        System.out.println("address:"+address);

        // 3.��ȡ���еĲ�������
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        // ����ȡ�����еĲ�������
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
