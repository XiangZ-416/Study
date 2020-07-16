#Thread类总结
    1.创建线程Thread对象，默认有一个线程名，以Thread-开头，从0开始计数
      Thread-0
      Thread-1
      Thread-2
      ...
    2.如果在调用构造函数Thread的时候没有传递Runnable或者没有复写Thread的run方法，该Thread将不会调用任何东西，如果
      传递了Runnable接口的实例，或者复写了Thread的run方法，则会执行该方法的逻辑单元（逻辑代码）
      public Thread()
      public Thread(Runnable target)
      public Thread(Runnable target, String name)
      public Thread(String name)
      
    3.如果构造线程对象时未传入ThreadGroup（所属线程组），Thread会默认获取父线程的ThreadGroup作为该线程的ThreadGroup
      public Thread(ThreadGroup group, Runnable target, String name, long stackSize) 
        group：指定当前线程的线程组，未指定时线程组为创建该线程所属的线程组。
        target：指定运行其中的Runnable，一般都需要指定，不指定的线程没有意义，或者可以通过创建Thread的子类并重新run方法。
        name：线程的名称，不指定自动生成。
        stackSize：指定虚拟机栈大小，不指定默认为0，0代表忽略这个属性。与平台相关，不建议使用该属性。