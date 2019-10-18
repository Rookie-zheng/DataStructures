package com.atguigu.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SparseArray {

	public static void main(String[] args) throws Exception {
		// 创建一个原始的二维数组 11 * 11
		// 0: 表示没有棋子， 1 表示 黑子 2 表示蓝子
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[3][5] = 4;
		chessArr1[1][4] = 4;
		// 输出原始的二维数组
		System.out.println("原始的二维数组");
		for (int[] row : chessArr1) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// 将二维数组 转 稀疏数组
		// 1.先遍历二维数组 得到非0数据的个数
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}

		// 2.创建对应的稀疏数组
		int sparseArr[][] = new int[sum + 1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		// 给稀疏数组赋值
		sparseArr[0][2] = sum;

		// 遍历二维数组，将非0的值存放到 sparseArr中
		int count = 0; // count 用于记录是第几个非0数据
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}

		// 输出稀疏数组的形式
		System.out.println();
		System.out.println("得到稀疏数组为~~~");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
		}
		System.out.println();
		
		// 将稀疏数组 --》 恢复成 原始的二维数组
		// 1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组

		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

		// 2、在读取稀疏数组后几行的数据，并赋值 原始的二维数组 即可

		for (int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		// 输出恢复后的二维数组
		System.out.println();
		System.out.println("恢复后的二维数组");

		for (int[] row : chessArr2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		
		//将稀疏数组存入磁盘
		File file = new File(".//src//test.txt");
		
		FileWriter out = new FileWriter(file);
		
		for (int i = 0; i < sparseArr.length; i++) {
			out.write(sparseArr[i][0] + "\t");
			out.write(sparseArr[i][1] + "\t");
			out.write(sparseArr[i][2] + "\t");
			out.write("\r\n");//换行
		}
		out.close();
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		
		String line;
		
		int[][] arrayRead = new int[11][3];
		int row = 0;
		while((line = in.readLine()) != null) {
			String[] temp = line.split("\t");
			//arrayRead[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = Integer.parseInt(temp[2]);
			for(int n = 0; n < temp.length; n++) {
				arrayRead[row][n] = Integer.parseInt(temp[n]);
			}
			row++;
		}
		in.close();
		
		//读取磁盘中的稀疏数组
		System.out.println("读取磁盘中的稀疏数组");
		for(int k = 0; k < sparseArr.length; k++) {
			System.out.printf("%d\t%d\t%d\t\n", arrayRead[k][0], arrayRead[k][1], arrayRead[k][2]);
		}
		System.out.println();
	}
}
