package com.gqx.Matrix;

class Matrix implements Runnable{  
  
    private long A[][];  
    private long B[][];  
    private long C[][];  
    private int start ;  
    private int end ;  
    private long sum = 0 ;  
      
    public Matrix(long A[][],long B[][],int st,int en){  
        this.A = A;  
        this.B = B;  
        this.start = st;  
        this.end = en;  
        this.C = new long[en][en];  
    }  
    
    /**
     * 并行运算
     */
    @Override  
    public void run() {  
        // TODO Auto-generated method stub  
//    	long  startTime = System.currentTimeMillis();  
//    	int count=0;
        int i,j,k;  
        System.out.println(start+"   "+end);
        for( i=start; i< end; i += 3)    
        {    
        
            for( j=0;j<end;j++)    
            {    
                C [i][j] = 0;    
                for( k=0; k< end;k++)    
                {    
                    C[i][j]+=A[i][k]*B[k][j];    
                }    
            }  
//            count++;
        }   
         long  endTime = System.currentTimeMillis();  
//         System.out.println(start+"的时间为"+(-startTime+endTime)+":"+count);
        for( i=start; i<end; i+=3)    
            for( j=0; j<end; j++)     
                sum += C[i][j];    
    }  
      /**
       *  串行计算一个矩阵的乘法然后在求和 
       */
    public void serial() {  
        int i,j,k;  
        for( i=0; i< end; i ++)    
        {    
            for( j=0;j<end;j++)    
            {    
                C[i][j]=0;    
                for( k=0; k< end;k++)    
                {    
                    C[i][j]+=A[i][k]*B[k][j];    
                }    
            }    
        }    
        for( i=0; i<end; i++)    
            for( j=0; j<end; j++)     
                sum += C[i][j];    
    }  
    public long getSum() {  
        return this.sum;  
    }  
}  