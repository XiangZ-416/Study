package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: //TODO �Զ���������1
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/14 22:22
 */
public class MyInterceptor1 implements HandlerInterceptor {

    // Ԥ����Controller����ִ��ǰ��ִ�д˷���
    // true������
    // false�������У�������request��ת��ָ��ҳ�桢response�ض�������ҳ�棩
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object o) throws Exception {
        System.out.println("preHandle��Ԥ����...");
        // ����ת��������controller�еķ������������ָ��Ŀ����תҳ��
        // request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return false;
    }

    // ����controller�еķ���ִ�к�success.jspִ��ǰִ�д˷���
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle������...");
        // ����ת����Ԥ�������controller�еķ��������Ǻ�����Ըı�controller֮ǰָ������תҳ�棬��ת���µ�ҳ��error.jsp
        // request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    }

    // success.jspִ�к�ִ�д˷��������������ͷ���Դ
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion����������controller�ķ�����ִ�н���...");
    }
}
