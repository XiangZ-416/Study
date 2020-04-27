package Pakg_03_SpringJDBC.Num_02_TransactionManagement;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/23 23:13
 */
public class BookStockException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BookStockException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BookStockException(String message, Throwable cause,
                              boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public BookStockException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public BookStockException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}
