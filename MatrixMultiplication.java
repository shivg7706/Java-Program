import java.util.Scanner;
import java.util.Random;
class MatrixProduct extends Thread {
      private int[][] A;
      private int[][] B;
      private int[][] C;
      private int rig,col;
      private int dim;

      public MatrixProduct(int[][] A,int[][] B,int[][] C,int rig, int col,int dim_com)
      {
         this.A=A;    
         this.B=B;
         this.C=C;
         this.rig=rig;    
         this.col=col; 
         this.dim=dim_com;     
      }

     public void run()
     {
         for(int i=0;i<dim;i++){
               C[rig][col]+=A[rig][i]*B[i][col];        
         }      
          //System.out.println("Thread "+rig+","+col+" complete.");        
     }          
 }

 public class MatrixMultiplication {
       public static void main(String[] args)
      {      
          Scanner In=new Scanner(System.in); 
          Random r = new Random();            
          System.out.print("Row of Matrix A: ");     
          int rA=In.nextInt();
          System.out.print("Column of Matrix A: ");
          int cA=In.nextInt();
          System.out.print("Row of Matrix B: ");     
          int rB=In.nextInt();
          System.out.print("Column of Matrix B: ");
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
       int[][] c=new int[rA][cB];
       MatrixProduct[][] thrd= new MatrixProduct[rA][cB];

       System.out.println("Enter the elements of Matrix A:");
       System.out.println();
        for(int i=0;i<rA;i++)
         {
          for(int j=0;j<cA;j++)
          {
              A[i][j]=r.nextInt(8);
              //System.out.print(A[i][j] + "\t");
          }
          //System.out.print("\n");
         }        
         System.out.println();    
         System.out.println("Enter the elements of Matrix B:");
         System.out.println();
          for(int i=0;i<rB;i++)
          {
           for(int j=0;j<cB;j++)
            {
            B[i][j]=r.nextInt(8);
            //System.out.print(B[i][j] + "\t");
            }    
            System.out.print("\n");    
          }
          System.out.println();
        System.out.printf("Resultant Matrix A is:\n");
        /*for(int i=0;i<rA;i++)
        	{
        		for(int j=0;j<cA;j++){
        		System.out.printf("%d\t",A[i][j]);}
        	System.out.println();
        	}
    
    	System.out.println("Resultant Matrix B is:\n");
      for(int i=0;i<rB;i++)
        	{
        		for(int j=0;j<cB;j++){
        		System.out.printf("%d\t",B[i][j]);}
        	System.out.println();
        	}
        */
        long start=System.nanoTime();
        for(int i=0;i<rA;i++)
        {
         for(int j=0;j<cB;j++)
          {
            thrd[i][j]=new MatrixProduct(A,B,C,i,j,cA);
            thrd[i][j].start();
          }
        }

        for(int i=0;i<rA;i++)
        {
            for(int j=0;j<cB;j++)
            {
                try{
                    thrd[i][j].join();
                }
            catch(InterruptedException e){}
            }
        }      
        long end=System.nanoTime();
         
         long s=System.nanoTime();
         for (int i = 0; i < rA; i++)
        {
            for (int j = 0; j < cB; j++)
            {	c[i][j]=0;
                for (int k = 0; k < cA; k++)
                    c[i][j] +=A[i][k] * B[k][j];
           	}   
       }
        long e=System.nanoTime();
        
        
        double time=(end-start)/1000000000.0;
        double t=(e-s)/1000000000.0;
        
        //System.out.println();
        System.out.println("Result");
        //System.out.println();
      /*  for(int i=0;i<rA;i++)
        {
            for(int j=0;j<cB;j++)
            {
                System.out.print(C[i][j]+"\t");
            }    
            System.out.println();            
        }  */     
        System.out.println("Time taken is:" + time+"    "+t+ " sec");
}      
}
