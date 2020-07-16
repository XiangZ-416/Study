# 一、Thread中的Interrupt方法
    void interrupt() ：中断线程
    boolean interrupted() ：测试当前线程是否已经中断
    
# 二、优雅的结束线程
    方法1：通过定义flag关闭线程，并设置修改flag的方法，关闭时调用修改flag的方法就可以关闭
    方法2：如t.interrupt()，在t需要关闭的逻辑中写break