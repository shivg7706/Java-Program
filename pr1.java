class pr1 extends Thread{  
  public void run(){  
    System.out.println("My thread is in running state.");  
  }   
  public static void main(String[] args){  
     pr1 obj=new pr1();   
     obj.start();  
  }  
}
