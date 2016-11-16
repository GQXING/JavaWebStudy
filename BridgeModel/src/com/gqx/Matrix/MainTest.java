package com.gqx.Matrix;

import java.util.Random;

public class MainTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		MainTest mainTest=new MainTest();
// 	int [][]M=mainTest.createMatrix(10000,10000);
//		int [][]M1=mainTest.createMatrix(2500,10000);
//		int [][]M2=mainTest.createMatrix(2500,10000);
//		int [][]M3=mainTest.createMatrix(2500,10000);
//		int [][]M4=mainTest.createMatrix(2500,10000);
		int [][]M1={{0,0,0,0},{5,6,7,8}};
		int [][]M2={{1,3,5,7},{2,4,6,8}};
		int [][] M={{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		Test test1=new Test(M1, M);
		Test test2=new Test(M2, M);
		Thread thread1=new Thread(test1);
		Thread thread2=new Thread(test2);
		thread1.start();
		thread2.start();

	
		


//		Test test3=new Test(M3, M);
//		Test test4=new Test(M4, M);
		
		
//		Thread thread3=new Thread(test3);
//		Thread thread4=new Thread(test4);
	

		thread1.join();
		thread2.join();
		int[][]C1=test1.getM();
//		int C2[][]=test2.getM();
		
		
		for (int i = 0; i < C1.length; i++) {
			for (int j = 0; j < C1[0].length; j++) {
				System.out.print(C1[i][j]+"  ");
			}
			System.out.println();
		}
		
		
		
//		thread3.start();
//		thread4.start();
//		int[][] MM=new int[10000][10000];
//		for (int i = 0; i < M1.length; i++) {
//			for (int j = 0; j < M1[0].length; j++) {
//				MM[i][j]=M1[i][j];
//			}
//		}
//		
//		for (int i = 0; i < M2.length; i++) {
//			for (int j = 0; j < M2[0].length; j++) {
//				MM[i+M1.length][j]=M2[i][j];
//			}
//		}
//		
//		for (int i = 0; i < M3.length; i++) {
//			for (int j = 0; j < M3[0].length; j++) {
//				MM[i+M1.length+M2.length][j]=M3[i][j];
//			}
//		}
//		
//		for (int i = 0; i < M4.length; i++) {
//			for (int j = 0; j < M4[0].length; j++) {
//				MM[i+M1.length+M2.length+M3.length][j]=M4[i][j];
//			}
//		}
		
	}
	
	
	
	public int[][] createMatrix(int n,int m){
		int[][] mat=new int[n][m];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				Random random=new Random();
				mat[i][j]=random.nextInt(10000);
			}
		}	
		return mat;
	}
}
