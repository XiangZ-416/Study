#һ����������
    Java������������;�ǡ����ж��󡱣������仮��Ϊ������ͬ�ĸ��
    ����Collection��һ������Ԫ�ص����У���ЩԪ�ض�����һ�����߶�������
    List���밴�ղ����˳�򱣴�Ԫ�أ���set�������ظ���Ԫ�ء�Queue�����Ŷӹ�����ȷ�����������˳��ͨ�������Ǳ������˳����ͬ����
    
    2��Map��һ��ɶԵġ���ֵ�ԡ�����������ʹ�ü�������ֵ��

    |Collection��������
    |������List��������������ظ�
    |������-��LinkedList*
    |������-��ArrayList*
    |������-��Vector
    |����������Stack
    |������Set�����ϣ������򲻿��ظ�
    |��������HashSet*
    |��������TreeSet*
    |��������LinkedSet
    |
    |Map����ֵ�ԣ�������key�����ظ�
����  ��Hashtable
����  ��HashMap*
����  ��WeakHashMap

**ע**�� 1��java.util.Collection ��һ�����Ͻӿڡ����ṩ�˶Լ��϶�����л���������ͨ�ýӿڷ�����
���� 2��java.util.Collections ��һ����װ�ࡣ�������и����йؼ��ϲ����ľ�̬��̬���������಻��ʵ����������һ�������࣬������Java��Collection��ܡ�

#����Collection���Ͻӿ�
        Collection��������ļ��Ͻӿڣ�һ��Collection����һ��Object����Collection��Ԫ�أ�Elements����һЩCollection������ͬ��Ԫ�ض���һЩ���С�
    һЩ���������һЩ���С�Java SDK���ṩֱ�Ӽ̳���Collection���࣬Java SDK�ṩ���඼�Ǽ̳���Collection�ġ��ӽӿڡ���List��Set����

   ##��Ҫ����:
    boolean add(Object o)��Ӷ��󵽼���
    boolean remove(Object o)ɾ��ָ���Ķ���
    int size()���ص�ǰ������Ԫ�ص�����
    boolean contains(Object o)���Ҽ������Ƿ���ָ���Ķ���
    boolean isEmpty()�жϼ����Ƿ�Ϊ��
    Iterator iterator()����һ��������
    boolean containsAll(Collection c)���Ҽ������Ƿ��м���c�е�Ԫ��
    boolean addAll(Collection c)������c�����е�Ԫ����Ӹ��ü���
    void clear()ɾ������������Ԫ��
    void removeAll(Collection c)�Ӽ�����ɾ��c������Ҳ�е�Ԫ��
    void retainAll(Collection c)�Ӽ�����ɾ������c�в�������Ԫ��

   ## 1��List�ӿڣ�����
     ListList�����򡢿��ظ���������ʹ�ô˽ӿ��ܹ���ȷ�Ŀ���ÿ��Ԫ�ز����λ�á��û��ܹ�ʹ������������List�е�Ԫ�أ���������Java�����顣
     ʵ��List�ӿڵĳ�������LinkedList��ArrayList��Vector��Stack��
   **ע��**������ָ���ǣ�List��ÿ��Ԫ�ض���������ǡ����Ը���Ԫ�ص�������ǣ���List�е�λ�ã�����Ԫ�أ��Ӷ���ȷ������ЩԪ�ء�

   ###1��LinkedList��
    ����  LinkedListʵ����List�ӿڣ�����nullԪ�ء�����LinkedList�ṩ�����get��remove��insert������ LinkedList���ײ���β����
        ��Щ����ʹLinkedList�ɱ�������ջ��stack�������У�queue����˫����У�deque����

        ע��:LinkedListû��ͬ���������������߳�ͬʱ����һ��List��������Լ�ʵ�ַ���ͬ����
        һ�ֽ���������ڴ���Listʱ����һ��ͬ����List��List list = Collections.synchronizedList(new LinkedList(��));

   ###2) ArrayList��
        ��ArrayListʵ���˿ɱ��С�����顣����������κ����͵�Ԫ�أ�����null��ArrayListû��ͬ����size��isEmpty��get��set��������ʱ��ΪO(1)��
        ����add��������Ϊ��̯�ĳ��������n��Ԫ����ҪO(n)��ʱ�䡣�����ķ�������ʱ��Ϊ���ԡ�ÿ��ArrayListʵ������һ��������Capacity����
        �����ڴ洢Ԫ�ص�����Ĵ�С��������������Ų��������Ԫ�ض��Զ����ӣ����������㷨�� û�ж��塣����Ҫ�������Ԫ��ʱ���ڲ���ǰ����
        ����ensureCapacity����������ArrayList����������߲���Ч�ʡ�

        ע�⣺��LinkedListһ����ArrayListҲ�Ƿ�ͬ���ġ�һ�������ʹ���������Ϳ����ˣ���Ϊ��ͬ��������Ч�ʱȽϸߡ�
        ����漰����ջ�����еȲ�����Ӧ�ÿ�����List��������Ҫ���ٲ��룬ɾ��Ԫ�أ�Ӧ��ʹ��LinkedList�������Ҫ�����������Ԫ�أ�Ӧ��ʹ��ArrayList��

   ###3��Vector��
        ��Vector�ǳ�����ArrayList������Vector��ͬ���ġ�

   ###4��Stack ��
        ��Stack�̳���Vector��ʵ��һ������ȳ��Ķ�ջ��Stack�ṩ5������ķ�����ʹ��Vector���Ա�������ջʹ�á�������push��pop������
        ���� peek�����õ�ջ����Ԫ�أ�empty�������Զ�ջ�Ƿ�Ϊ�գ�search�������һ��Ԫ���ڶ�ջ�е�λ�á�Stack�մ������ǿ�ջ��

  ##2��Set�ӿڣ����ϣ�
    ����Set��һ�ֲ������ظ���Ԫ�ص�Collection�������������Ԫ��e1��e2����e1.equals(e2)=false��Set�����һ��nullԪ�ء�
    Set�Ĺ��캯����һ��Լ�������������Collection�������ܰ����ظ���Ԫ�ء�
        Set�ӿڵĳ�������Ҫ��HashSet��TreeSet�ȡ�

  ###1��HashSet�ࣨ����
    �� ��Java.util.HashSet��ʵ����Java.util.Set�ӿڡ�
    ����-> ������������ظ�Ԫ�أ�
    ����-> ����֤������Ԫ�ص�˳��
    ����-> �������ֵΪnull��Ԫ�أ������ֻ����һ��nullԪ�ء�

  ###2��TreeSet������
    ����TreeSet��������Set��һ�ֱ��塪������ʵ������ȹ��ܵļ��ϡ�
    ���ڽ�����Ԫ����ӵ�������ʱ���Զ�����ĳ�ֱȽϹ�������뵽����Ķ��������С�

