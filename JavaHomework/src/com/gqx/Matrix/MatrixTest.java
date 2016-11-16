package com.gqx.Matrix;

public class MatrixTest {  
	  
    public static void main(String[] args) throws InterruptedException {  
        // TODO Auto-generated method stub  
        int i,j,t = 0;  
        int leng = 500;  
        long startTime,endTime;  
        long a[][] = new long[leng][leng];  
        long b[][] = new long[leng][leng];  
        //--------------对矩阵A和矩阵B进行初始化-------------    
        for(i=0;i<leng;i++)       
        {    
            t=i+1;    
            for(j=0;j<leng;j++)    
            {    
                a[i][j]=t++;    
                b[i][j]=1;    
            }    
        }  
        //建立四道线程
//        System.out.println(leng+"sssssssss");
        Matrix matrix1 = new Matrix(a, b, 0, leng);  
        Matrix matrix2 = new Matrix(a, b, 1, leng);  
        Matrix matrix3 = new Matrix(a, b, 2, leng);  
//        Matrix matrix4 = new Matrix(a, b, 3, leng);  
        Thread threadone = new Thread(matrix1);  
        Thread threadtwo = new Thread(matrix2);  
        Thread threadthree = new Thread(matrix3);  
//       Thread threadfour = new Thread(matrix4);  
        //-------------------并行计算--------------------  
        startTime = System.currentTimeMillis();  
        threadone.start();  
        threadtwo.start();  
        threadthree.start();  
//        threadfour.start();  
        //等待该线程终止。
        threadone.join();  
        threadtwo.join();  
        threadthree.join();  
//        threadfour.join();  
        endTime = System.currentTimeMillis();  
       System.out.println("并行结果 = " + (matrix1.getSum() + matrix2.getSum()+matrix3.getSum()));    
        System.out.println("并行时间 = " + (endTime - startTime)+"毫秒");   
        //-------------------串行计算--------------------  
        startTime = System.currentTimeMillis();  
        Matrix matrix= new Matrix(a, b, 0, leng);  
        matrix.serial();  
        endTime = System.currentTimeMillis();  
        System.out.println("串行结果 = " + matrix.getSum());    
        System.out.println("串行时间 = " + (endTime - startTime)+"毫秒");   
    }  
}  
