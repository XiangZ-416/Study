import java.util.Scanner;

public class main02 {
    public static String replaceSpace(StringBuffer str) {
    	//获取字符串长度
    	int len = str.length();
    	//定义StringBuffer存放更改过的字符串
    	StringBuffer SB = new StringBuffer();
    	String res = "%20";
    	for(int i=0; i<len; i++) {
//    		if(str.charAt(i) == ' ') {
//    			SB.append("res");
//    		}else {
//				SB.append(str.charAt(i));
//			}
    		//if else可以用三元运算符替换
    		SB.append((str.charAt(i) == ' ') ?  res : str.charAt(i));
    	}
    	return SB.toString();
    }
    
    public static void main(String[] args) {
    	//从键盘读入
    	@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		StringBuffer str = new StringBuffer();
		str.append(input.nextLine());
		//输出
		System.out.println(replaceSpace(str));
	}
}
