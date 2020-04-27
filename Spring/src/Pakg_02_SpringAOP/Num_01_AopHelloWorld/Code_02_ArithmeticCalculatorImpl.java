package Pakg_02_SpringAOP.Num_01_AopHelloWorld;

import org.springframework.stereotype.Component;

@Component("arithmeticCalculator")
public class Code_02_ArithmeticCalculatorImpl implements Code_01_ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		int result = i + j;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result = i * j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result = i / j;
		return result;
	}

}
