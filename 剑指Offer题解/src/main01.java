import java.util.Scanner;

public class main01 {
    public static boolean Find(int target, int [][] array) {
        //计算二维数组行数、列数
        int rows = array.length;
        int cols = array[0].length;
        //从第一行最后一列（右上角）开始
        int row = 0;
        int col = cols - 1;
        //返回值初始化
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
		//从键盘读入二维数组
    	System.out.println("输入逐行递增，逐列递增（左上角元素为起点）的二维数组");
    	System.out.println("输入二维数组的阶层数：");
    	@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
    	//定义需要的阶层数
    	int n = input.nextInt();
    	//定义一个n*n的数组array
    	int[][] array = new int[n][n];
    	System.out.println("输入数组的各个元素：");
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			//给数组赋值
    			array[i][j] = input.nextInt();
    		}
    	}
    	System.out.println("输入的数组为：");
    	for(int i=0; i<n; i++) {
    		for (int j = 0; j < n; j++) {
				System.out.print(array[i][j]+"\t");
				if (j == n-1) {
					System.out.println();
				}
			}
    	}
    	
    	System.out.println("请输入target：");
    	System.out.println(Find(input.nextInt(), array));
	}
}
