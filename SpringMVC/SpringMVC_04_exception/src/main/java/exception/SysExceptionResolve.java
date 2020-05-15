package exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: //TODO 异常处理器
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/14 21:33
 */
public class SysExceptionResolve implements HandlerExceptionResolver {
    /**
     * @Description //TODO 处理异常业务逻辑
     * @Date 21:34 2020/5/14
     * @Param [httpServletRequest：请求, httpServletResponse：响应, handler：当前处理器, ex：当前抛出的异常对象]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object handler, Exception ex) {
        // 获取异常对象
        SysException e = null;
        if (ex instanceof SysException) {
            e = (SysException) ex;
        } else {
            e = new SysException("系统正在维护...");
        }

        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", e.getMessage()); // 获取自定义异常类的提示信息
        mv.setViewName("error"); // 设置异常跳转页面

        return mv;
    }
}
