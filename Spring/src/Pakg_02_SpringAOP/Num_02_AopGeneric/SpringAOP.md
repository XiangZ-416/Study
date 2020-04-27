## һ��SpringAOP
    1. ���� jar ����
        com.springsource.net.sf.cglib-2.2.0.jar
        com.springsource.org.aopalliance-1.0.0.jar
        com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
        commons-logging-1.1.1.jar
        spring-aop-4.0.0.RELEASE.jar
        spring-aspects-4.0.0.RELEASE.jar
        spring-beans-4.0.0.RELEASE.jar
        spring-context-4.0.0.RELEASE.jar
        spring-core-4.0.0.RELEASE.jar
        spring-expression-4.0.0.RELEASE.jar

    2. �������ļ��м��� AOP �������ռ�
    
    3. ����ע��ķ�ʽ
        1���������ļ��м����������ã�
            <!-- ʹ Aspect ע�������ã��Զ�Ϊƥ��������ɴ������-->
            <aop:aspectj-autoproxy/>
        2���Ѻ��й�ע��Ĵ���������������
            a. ����������һ�� IOC �е� bean�������� @Component
            b. ���滹��Ҫ���� @Aspect ע��
        3����������������������Ҫ��֪ͨ(ÿ��֪ͨ����һ������)
            a. ����һ��֪ͨ��������
                i. �ڷ���ǰ���� @Before ע��
        4��������֪ͨ����������һ������Ϊ JoinPoint �Ĳ���. Ȼ����ܷ�������ϸ��. �緽�����ƺͲ���ֵ. 

## ��������
~~~ java
    // �����������Ϊһ�����棺��Ҫ���������� IOC �����С�������Ϊһ������
    @Aspect
    @Component
    public class LoggingAspect {
    
        // �����÷�����һ��ǰ��֪ͨ���ڷ�����ʼ֮ǰ֪ͨ
        @Before("execution(public int Pakg_02_Spring.Num_02_AopImpl.Code_02_ArithmeticCalculatorImpl.*(int , int ))")
        public void beforeMethod(JoinPoint joinPoint) {
            String methodName = joinPoint.getSignature().getName(); // ���ط�����
            List<Object> args = Arrays.asList(joinPoint.getArgs()); // ���ط�������
            System.out.println(" The method " + methodName + " begins with " + args);

        }
    }
~~~
            
