package exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: //TODO �쳣������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/14 21:33
 */
public class SysExceptionResolve implements HandlerExceptionResolver {
    /**
     * @Description //TODO �����쳣ҵ���߼�
     * @Date 21:34 2020/5/14
     * @Param [httpServletRequest������, httpServletResponse����Ӧ, handler����ǰ������, ex����ǰ�׳����쳣����]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object handler, Exception ex) {
        // ��ȡ�쳣����
        SysException e = null;
        if (ex instanceof SysException) {
            e = (SysException) ex;
        } else {
            e = new SysException("ϵͳ����ά��...");
        }

        // ����ModelAndView����
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", e.getMessage()); // ��ȡ�Զ����쳣�����ʾ��Ϣ
        mv.setViewName("error"); // �����쳣��תҳ��

        return mv;
    }
}
