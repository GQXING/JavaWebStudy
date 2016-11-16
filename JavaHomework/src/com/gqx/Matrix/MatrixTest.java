package com.gqx.Matrix;

public class MatrixTest {  
	  
    public static void main(String[] args) throws InterruptedException {  
        // TODO Auto-generated method stub  
        int i,j,t = 0;  
        int leng = 500;  
        long startTime,endTime;  
        long a[][] = new long[leng][leng];  
        long b[][] = new long[leng][leng];  
        //--------------�Ծ���A�;���B���г�ʼ��-------------    
        for(i=0;i<leng;i++)       
        {    
            t=i+1;    
            for(j=0;j<leng;j++)    
            {    
                a[i][j]=t++;    
                b[i][j]=1;    
            }    
        }  
        //�����ĵ��߳�
//        System.out.println(leng+"sssssssss");
        Matrix matrix1 = new Matrix(a, b, 0, leng);  
        Matrix matrix2 = new Matrix(a, b, 1, leng);  
        Matrix matrix3 = new Matrix(a, b, 2, leng);  
//        Matrix matrix4 = new Matrix(a, b, 3, leng);  
        Thread threadone = new Thread(matrix1);  
        Thread threadtwo = new Thread(matrix2);  
        Thread threadthree = new Thread(matrix3);  
//       Thread threadfour = new Thread(matrix4);  
        //-------------------���м���--------------------  
        startTime = System.currentTimeMillis();  
        threadone.start();  
        threadtwo.start();  
        threadthree.start();  
//        threadfour.start();  
        //�ȴ����߳���ֹ��
        threadone.join();  
        threadtwo.join();  
        threadthree.join();  
//        threadfour.join();  
        endTime = System.currentTimeMillis();  
       System.out.println("���н�� = " + (matrix1.getSum() + matrix2.getSum()+matrix3.getSum()));    
        System.out.println("����ʱ�� = " + (endTime - startTime)+"����");   
        //-------------------���м���--------------------  
        startTime = System.currentTimeMillis();  
        Matrix matrix= new Matrix(a, b, 0, leng);  
        matrix.serial();  
        endTime = System.currentTimeMillis();  
        System.out.println("���н�� = " + matrix.getSum());    
        System.out.println("����ʱ�� = " + (endTime - startTime)+"����");   
    }  
}  
