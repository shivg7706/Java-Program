import java.lang.Math.*;
import javax.swing.*; 
import java.awt.event.*;   
import java.awt.*;
public class assi extends JFrame implements ActionListener{    
JRadioButton r1,r2,r3,r4,r5;
JButton b,r,z;  
JLabel l1,l2,l3;

int a=0,q=0,c=0,d=0,maxi;
assi(){    
     
r1=new JRadioButton("Bhartiya Janta Party");    
r2=new JRadioButton("Indian National Congress");    
r3=new JRadioButton("Bahujan Samaj Party");
r4=new JRadioButton("Samajwadi Party");
r5=new JRadioButton();
r5.setVisible(false);
l1=new JLabel("Please cast your VOTE");
l2=new JLabel("Created by: Shivam Gupta");
l3=new JLabel("Have a Vision ? Make a Right Decision ! -VOTE-");
r1.setBounds(100,50,400,30);    
r2.setBounds(100,100,400,30);
r3.setBounds(100,150,400,30);
r4.setBounds(100,200,400,30); 
l1.setBounds(50,20,400,20);  
l2.setBounds(150,450,400,20);
l3.setBounds(75,425,400,20);
ButtonGroup bg=new ButtonGroup();    
bg.add(r1);bg.add(r2);
bg.add(r3);bg.add(r4); bg.add(r5);  
b=new JButton("SUBMIT");
b.setBounds(200,250,100,30);
r=new JButton("RESULTS");
r.setBounds(200,300,100,30);
z=new JButton("RESET");
z.setBounds(200,350,100,30);
b.addActionListener(this);
r.addActionListener(this);
z.addActionListener(this);
add(r1);add(r2);
add(r3);add(r4);add(b); add(r5);add(z);
add(r);add(l1);add(l2);add(l3);
setSize(500,500);    
setLayout(null);
setTitle("Electoral Voting Panel");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBackground(Color.YELLOW);    
setVisible(true);    
}
    
public void actionPerformed(ActionEvent e){
	if(e.getSource()==b){
		

	if(r1.isSelected()){
		int i= JOptionPane.showConfirmDialog(this, "Are you sure");
		if(i==0){
		a++;
		JOptionPane.showMessageDialog(this,"You Selected B.J.P.");
	}
		else {
			JOptionPane.showMessageDialog(this,"Oops,You didn't cast any vote");

	}
	}
	if(r2.isSelected()){
		int i= JOptionPane.showConfirmDialog(this, "Are you sure");
		if(i==0){
		q++;
		JOptionPane.showMessageDialog(this,"You Selected I.N.C.");
	}	
		else {
			JOptionPane.showMessageDialog(this,"Oops,You didn't cast any vote");

	}

	}
	if(r3.isSelected()){
		int i= JOptionPane.showConfirmDialog(this, "Are you sure");
		if(i==0){
		c++;
		JOptionPane.showMessageDialog(this,"You Selected B.S.P.");
	}
		else {
			JOptionPane.showMessageDialog(this,"Oops,You didn't cast any vote");

	}
	}	
	if(r4.isSelected()){
		int i= JOptionPane.showConfirmDialog(this, "Are you sure!");
		if(i==0){
		d++;
		JOptionPane.showMessageDialog(this,"You Selected S.P.");
	}
		else {
			JOptionPane.showMessageDialog(this,"Oops,You didn't cast any vote");

	}
	}
r5.setSelected(true);
}

else if(e.getSource()==r)
{
	maxi=Math.max(a,Math.max(q,Math.max(c,d)));
	String s;
	int k=0;
	if(maxi==a) k++;
	if(maxi==q) k++;
	if(maxi==c) k++;
	if(maxi==d) k++;
	
	if(k!=1)
	{
		JOptionPane.showMessageDialog(this,"Election Tied");
	}
	else{
	if(maxi==a){
		s="Bhartiya Janta Party";
	}else if (maxi==q) {s="Indian National Congress";
		
	}else if (maxi==c) {s="Bahujan Samaj Party";
		
	}else s="Samajwadi Party";
	JOptionPane.showMessageDialog(this,"Hurrah! "+s+" WON with total of "+maxi+" votes","RESULTS",JOptionPane.PLAIN_MESSAGE);
}
}
if(e.getSource()==z || e.getSource()==r)
{a=0;q=0;c=0;d=0;}
}
public static void main(String[] args) {    
    new assi();    
}    
}
