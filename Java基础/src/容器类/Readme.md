#一、基本概念
    Java容器类类库的用途是“持有对象”，并将其划分为两个不同的概念：
    １）Collection：一个独立元素的序列，这些元素都服从一条或者多条规则。
    List必须按照插入的顺序保存元素，而set不能有重复的元素。Queue按照排队规则来确定对象产生的顺序（通常与它们被插入的顺序相同）。
    
    2）Map：一组成对的“键值对”对象，允许你使用键来查找值。

    |Collection（容器）
    |　　├List（链表）：有序可重复
    |　　│-├LinkedList*
    |　　│-├ArrayList*
    |　　│-└Vector
    |　　│　└Stack
    |　　├Set（集合）：无序不可重复
    |　　│├HashSet*
    |　　│├TreeSet*
    |　　│└LinkedSet
    |
    |Map（键值对）：无序key不可重复
　　  ├Hashtable
　　  ├HashMap*
　　  └WeakHashMap

**注**： 1、java.util.Collection 是一个集合接口。它提供了对集合对象进行基本操作的通用接口方法。
　　 2、java.util.Collections 是一个包装类。它包含有各种有关集合操作的静态多态方法。此类不能实例化，就像一个工具类，服务于Java的Collection框架。

#二、Collection集合接口
        Collection是最基本的集合接口，一个Collection代表一组Object，即Collection的元素（Elements）。一些Collection允许相同的元素而另一些不行。
    一些能排序而另一些不行。Java SDK不提供直接继承自Collection的类，Java SDK提供的类都是继承自Collection的“子接口”如List和Set。　

   ##主要方法:
    boolean add(Object o)添加对象到集合
    boolean remove(Object o)删除指定的对象
    int size()返回当前集合中元素的数量
    boolean contains(Object o)查找集合中是否有指定的对象
    boolean isEmpty()判断集合是否为空
    Iterator iterator()返回一个迭代器
    boolean containsAll(Collection c)查找集合中是否有集合c中的元素
    boolean addAll(Collection c)将集合c中所有的元素添加给该集合
    void clear()删除集合中所有元素
    void removeAll(Collection c)从集合中删除c集合中也有的元素
    void retainAll(Collection c)从集合中删除集合c中不包含的元素

   ## 1、List接口（链表）
     ListList是有序、可重复的容器，使用此接口能够精确的控制每个元素插入的位置。用户能够使用索引来访问List中的元素，这类似于Java的数组。
     实现List接口的常用类有LinkedList，ArrayList，Vector和Stack。
   **注意**：有序指的是：List中每个元素都有索引标记。可以根据元素的索引标记（在List中的位置）访问元素，从而精确控制这些元素。

   ###1）LinkedList类
    　　  LinkedList实现了List接口，允许null元素。此外LinkedList提供额外的get，remove，insert方法在 LinkedList的首部或尾部。
        这些操作使LinkedList可被用作堆栈（stack），队列（queue）或双向队列（deque）。

        注意:LinkedList没有同步方法。如果多个线程同时访问一个List，则必须自己实现访问同步。
        一种解决方法是在创建List时构造一个同步的List：List list = Collections.synchronizedList(new LinkedList(…));

   ###2) ArrayList类
        　ArrayList实现了可变大小的数组。它允许添加任何类型的元素，包括null。ArrayList没有同步。size，isEmpty，get，set方法运行时间为O(1)。
        但是add方法开销为分摊的常数，添加n个元素需要O(n)的时间。其他的方法运行时间为线性。每个ArrayList实例都有一个容量（Capacity），
        即用于存储元素的数组的大小。这个容量可随着不断添加新元素而自动增加，但是增长算法并 没有定义。当需要插入大量元素时，在插入前可以
        调用ensureCapacity方法来增加ArrayList的容量以提高插入效率。

        注意：和LinkedList一样，ArrayList也是非同步的。一般情况下使用这两个就可以了，因为非同步，所以效率比较高。
        如果涉及到堆栈，队列等操作，应该考虑用List，对于需要快速插入，删除元素，应该使用LinkedList，如果需要快速随机访问元素，应该使用ArrayList。

   ###3）Vector类
        　Vector非常类似ArrayList，但是Vector是同步的。

   ###4）Stack 类
        　Stack继承自Vector，实现一个后进先出的堆栈。Stack提供5个额外的方法，使得Vector得以被当作堆栈使用。基本的push和pop方法，
        还有 peek方法得到栈顶的元素，empty方法测试堆栈是否为空，search方法检测一个元素在堆栈中的位置。Stack刚创建后是空栈。

  ##2、Set接口（集合）
    　　Set是一种不包含重复的元素的Collection，即任意的两个元素e1和e2都有e1.equals(e2)=false，Set最多有一个null元素。
    Set的构造函数有一个约束条件，传入的Collection参数不能包含重复的元素。
        Set接口的常用类主要有HashSet和TreeSet等。

  ###1）HashSet类（无序）
    　 　Java.util.HashSet类实现了Java.util.Set接口。
    　　-> 它不允许出现重复元素；
    　　-> 不保证集合中元素的顺序
    　　-> 允许包含值为null的元素，但最多只能有一个null元素。

  ###2）TreeSet（有序）
    　　TreeSet描述的是Set的一种变体——可以实现排序等功能的集合。
    它在讲对象元素添加到集合中时会自动按照某种比较规则将其插入到有序的对象序列中。

#三、Map集合接口（key不能相同）
        Map没有继承Collection接口，Map提供key到value的映射。一个Map中不能包含相同的key，每个key只能映射一个value。
    Map接口提供3种集合的视图，Map的内容可以被当作一组key集合，一组value集合，或者一组key-value映射。

   ##主要方法:
    boolean equals(Object o)比较对象
    boolean remove(Object o)删除一个对象
    put(Object key,Object value)添加key和value

   ##1、Hashtable类（线程安全，同步）
        Hashtable继承Map接口，实现一个key-value映射的哈希表。任何非空（non-null）的对象都可作为key或者value。
        添加数据使用put(key, value)，取出数据使用get(key)，这两个基本操作的时间为O(1)。

   ##２、HashMap类（线程不安全，不同步）
    　　HashMap和Hashtable类似，不同之处在于HashMap是非同步的，并且允许null，即null value和null key。

   ##３、WeakHashMap类
    　　WeakHashMap是一种改进的HashMap，它对key实行“弱引用”，如果一个key不再被外部所引用，那么该key可以被GC回收。

