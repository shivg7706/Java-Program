import java.util.Scanner;

class Multiply extends Thread {
      private int[][] A;
      private int[][] B;
      private int[][] C;
      private int row_C,col_B;
      private int var;

      public Multiply(int[][] A,int[][] B,int[][] C,int row_C, int col_B,int var)
      {
         this.A=A;    
         this.B=B;
         this.C=C;
         this.row_C=row_C;    
         this.col_B=col_B; 
         this.var=var;     
      }

     public void run()
     {   for(int j=0;j<col_B;j++)
         for(int i=0;i<var;i++){
               C[row_C][j]+=A[row_C][i]*B[i][j];        
         }      
     }          
 }

 public class MatrixProduct {
       public static void main(String[] args)
      {   
          Scanner In=new Scanner(System.in); 
          System.out.print("Enter no. of rows of Matrix A: ");     
          int row_A=In.nextInt();
          System.out.print("Enter no. of columns of Matrix A: ");
          int col_A=In.nextInt();
          System.out.print("Enter no. of rows of Matrix B: ");     
          int row_B=In.nextInt();
          System.out.print("Enter no. of columns of Matrix B: ");
          int col_B=In.nextInt();
          System.out.println();

          if(col_A!=row_B)
          {
               System.out.println("Matrix product is not possible.");
               System.exit(-1);
          }
          int[][] A=new int[row_A][col_A];
          int[][] B=new int[row_B][col_B];
          int[][] C=new int[row_A][col_B];
          Multiply[] thrd= new Multiply[row_A];
          System.out.println("Enter Matrix A:");
          for(int i=0;i<row_A;i++)
           {
              for(int j=0;j<col_A;j++)
               {
                 A[i][j]=In.nextInt();
               }
           }        
         System.out.println();    
         System.out.println("Enter Matrix B:");
          for(int i=0;i<row_B;i++)
          {
             for(int j=0;j<col_B;j++)
             {
               B[i][j]=In.nextInt();
             }        
          }
          System.out.println();
        int k=0;
        long startTime = System.currentTimeMillis(); 
        for(int i=0;i<row_A;i++)
        {
         
            thrd[k]=new Multiply(A,B,C,i,col_B,col_A);
            thrd[k].start();
            k++;
          
        }
        System.out.println();
        System.out.println("The product of matrices Aand B is:");
        for(int i=0;i<row_A;i++)
        {
            for(int j=0;j<col_B;j++)
            {
                System.out.print(C[i][j]+" ");
            }    
            System.out.println();            
        }       
       long endTime   = System.currentTimeMillis();
       long totalTime = endTime - startTime;
       System.out.print("The total time taken is"+totalTime+"ms");
      
}
}
