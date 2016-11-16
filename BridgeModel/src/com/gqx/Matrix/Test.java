package com.gqx.Matrix;

public class Test implements Runnable {
	private  int[][] A;
	private  int[][] B;
	private  int [][] result;
	
	public Test(int[][] A,int[][]B){
		System.out.println("Hh");
		this.A=A;
		this.B=B;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
			result = new int[A.length][B[0].length]; 
	        for (int i = 0; i<A.length; i++) { 
	            for (int j = 0; j<B[0].length; j++) { 
	                for (int k = 0; k<A[0].length; k++) { 
	                	System.out.print(A[i][k]+" "+B[k][j]+" ");
	                    result[i][j]= result[i][j]+A[i][k]*B[k][j]; 
	                    System.out.println(result[i][j]);
	                } 
	            } 
	        } 
	        this.result=result;
	}	
	public int[][] getM(){
		return this.result;
	}
}
