import java.util.*;
 
public class mm
{
    public static void main(String[] args)
    {
        int ra,ca,rb,cb;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the row of matrix A");
        ra=in.nextInt();
        System.out.println("Enter the Column of matrix A");
        ca=in.nextInt();
        System.out.println("Enter the row of matrix B");
        rb=in.nextInt();
        System.out.println("Enter the Column of matrix B");
        cb=in.nextInt();
        
        int[][] a = new int[ra][ca];
        int[][] b = new int[rb][cb];
       	int[][] c = new int[ra][cb];
       	Random r=new Random();
       System.out.println("Enter the elements of 1st martix row wise \n");
        for (int i = 0; i < ra; i++)
            {for (int j = 0; j < ca; j++)
             {   a[i][j] = r.nextInt(8);
    }
    }
        System.out.println("Enter the elements of 2nd martix row wise \n");
        for (int i = 0; i < rb; i++)
            {for (int j = 0; j < cb; j++)
              {  b[i][j] = r.nextInt(8);
            }
            }
    System.out.println("Multiplying the matrices...");
			for (int i = 0; i < ra; i++)
            {for (int j = 0; j < cb; j++)
              {  c[i][j] = 0;
 		       }
 		       }
        
        
        
        long s=System.currentTimeMillis();
        for (int i = 0; i < ra; i++)
        {
            for (int j = 0; j < cb; j++)
            {	//c[i][j]=0;
                for (int k = 0; k < ca; k++)
                    c[i][j] +=a[i][k] * b[k][j];
           	}   
       }
     long e=System.currentTimeMillis();
       long t=e-s;
       /* System.out.println("The product is:");
        for (int i = 0; i < ra; i++)
        {
            for (int j = 0; j < cb; j++)
            {
                System.out.printf("%d\t",c[i][j]);
            }
            System.out.println();
        }*/
        
       // in.close();
    System.out.println(t);
    
    
    }
}
