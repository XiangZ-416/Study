package Pakg_02_SpringAOP.Num_01_AopHelloWorld;

/*
 * @Author ZX
 * @Description //TODO ȱ�㣺������ң�Խ��Խ��ķ�ҵ������(��־����֤��)�����, ԭ�е�ҵ�񷽷���������.
 *                                    ÿ�������ڴ�������߼���ͬʱ�����������������ע��.
 *                            �����ɢ: ����־����Ϊ��, ֻ��Ϊ�����������һ����, �Ͳ��ò��ڶ��ģ�飨�����������ظ���ͬ����־����.
 *                                    �����־�������仯, �����޸�����ģ��.
 *                            ʹ�ö�̬��������������
 * @Date 15:52 2020/4/22
 * @Param
 * @return
 **/

public class Code_03_ArithmeticCalculatorLoggingImpl implements Code_01_ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		System.out.println("The method add begins with [" + i + "," + j + "]");
		int result = i + j;
		System.out.println("The method add ends with " + result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("The method sub begins with [" + i + "," + j + "]");
		int result = i - j;
		System.out.println("The method sub ends with " + result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("The method mul begins with [" + i + "," + j + "]");
		int result = i * j;
		System.out.println("The method mul ends with " + result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("The method div begins with [" + i + "," + j + "]");
		int result = i / j;
		System.out.println("The method div ends with " + result);
		return result;
	}

}
