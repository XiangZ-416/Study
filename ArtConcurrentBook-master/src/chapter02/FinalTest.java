package chapter02;

/*
 * 问题：使用final关键字修饰一个变量时,是引用不能变,还是引用的对象不能变 
 * 答: 
 * 使用final关键字修饰一个变量时，是指引用变量不能变，引用变量所指向的对象中的内容还是可以改变的。 
 */
public class FinalTest {

    //final StringBuffer sb;

    private FinalTest() {

    }

    // final修饰基本类型的变量
    private static final char CHAR = '中';
    // final修饰引用类型的变量
    private static final StringBuffer FINAL_STRING = new StringBuffer("StringBuffer");

    public static void main(String[] args) {
        // 编译报错,引用不能变  
        // FINAL_STRING = new StringBuffer("hehe");
        // 引用变量所指向的对象中的内容还是可以改变的  
        FINAL_STRING.append("xxx");
        System.out.println(FINAL_STRING);

        FinalTest finalTest = new FinalTest();
        finalTest.method1(1);
        finalTest.method2(new StringBuffer("2"));
    }



    private void method1(final int i) {
        // i = i + 1;// 编译报错，因为final修饰的是基本类型的变量
        System.out.println(i);
    }

    /*
    有人在定义方法的参数（引用变量）时,可能想采用如下的形式来阻止方法内部修改传进来的参数对象,
    实际上,这是办不到的,在该方法内部任然可以增加如下代码来修改参数对象
    */
    private void method2(final StringBuffer buffer) {
        // 编译通过,因为final修饰的是引用类型的变量
        buffer.append("buffer");
        System.out.println(buffer);
    }

}
