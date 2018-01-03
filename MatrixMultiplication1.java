 simport java.util.Scanner;

class MatrixProduct extends Thread {
      private int[][] A;
      private int[][] B;
      private int[][] C;
      private int row_C,col_C;
      private int var;

      public MatrixProduct(int[][] A,int[][] B,int[][] C,int row_C, int col_C,int var)
      {
         this.A=A;    
         this.B=B;
         this.C=C;
         this.row_C=row_C;    
         this.col_C=col_C; 
         this.var=var;     
      }

     public void run()
     {
         for(int i=0;i<var;i++){
               C[row_C][col_C]+=A[row_C][i]*B[i][col_C];        
         }      
     }          
 }

 public class MatrixMultiplication {
       public static void main(String[] args)
      {    //long startTime = System.currentTimeMillis();  
          Scanner In=new Scanner(System.in); 

          System.out.print("Enter no. of rows of Matrix A: ");     
          int rA=In.nextInt();
          System.out.print("Enter no. of columns of Matrix A: ");
          int cA=In.nextInt();
          System.out.print("Enter no. of rows of Matrix B: ");     
          int rB=In.nextInt();
          System.out.print("Enter no. of columns of Matrix B: ");
          int cB=In.nextInt();
          System.out.println();

          if(cA!=rB)
          {
               System.out.println("We can't do the matrix product!");
               System.exit(-1);
          }
         System.out.println("The matrix result from product will be "+rA+" x "+cB);
       System.out.println();
       int[][] A=new int[rA][cA];
       int[][] B=new int[rB][cB];
       int[][] C=new int[rA][cB];
       MatrixProduct[] thrd= new MatrixProduct[rA*cB];

       System.out.println("Enter Matrix A:");
       System.out.println();
        for(int i=0;i<rA;i++)
         {
          for(int j=0;j<cA;j++)
          {
              A[i][j]=In.nextInt();
          }
         }        
         System.out.println();    
         System.out.println("Enter Matrix B:");
         System.out.println();
          for(int i=0;i<rB;i++)
          {
           for(int j=0;j<cB;j++)
            {
              B[i][j]=In.nextInt();
            }        
          }
          System.out.println();
       int k=0;
       long startTime = System.nanoTime(); 
        for(int i=0;i<rA;i++)
        {
         for(int j=0;j<cB;j++)
          {
            thrd[k]=new MatrixProduct(A,B,C,i,j,cA);
            thrd[k].start();
            k++;
          }
        }

        for(int i=0;i<rA*cB;i++)
        {
              try{
                    thrd[i].join();
                }
            catch(InterruptedException e){}
            
        }        

        System.out.println();
        System.out.println("Result");
        System.out.println();
        for(int i=0;i<rA;i++)
        {
            for(int j=0;j<cB;j++)
            {
                System.out.print(C[i][j]+" ");
            }    
            System.out.println();            
        }       
 long endTime   = System.nanoTime();
long totalTime = (endTime - startTime)/1000000000;
System.out.println(totalTime);}
}
