package Pakg_01_Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Description: //TODO servlet通用写法
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/7 17:12
 */
public class helloServlet02 extends HttpServlet {

    // get请求会来这个方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    // post请求回来这个方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
