package com.gqx.Matrix;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][]={{1,2},{1,6},{5,6}};
		int B[][]={{3,4},{2,4}};
		int[][] C=new Test2().go(A, B);
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[0].length; j++) {
				System.out.print(C[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public int[][] go(int[][] A,int[][] B){
		int [][] result;
		result = new int[A.length][B[0].length]; 
        for (int i = 0; i<A.length; i++) { 
            for (int j = 0; j<B[0].length; j++) { 
                for (int k = 0; k<A[0].length; k++) { 
                	System.out.print(A[i][k]+"   "+B[k][j]+"    "    );
                    result[i][j]= result[i][j]+A[i][k]*B[k][j];
                } 
            } 
        } 
        
        return result;
				
	}

}
