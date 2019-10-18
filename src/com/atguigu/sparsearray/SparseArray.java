package com.atguigu.sparsearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SparseArray {

	public static void main(String[] args) throws Exception {
		// ����һ��ԭʼ�Ķ�ά���� 11 * 11
		// 0: ��ʾû�����ӣ� 1 ��ʾ ���� 2 ��ʾ����
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[3][5] = 4;
		chessArr1[1][4] = 4;
		// ���ԭʼ�Ķ�ά����
		System.out.println("ԭʼ�Ķ�ά����");
		for (int[] row : chessArr1) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}

		// ����ά���� ת ϡ������
		// 1.�ȱ�����ά���� �õ���0���ݵĸ���
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}

		// 2.������Ӧ��ϡ������
		int sparseArr[][] = new int[sum + 1][3];
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		// ��ϡ�����鸳ֵ
		sparseArr[0][2] = sum;

		// ������ά���飬����0��ֵ��ŵ� sparseArr��
		int count = 0; // count ���ڼ�¼�ǵڼ�����0����
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

		// ���ϡ���������ʽ
		System.out.println();
		System.out.println("�õ�ϡ������Ϊ~~~");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
		}
		System.out.println();
		
		// ��ϡ������ --�� �ָ��� ԭʼ�Ķ�ά����
		// 1���ȶ�ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�����ԭʼ�Ķ�ά����

		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

		// 2���ڶ�ȡϡ��������е����ݣ�����ֵ ԭʼ�Ķ�ά���� ����

		for (int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

		// ����ָ���Ķ�ά����
		System.out.println();
		System.out.println("�ָ���Ķ�ά����");

		for (int[] row : chessArr2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		
		//��ϡ������������
		File file = new File(".//src//test.txt");
		
		FileWriter out = new FileWriter(file);
		
		for (int i = 0; i < sparseArr.length; i++) {
			out.write(sparseArr[i][0] + "\t");
			out.write(sparseArr[i][1] + "\t");
			out.write(sparseArr[i][2] + "\t");
			out.write("\r\n");//����
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
		
		//��ȡ�����е�ϡ������
		System.out.println("��ȡ�����е�ϡ������");
		for(int k = 0; k < sparseArr.length; k++) {
			System.out.printf("%d\t%d\t%d\t\n", arrayRead[k][0], arrayRead[k][1], arrayRead[k][2]);
		}
		System.out.println();
	}
}
