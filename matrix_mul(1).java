import java.util.Scanner;
public class matrix_mul{
public static void main(String[] args)
{Scanner In=new Scanner(System.in); 

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
          int[][] a=new int[rA][cA];
       int[][] b=new int[rB][cB];
       int[][] c=new int[rA][cB];
       System.out.println("Enter Matrix A:");
       System.out.println();
        for(int i=0;i<rA;i++)
         {
          for(int j=0;j<cA;j++)
          {
              a[i][j]=In.nextInt();
          }
         }        
         System.out.println();    
         System.out.println("Enter Matrix B:");
         System.out.println();
          for(int i=0;i<rB;i++)
          {
           for(int j=0;j<cB;j++)
            {
              b[i][j]=In.nextInt();
            }        
          }

        long startTime = System.currentTimeMillis(); 
          System.out.println();
       for(int j=0;j<rA;j++)
       { for(int k=0;k<cB;k++)
         c[j][k]=0;
       }
       for(int i=0;i<rA;i++)
       { for(int j=0;j<cA;j++)
         { for(int k=0;k<rB;k++)
           c[i][k]+=a[i][j]*b[j][k];
         }
       }
          for(int j=0;j<rA;j++)
       { for(int k=0;k<cB;k++)
          {System.out.print(c[j][k]);
          System.out.print(" ");}
          System.out.println();
       }
        System.out.println();
long endTime   = System.currentTimeMillis();
long totalTime = endTime - startTime;
System.out.println(totalTime);
  }
}
