package com.gqx.array;

import java.util.Arrays;

public class ArrayDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  intCreate=100000;
		int intRand;
		int [][] intArray=new int[2][42];
		
		//������������Ĵ������뵽������ȥ
		while (intCreate-->0) {
			intRand=(int)(Math.random()*42);
			intArray[0][intRand]++;
			intArray[1][intRand]++;
		}
		
		//��intArray[0]������
		Arrays.sort(intArray[0]);
		
		//�ҳ�������������
		for (int i = 41; i >(41-6); i--) {
			//��һ��������ͬ��
			for (int j = 41; j >= 0; j--) {
				if (intArray[0][i]==intArray[1][j]) {
					System.out.println("���������"+(j+1)+"������"+intArray[0][i]+"��");
					intArray[1][j]=0;
					break;
				}
			}
		}

	}

}
