package com.gqx.array;

import java.util.Arrays;

public class ArrayDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  intCreate=100000;
		int intRand;
		int [][] intArray=new int[2][42];
		
		//将产生随机数的次数放入到数组中去
		while (intCreate-->0) {
			intRand=(int)(Math.random()*42);
			intArray[0][intRand]++;
			intArray[1][intRand]++;
		}
		
		//对intArray[0]做排序
		Arrays.sort(intArray[0]);
		
		//找出最大的留个数字
		for (int i = 41; i >(41-6); i--) {
			//逐一检查次数相同者
			for (int j = 41; j >= 0; j--) {
				if (intArray[0][i]==intArray[1][j]) {
					System.out.println("随机数号码"+(j+1)+"出现了"+intArray[0][i]+"次");
					intArray[1][j]=0;
					break;
				}
			}
		}

	}

}
