package Pakg_02_Spring.Num_03_AopXml;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class VlidationAspect {

	public void validateArgs(JoinPoint joinPoint){
		System.out.println("-->validate:" + Arrays.asList(joinPoint.getArgs()));
	}
	
}
