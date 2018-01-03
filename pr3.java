import java.util.*;
public class pr3{
	public static void main(String[] args)
	{
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		System.out.println("Enter the "+ n +" numbers.");
		int[] a=new int[n];
		for(int i=0;i<a.length;i++)
		a[i]=in.nextInt();
		Arrays.sort(a);
		System.out.printf("Array after sorting\n");
		for(int i=0;i<a.length;i++)
		System.out.printf("%d ",a[i]);
	}
}
