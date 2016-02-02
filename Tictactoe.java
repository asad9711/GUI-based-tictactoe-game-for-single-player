import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
class Tictactoe implements ActionListener//TIC TAC TOE WHEN SECOND PLAYER IS COMPUTER
{
JFrame f;
JButton b3;
JLabel l;
JButton b[][]=new JButton[3][3];
int counter=0,flag=0,n1,n2,logicflag=0;
Random r=new Random();
public Tictactoe(String x)
{
f=new JFrame(x);
 for(int i=0;i<3;i++)
 {
 for(int j=0;j<3;j++)
 {
	 b[i][j]=new JButton();
	 b[i][j].setBounds(80+100*j,30+100*i,100,100);
	 b[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
	  b[i][j].setText(" ");
     f.add(b[i][j]);
	 b[i][j].addActionListener(this);
 }
 }

 b3=new JButton("refresh");
 

 b3.setBounds(130,500,200,50);
 b3.setFont(new Font("Arial", Font.PLAIN, 20));
 b3.addActionListener(this);
 l=new JLabel();
 l.setFont(new Font("Arial", Font.PLAIN, 60));
 l.setBounds(100,380,450,70);
 l.setOpaque(true);
 f.add(l);
 f.add(b3);
 f.setSize(600,700);
 f.setLayout(null);
     l.setText(" ");
	 f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 f.setVisible(true);
}
public static void main(String s[])
{
new Tictactoe("Tic tac toe Game");
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b3)//new game
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				b[i][j].setText(" ");
			}
		}
		counter=0;flag=0;logicflag=0;
		l.setText(" ");
	}
	else
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
		      if(e.getSource()==b[i][j])
		      {
			     b[i][j].setText("0");        // logicflag=0;
				 counter++;
				 checkrow();
		         checkcol();
		         checkdiag();
				 if(flag==0&&counter<9)
				 {
				       logiccall();
				 counter++;
				 }
				 checkrow();
		         checkcol();
		         checkdiag();
			  }
			}
		}  
	}
	
		  if(counter==9&&flag==0)
			  l.setText("TIE");
		}
			

