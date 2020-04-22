## 一、SpringAOP
    1. 加入 jar 包：
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

    2. 在配置文件中加入 AOP 的命名空间
    
    3. 基于注解的方式
        1）在配置文件中加入如下配置：
            <!-- 使 Aspect 注解起作用：自动为匹配的类生成代理对象-->
            <aop:aspectj-autoproxy/>
        2）把横切关注点的代码抽象到切面的类中
            a. 切面首先是一个 IOC 中的 bean，即加入 @Component
            b. 切面还需要加入 @Aspect 注解
        3）在切面类中声明各种需要的通知(每个通知就是一个方法)
            a. 声明一个通知（方法）
                i. 在方法前加入 @Before 注解
        4）可以在通知方法中声明一个类型为 JoinPoint 的参数. 然后就能访问链接细节. 如方法名称和参数值. 

## 二、代码
~~~ java
    // 把这个类声明为一个切面：需要把这个类放入 IOC 容器中、再声明为一个切面
    @Aspect
    @Component
    public class LoggingAspect {
    
        // 声明该方法是一个前置通知：在方法开始之前通知
        @Before("execution(public int Pakg_02_Spring.Num_02_AopImpl.Code_02_ArithmeticCalculatorImpl.*(int , int ))")
        public void beforeMethod(JoinPoint joinPoint) {
            String methodName = joinPoint.getSignature().getName(); // 返回方法名
            List<Object> args = Arrays.asList(joinPoint.getArgs()); // 返回方法参数
            System.out.println(" The method " + methodName + " begins with " + args);

        }
    }
~~~
            
