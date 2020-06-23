package chapter02;

/*
 * ���⣺ʹ��final�ؼ�������һ������ʱ,�����ò��ܱ�,�������õĶ����ܱ� 
 * ��: 
 * ʹ��final�ؼ�������һ������ʱ����ָ���ñ������ܱ䣬���ñ�����ָ��Ķ����е����ݻ��ǿ��Ըı�ġ� 
 */
public class FinalTest {

    //final StringBuffer sb;

    private FinalTest() {

    }

    // final���λ������͵ı���
    private static final char CHAR = '��';
    // final�����������͵ı���
    private static final StringBuffer FINAL_STRING = new StringBuffer("StringBuffer");

    public static void main(String[] args) {
        // ���뱨��,���ò��ܱ�  
        // FINAL_STRING = new StringBuffer("hehe");
        // ���ñ�����ָ��Ķ����е����ݻ��ǿ��Ըı��  
        FINAL_STRING.append("xxx");
        System.out.println(FINAL_STRING);

        FinalTest finalTest = new FinalTest();
        finalTest.method1(1);
        finalTest.method2(new StringBuffer("2"));
    }



    private void method1(final int i) {
        // i = i + 1;// ���뱨����Ϊfinal���ε��ǻ������͵ı���
        System.out.println(i);
    }

    /*
    �����ڶ��巽���Ĳ��������ñ�����ʱ,������������µ���ʽ����ֹ�����ڲ��޸Ĵ������Ĳ�������,
    ʵ����,���ǰ첻����,�ڸ÷����ڲ���Ȼ�����������´������޸Ĳ�������
    */
    private void method2(final StringBuffer buffer) {
        // ����ͨ��,��Ϊfinal���ε����������͵ı���
        buffer.append("buffer");
        System.out.println(buffer);
    }

}