//function to put value by computer
public void call()
{
	
			  
					  n1=r.nextInt(3);
			          n2=r.nextInt(3);
					if(counter==1)
					{
			      	  if(b[n1][n2].getText().equals(" "))
					
						  b[n1][n2].setText("X");
						  
					  
					  else
						call();
					return;
					}
					  if(b[0][0].getText().equals("0")&&b[1][1].getText().equals("0")&&b[2][2].getText().equals(" "))
					  { b[2][2].setText("X"); return; }
				    if(b[0][0].getText().equals("0")&&b[2][2].getText().equals("0")&&b[1][1].getText().equals(" "))
					{  b[1][1].setText("X");return; }
				    if(b[1][1].getText().equals("0")&&b[2][2].getText().equals("0")&&b[0][0].getText().equals(" "))
					{  b[0][0].setText("X");return; }
				
				    if(b[0][2].getText().equals("0")&&b[1][1].getText().equals("0")&&b[2][0].getText().equals(" "))
					{  b[2][0].setText("X");return;  }
				    if(b[0][2].getText().equals("0")&&b[2][0].getText().equals("0")&&b[1][1].getText().equals(" "))
					{ b[1][1].setText("X");return; }
				   if(b[2][0].getText().equals("0")&&b[1][1].getText().equals("0")&&b[0][2].getText().equals(" "))
					{ b[0][2].setText("X");return; }
				
				     
					
					for(int i=0;i<3;i++)
					{
						if(b[i][0].getText().equals("0")&& b[i][1].getText().equals("0")&&b[i][2].getText().equals(" "))
						{
						b[i][2].setText("X");return;}
						if(b[i][0].getText().equals("0")&& b[i][2].getText().equals("0")&&b[i][1].getText().equals(" "))
						{ b[i][1].setText("X");return;}
						if(b[i][1].getText().equals("0")&& b[i][2].getText().equals("0")&&b[i][0].getText().equals(" "))
						{ b[i][0].setText("X");return;  }
					
					    
						if(b[0][i].getText().equals("0")&& b[1][i].getText().equals("0")&&b[2][i].getText().equals(" "))
						{
						b[2][i].setText("X");return;}
						if(b[0][i].getText().equals("0")&& b[2][i].getText().equals("0")&&b[1][i].getText().equals(" "))
						{ b[1][i].setText("X");return;}
						if(b[1][i].getText().equals("0")&& b[2][i].getText().equals("0")&&b[0][i].getText().equals(" "))
						{ b[0][i].setText("X");return;  }
					
					}
					//}	
					if(b[n1][n2].getText().equals(" "))
					  {
						  b[n1][n2].setText("X");
						  return;
					  }
					else
						call();
					//logiccall();
					
				     
}
public void logiccall()
{
	                 for(int j=0;j<3;j++)
					{
						if(b[j][0].getText().equals("X")&& b[j][1].getText().equals("X")&&b[j][2].getText().equals(" "))
						{
						b[j][2].setText("X");logicflag=1;return;}
						if(b[j][0].getText().equals("X")&& b[j][2].getText().equals("X")&&b[j][1].getText().equals(" "))
						{ b[j][1].setText("X");logicflag=1;return;}
						if(b[j][1].getText().equals("X")&& b[j][2].getText().equals("X")&&b[j][0].getText().equals(" "))
						{ b[j][0].setText("X");logicflag=1;return;  }
					
					    
						if(b[0][j].getText().equals("X")&& b[1][j].getText().equals("X")&&b[2][j].getText().equals(" "))
						{
						b[2][j].setText("X");logicflag=1;return;}
						if(b[0][j].getText().equals("X")&& b[2][j].getText().equals("X")&&b[1][j].getText().equals(" "))
						{ b[1][j].setText("X");logicflag=1;return;}
						if(b[1][j].getText().equals("X")&& b[2][j].getText().equals("X")&&b[0][j].getText().equals(" "))
						{ b[0][j].setText("X");logicflag=1;return;  }
					
					}
					//for diagonal cases
					if(b[0][0].getText().equals("X")&&b[1][1].getText().equals("X")&&b[2][2].getText().equals(" "))
					{ b[2][2].setText("X");logicflag=1; return; }
				    if(b[0][0].getText().equals("X")&&b[2][2].getText().equals("X")&&b[1][1].getText().equals(" "))
					{  b[1][1].setText("X");logicflag=1;return; }
				    if(b[1][1].getText().equals("X")&&b[2][2].getText().equals("X")&&b[0][0].getText().equals(" "))
					{  b[0][0].setText("X");logicflag=1;return; }
				
				
				    if(b[0][2].getText().equals("X")&&b[1][1].getText().equals("X")&&b[2][0].getText().equals(" "))
					{  b[2][0].setText("X");logicflag=1;return;  }
				    if(b[0][2].getText().equals("X")&&b[2][0].getText().equals("X")&&b[1][1].getText().equals(" "))
					{ b[1][1].setText("X");logicflag=1;return; }
				   if(b[2][0].getText().equals("X")&&b[1][1].getText().equals("X")&&b[0][2].getText().equals(" "))
					{ b[0][2].setText("X");logicflag=1;return; }
				
				
				      //n1=r.nextInt(3);
					call();
}
public void checkrow()
{
	for(int i=0;i<3;i++)
	{
		if(b[0][i].getText().equals("0")&&b[1][i].getText().equals("0")&&b[2][i].getText().equals("0"))
		{
			l.setText("YOU WON");
			flag=1;
		}
		else if(b[0][i].getText().equals("X")&&b[1][i].getText().equals("X")&&b[2][i].getText().equals("X"))
		{
			l.setText("YOU LOST");
			flag=1;
		}
	}
}
public void checkcol()
{
	
	for(int i=0;i<3;i++)
	{
		if(b[i][0].getText().equals("0")&&b[i][1].getText().equals("0")&&b[i][2].getText().equals("0"))
		{
			l.setText("YOU WON");
			flag=1;
		}
		else if(b[i][0].getText().equals("X")&&b[i][1].getText().equals("X")&&b[i][2].getText().equals("X"))
		{
			l.setText("YOU LOST");
			flag=1;
		}
	}
}
public void checkdiag()
{
	
	if(b[0][0].getText().equals("0")&&b[1][1].getText().equals("0")&&b[2][2].getText().equals("0"))
	{
		l.setText("YOU WON");
	     flag=1;
		}
	if(b[0][0].getText().equals("X")&&b[1][1].getText().equals("X")&&b[2][2].getText().equals("X"))
	{	
	l.setText("YOU LOST");
	 flag=1;
		}
	if(b[0][2].getText().equals("0")&&b[1][1].getText().equals("0")&&b[2][0].getText().equals("0"))
	{	
	l.setText("YOU WON");
	flag=1;
		}
	if(b[0][2].getText().equals("X")&&b[1][1].getText().equals("X")&&b[2][0].getText().equals("X"))
	{	
	l.setText("YOU LOST");
	flag=1;
		}
}
}
