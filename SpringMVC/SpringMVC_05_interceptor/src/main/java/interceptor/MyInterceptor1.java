package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: //TODO 自定义拦截器1
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/14 22:22
 */
public class MyInterceptor1 implements HandlerInterceptor {

    // 预处理：Controller方法执行前先执行此方法
    // true：放行
    // false：不放行（可以用request跳转到指定页面、response重定向到其他页面）
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object o) throws Exception {
        System.out.println("preHandle：预处理...");
        // 请求转发：拦截controller中的方法后可以重新指定目标跳转页面
        // request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return false;
    }

    // 后处理：controller中的方法执行后，success.jsp执行前执行此方法
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle：后处理...");
        // 请求转发：预处理放行controller中的方法，但是后处理可以改变controller之前指定的跳转页面，跳转到新的页面error.jsp
        // request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    }

    // success.jsp执行后执行此方法：可以用来释放资源
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion：拦截器和controller的方法都执行结束...");
    }
}