#����Map���Ͻӿڣ�key������ͬ��
        Mapû�м̳�Collection�ӿڣ�Map�ṩkey��value��ӳ�䡣һ��Map�в��ܰ�����ͬ��key��ÿ��keyֻ��ӳ��һ��value��
    Map�ӿ��ṩ3�ּ��ϵ���ͼ��Map�����ݿ��Ա�����һ��key���ϣ�һ��value���ϣ�����һ��key-valueӳ�䡣

   ##��Ҫ����:
    boolean equals(Object o)�Ƚ϶���
    boolean remove(Object o)ɾ��һ������
    put(Object key,Object value)���key��value

   ##1��Hashtable�ࣨ�̰߳�ȫ��ͬ����
        Hashtable�̳�Map�ӿڣ�ʵ��һ��key-valueӳ��Ĺ�ϣ���κηǿգ�non-null���Ķ��󶼿���Ϊkey����value��
        �������ʹ��put(key, value)��ȡ������ʹ��get(key)������������������ʱ��ΪO(1)��

   ##����HashMap�ࣨ�̲߳���ȫ����ͬ����
    ����HashMap��Hashtable���ƣ���֮ͬ������HashMap�Ƿ�ͬ���ģ���������null����null value��null key��

   ##����WeakHashMap��
    ����WeakHashMap��һ�ָĽ���HashMap������keyʵ�С������á������һ��key���ٱ��ⲿ�����ã���ô��key���Ա�GC���ա�

