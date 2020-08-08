## 一、Thread中的Interrupt方法
   void interrupt() ：中断线程
   
   boolean interrupted() ：测试当前线程是否已经中断
    
   线程中断：设置线程中断不影响线程的继续执行，但是线程设置中断后，线程内调用了wait、join、sleep方法中的一种， 立马抛出一个 InterruptedException，且中断标志被清除，重新设置为false。
    
## 二、优雅的结束线程
   方法1：通过定义布尔类型的flag关闭线程，并设置修改flag的方法，关闭时调用修改flag的方法就可以关闭
   
   方法2：在run方法中使用interrupted()判断线程是否中断，若中断则break当前run方法。
    
## 三、suspend()、resume()、stop()为什么不建议使用？
   suspend()：调用suspend()后，线程不会释放已经占有的资源（如锁），而是占有着资源进入睡眠状态，**很容易发生死锁**问题。
   
   stop()：该方法在终结一个线程时，不会保证资源正常释放，通常是没有给予线程完成资源释放的机会，因此**会导致程序可能工作在不确定状态**下。