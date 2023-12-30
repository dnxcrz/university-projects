import java.awt.Canvas;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

public class StarwarsAnimation extends Canvas
{
	
	public void paint(Graphics g) { //g = Graphics object  
	     Image img;
	     Image BackImg;
	     
	     for (int j=0; j<5; j++)
			{
			  for (int i=1; i<=11; i++)
			  {  
	        
	     g.clearRect(0,0,540,810); //Erase image
	     
	     if (i < 10)
			    {
	            Toolkit t = Toolkit.getDefaultToolkit();
	            BackImg = t.getImage("Resources/background.jpg"); //Returns the background image data from a file
	            img = t.getImage("Resources/fight0" + i + ".png"); //Returns an image pixel data from a file
	          }
			    else
			    {
	            Toolkit t = Toolkit.getDefaultToolkit();
	            BackImg = t.getImage("Resources/background.jpg"); //Returns the background image from a file
	            img = t.getImage("Resources/fight0" + i + ".png"); //Returns an image pixel data from a file
			    }
	             
	     		 g.drawImage(BackImg, 0, 0,this); //Draw Background
	             g.drawImage(img, 0, 0,this); //Draw image
	             
	             //to implement a time delay
	             try{
		              Thread.sleep(300); //hold 300ms before next Canvas
		             }
		               catch(InterruptedException e)
		             {
	                }
			  }
		  	}      
	    }    
	   public static void main( String args[] )
	 	{
	     
	     JFrame frame = new JFrame("Star Wars Fight");//Create the frame and place the title 	 
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	     StarwarsAnimation canvas = new StarwarsAnimation(); //Create the canvas and place image     
	     frame.add(canvas); //Add the canvas to the frame  
	     frame.setSize(540,810); //Set frame size  
	     frame.setLocationRelativeTo(null); //Set the frame location
	     frame.setVisible(true); //Makes the frame visible  
	   }
	}
