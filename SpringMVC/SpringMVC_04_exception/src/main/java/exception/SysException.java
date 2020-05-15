package exception;

/**
 * @Description: //TODO 自定义异常类
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/14 21:29
 */
public class SysException extends Exception {

    // 存储提示信息
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
