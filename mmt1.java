import java.util.*;

class mp extends Thread {
      private int a[][] ;
      private int b[][] ;
      private int c[][];
      private int temp;
      private int cb;
      private int ca;

      public mp(int[][] a,int[][] b,int[][] c,int temp, int cb,int ca)
      {
         this.a=a;    
         this.b=b;
         this.c=c;
         this.temp=temp;    
         this.cb=cb; 
         this.ca=ca;     
      }

     public void run()
     {   
     for(int i=0;i<ca;i++)
         	for(int j=0;j<cb;j++)
               c[temp][i]+=a[temp][j]*b[j][i];        
           
     }          
 }

 public class mmt {
       public static void main(String[] args){
          int ra,ca,rb,cb; 
          Scanner in=new Scanner(System.in); 
			Random r=new Random();
          System.out.print("Enter no. of rows of Matrix A: ");     
          ra=in.nextInt();
          System.out.print("Enter no. of columns of Matrix A: ");
          ca=in.nextInt();
          System.out.print("Enter no. of rows of Matrix B: ");     
          rb=in.nextInt();
          System.out.print("Enter no. of columns of Matrix B: ");
          cb=in.nextInt();
          System.out.println();

          if(ca!=rb)
          {
               System.out.println("Multiplication not posiible");
               System.exit(-1);
          }
         
       System.out.println();
       int a[][] =new int[ra][ca];
       int b[][] =new int[rb][cb];
       int c[][]=new int[ra][cb];
       int C[][]=new int[ra][cb];
       mp[] t= new mp[ra];

       System.out.println();
        for(int i=0;i<ra;i++)
          for(int j=0;j<ca;j++)
              a[i][j]=r.nextInt(10);        
         System.out.println();    
      
         System.out.println();
          for(int i=0;i<rb;i++)
      		 for(int j=0;j<cb;j++)
                b[i][j]=r.nextInt(10);
          System.out.println();
     
long start1 = System.currentTimeMillis(); 
        for(int i=0;i<ra;i++){
         
            t[i]=new mp(a,b,c,i,cb,ca);
            t[i].start();
          
        }

        for(int i=0;i<ra;i++)
       {
              try{
                    t[i].join();
                }
            catch(InterruptedException e){}
            
        }     
        
        
long end1=System.currentTimeMillis();
long total1=end1-start1;        
         long s=System.currentTimeMillis();
        for (int i = 0; i < ra; i++)
        {
            for (int j = 0; j < cb; j++)
            {	C[i][j]=0;
                for (int k = 0; k < ca; k++)
                    C[i][j] +=a[i][k] * b[k][j];
           	}   
       }
     long e=System.currentTimeMillis();
       long t2=e-s;

        System.out.println();
        System.out.println("Result");
        System.out.println();       



System.out.println("MMT----"+total1);
System.out.println("Simple----"+t2);
	}
}
