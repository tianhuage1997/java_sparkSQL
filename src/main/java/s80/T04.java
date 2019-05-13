package s80;

import java.util.Scanner;

public class T04 {
    public static void main(String[] args) {

          Scanner scanner  =new Scanner(System.in);

          int m = scanner.nextInt();
          int n = scanner.nextInt();
        System.out.println("行:"+m);
        System.out.println("列:"+n);

        //定义二维数组存储的矩阵
        int[][] arr = new int[m][n];

        //定义两个变量分别表示行和列
        int row = 0;//行
        int col = 0;//列

        //先存入第一个数
        arr[0][0] = 1;

        //定义一个数组表示挪动的方向
        int[][]  change = {
                {0,1},//右
                {1,0},//下
                {0,-1},//左
                {-1,0}//上
        };


        //定义一个变量来控制方向
        int di =0;

        for(int i = 2;i<= m*n ;i++){
            //先按照原来的方向移动
            row += change[di][0];
            col += change[di][1];

           // row= row +change[0][0];
           // col = col + change[0][1];

            //判断这次移动是否越过界
            if(col >= n || row >= m || col < 0 || arr[row][col] !=0){
                //回挪一步
                row -= change[di][0];
                col -= change[di][1];

                di++;
                if(di == 4){
                    di = 0;
                }
                row += change[di][0];
                col += change[di][1];
            }

            //后续对i的自然数进行赋值
            arr[row][col] = i ;
        }


        for (int[]  is :arr){
            for (int i : is){
                System.out.print(i+"\t");
            }
            System.out.println();
        }



    }
}
