package xjx.sparseArray;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 稀疏数组
 * 五子棋
 */
public class TestSparseArray {
    public static void main(String[] args) throws IOException {
        //1表示黑子，2表示蓝子
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        System.out.println("原始二维数组");
        for (int[] i: arr){
            for (int j: i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        //将原始二维数组转为稀疏数组
        //1.遍历原始数组，找出不为0的个数
        int count = 0;
        for (int i = 0;i <arr.length;i++){
            for (int j = 0;j < arr.length;j++){
                if (arr[i][j]!=0){
                    count++;
                }
            }
        }
        //2.创建相应的稀疏数组
        int[][] spaArr = new int[count+1][3];
        //3.初始化稀疏数组的第一行
        spaArr[0][0] = 11; //原始数组的行
        spaArr[0][1] = 11; //原始数组的列
        spaArr[0][2] = count; //原始数组中不为零的元素个数
        //给稀疏数组的其他位置赋值
        int temp = 0;
        for (int i = 0;i <arr.length;i++){
            for (int j = 0;j < arr.length;j++){
                if (arr[i][j]!=0){
                    temp++;
                    spaArr[temp][0] = i;
                    spaArr[temp][1] = j;
                    spaArr[temp][2] = arr[i][j];
                }
            }
        }
        //将稀疏数组恢复成原始数组
        int[][] chessArr = new int[spaArr[0][0]][spaArr[0][1]];
        for (int i = 1;i < spaArr.length;i++){
            chessArr[spaArr[i][0]][spaArr[i][1]] = spaArr[i][2];
        }
        //将稀疏数组存入到文件中
        File f = new File("f:/str1/sparseArr.txt");
        FileWriter fw = new FileWriter(f);
        for (int i = 0;i < spaArr.length;i++){
            for (int j = 0;j < count;j++){
                fw.write(spaArr[i][j]+",");
            }
            fw.write(spaArr[i][count]+"");
            fw.write("\n");
        }
        fw.flush();
        fw.close();
        //将文件中的数组恢复为原始数组
        BufferedReader br = new BufferedReader(new FileReader("f:/str1/sparseArr.txt"));
        List<String> list = new ArrayList<>();
        String str = null;
        while ((str=br.readLine())!=null){
            list.add(str);
        }
        br.close();

        //获取稀疏数组的行数
        int row = list.size();
        //获取稀疏数组的列数
        String str1 = list.get(0);
        int col = str1.split("\\,").length;
        //创建数组
        int c = 0;
        int[][] sArr = new int[row][col];
        for (String s : list){
            String[] sr = s.split("\\,");
            for (int i = 0;i < col;i++){
                sArr[c][i] = Integer.valueOf(sr[i]);
            }
            c++;
        }
        for (int[] i :sArr){
            for (int j : i){
                System.out.print(j+"\t");
            }
            System.out.println();
        }



    }
}
