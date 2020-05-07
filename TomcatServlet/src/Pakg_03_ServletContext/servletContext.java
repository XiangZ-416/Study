package Pakg_03_ServletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/7 21:40
 */
public class servletContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ��ȡservletContext����
        ServletContext servletContext = getServletContext();

        // 1.��ȡȫ�����ò���
        String name = servletContext.getInitParameter("name");
        System.out.println("ȫ�����ò���:"+name);

        // 2.��ȡWeb�����ļ�
        // �������Զ���
//        Properties properties = new Properties();
        // ָ�����������Դ
        /*
         * ��tomcat�����Web���̵�ʵ�����·����tomcat���binĿ¼
         * ��������ͨ�������jre��·��
         * �����Ҫ��ȡ��tomcat�����Web�����µ���Դ����ʹ��FileInputStream
         **/
//        InputStream is = new FileInputStream("web.properties");
//        properties.load(is);
//        // ��ȡname���Ե�ֵ
//        String property = properties.getProperty("name");
//        System.out.println("property:"+property);

        // a.��ȡ�����ļ��ڷ���������Ū�ľ���·��getRealPath()
        // Ȼ����FileInputStream��ʽ��ȡ
        String realPath = servletContext.getRealPath("file/web.properties");
        // b.�������Զ���
        Properties properties = new Properties();
        // c.ָ�����������Դ
        InputStream is = new FileInputStream(realPath);
        //����ֱ��ʹ��InputStream Is = servletContext.getResourceAsStream("file/web.properties");
        properties.load(is);
        // d.��ȡname���Ե�ֵ
        String property = properties.getProperty("name");
        System.out.println("property:"+property);
        // e.����
        is.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
