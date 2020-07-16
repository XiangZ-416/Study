# Thread的join方法及案例

## 一、join()方法
   1.join()：如t1.join()的含义是当前线程等待t1线程执行结束后再执行;
   
   2.join(long millis)：如t1.join(100)的含义是当前线程等待t1线程100ms，超过100ms t1线程如果还没结束，当前线程会执行；如果t1是非守护线程，那么当前线程执行结束后，t1继续执行；否则不再执行t1线程。
   
   注意：join()必须放在start()之后才会起作用。
  
## 二、join()方法的原理   
   1.join方法的本质调用的是Object中的wait方法实现线程的阻塞；
   
   2.调用wait方法必须要获取锁，所以join方法是被synchronized修饰的，synchronized修饰在方法层面相当于synchronized(this)，this就是前驱线程（previousThread）本身的实例；
   
   3.join()方法的逻辑结构与”等待/通知“一样，即：加锁、循环、处理逻辑。
    
## 二、案例
   同时采集三个机器的数据，每个机器采集花费的时间不同，需要等待所有采集完再返回。