import java.util.Scanner;

public class main02 {
    public static String replaceSpace(StringBuffer str) {
    	//��ȡ�ַ�������
    	int len = str.length();
    	//����StringBuffer��Ÿ��Ĺ����ַ���
    	StringBuffer SB = new StringBuffer();
    	String res = "%20";
    	for(int i=0; i<len; i++) {
//    		if(str.charAt(i) == ' ') {
//    			SB.append("res");
//    		}else {
//				SB.append(str.charAt(i));
//			}
    		//if else��������Ԫ������滻
    		SB.append((str.charAt(i) == ' ') ?  res : str.charAt(i));
    	}
    	return SB.toString();
    }
    
    public static void main(String[] args) {
    	//�Ӽ��̶���
    	@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		StringBuffer str = new StringBuffer();
		str.append(input.nextLine());
		//���
		System.out.println(replaceSpace(str));
	}
}
