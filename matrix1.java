import java.util.Scanner;
public class ParentTh {
     public static void main (String[] args) {
         int n,row,col;
         Scanner input = new Scanner(System.in);
         System.out.println("Enter the matrix index");
         n= input.nextInt();
         int[][] a=new int[n][n];
         int[][] b=new int[n][n];
         int[][] c=new int[n][n];
         int threadcount = 0;   
              Thread[] thrd = new Thread[n*n];
               

               try{
                   for(row = 0 ; row <n; row++)
                   {
                        for (col = 0 ; col < n; col++ )
                        {
                                // creating thread for multiplications
                             thrd[threadcount] = new Thread(new WorkerTh(row, col, a, b, c));
                             thrd[threadcount].start(); //thread start
                             
                             thrd[threadcount].join(); // joining threads
                              threadcount++;
                        }
                        
                   }
               } catch(InterruptedException ie) {}
                  
                
                

          
         System.out.println("Enter the matrix A:");
         for( row=0;row<n;row++){
             for ( col=0;col<n;col++){
                 a[row][col]=input.nextInt();
             } 
         }
         System.out.println("Enter the matrix B:");
         for( row=0;row<n;row++){
             for ( col=0;col<n;col++){
                 b[row][col]=input.nextInt();
             } 
         }
         
       // System.out.println("Result Matrix:");
        for( row=0;row<n;row++){
            for ( col=0;col<n;col++ ){
                for (int k=0;k<n;k++ ){
                    c[row][col]=c[row][col]+a[row][k]*b[k][col];
                } 
            } 
        }
       /*  for( row=0;row<n;row++){
             for ( col=0;col<n;col++){
                System.out.print(c[row][col]+"\t");
             } 
             System.out.print("\n");
         }*/
          System.out.println(" Resulting C Matrix : ");
                for(row = 0 ; row < n; row++)
                {
                        for (col = 0 ; col < n; col++ )
                        {
                            System.out.print("  "+c[row][col]);
                        }
                        System.out.println();
                 }
        
    }
    
    
}



class WorkerTh implements Runnable
{
    private int row;
    private int col;
    private int a[][];
    private int b[][];
    private int c[][];
    
    public WorkerTh(int row, int col, int a[][], int b[][], int c[][] )
    {
        this.row = row;
        this.col = col;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void run()
    {
       
       
            for(int k = 0; k < b.length; k++)
            {
             c[row][col] += a[row][k] * b[k][col];
            }
                     
    }
   
}