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
 * @Date:Create： 2020/5/7 21:40
 */
public class servletContext extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取servletContext对象
        ServletContext servletContext = getServletContext();

        // 1.获取全局配置参数
        String name = servletContext.getInitParameter("name");
        System.out.println("全局配置参数:"+name);

        // 2.获取Web工程文件
        // 创建属性对象
//        Properties properties = new Properties();
        // 指定输入的数据源
        /*
         * 被tomcat管理的Web工程的实际相对路径是tomcat里的bin目录
         * 而不是普通工程相对jre的路径
         * 因此想要获取被tomcat管理的Web工程下的资源不能使用FileInputStream
         **/
//        InputStream is = new FileInputStream("web.properties");
//        properties.load(is);
//        // 获取name属性的值
//        String property = properties.getProperty("name");
//        System.out.println("property:"+property);

        // a.获取给定文件在服务器上卖弄的绝对路径getRealPath()
        // 然后按照FileInputStream方式读取
        String realPath = servletContext.getRealPath("file/web.properties");
        // b.创建属性对象
        Properties properties = new Properties();
        // c.指定输入的数据源
        InputStream is = new FileInputStream(realPath);
        //或者直接使用InputStream Is = servletContext.getResourceAsStream("file/web.properties");
        properties.load(is);
        // d.获取name属性的值
        String property = properties.getProperty("name");
        System.out.println("property:"+property);
        // e.关流
        is.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
