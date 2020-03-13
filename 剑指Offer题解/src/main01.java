import java.util.Scanner;

public class main01 {
    public static boolean Find(int target, int [][] array) {
        //�����ά��������������
        int rows = array.length;
        int cols = array[0].length;
        //�ӵ�һ�����һ�У����Ͻǣ���ʼ
        int row = 0;
        int col = cols - 1;
        //����ֵ��ʼ��
        boolean result = false;
        while(col >= 0 && row < rows){
            if(array[row][col] == target){
                result = true;
                break;
            }else if(array[row][col] > target){
                col--;
            }else{
				row++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
		//�Ӽ��̶����ά����
    	System.out.println("�������е��������е��������Ͻ�Ԫ��Ϊ��㣩�Ķ�ά����");
    	System.out.println("�����ά����Ľײ�����");
    	@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
    	//������Ҫ�Ľײ���
    	int n = input.nextInt();
    	//����һ��n*n������array
    	int[][] array = new int[n][n];
    	System.out.println("��������ĸ���Ԫ�أ�");
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			//�����鸳ֵ
    			array[i][j] = input.nextInt();
    		}
    	}
    	System.out.println("���������Ϊ��");
    	for(int i=0; i<n; i++) {
    		for (int j = 0; j < n; j++) {
				System.out.print(array[i][j]+"\t");
				if (j == n-1) {
					System.out.println();
				}
			}
    	}
    	
    	System.out.println("������target��");
    	System.out.println(Find(input.nextInt(), array));
	}
}
