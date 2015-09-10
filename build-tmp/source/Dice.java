import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

int total = 0;
int avg = 0;
float davg = 0;
int loop = 0;
public void setup()
{
	size(700,700);
	noLoop();
}
public void draw()
{
	int  ctotal = 0;
	background(197);
	for(int y = 75; y <= 600; y += 125)
	{
		for(int x = 50; x <= 600; x += 125)
		{
		  Die juan = new Die(x,y);
		  juan.roll();
	      juan.show();
          ctotal = ctotal + juan.num;
		}
        
	}	
	loop = loop + 1;
	total = total + ctotal;
	avg = total/loop;
	davg = (float)ctotal/25;
	textSize(20);
    text("Click to Roll Dice",80,50);
   	textSize(15);
    text("Current Outcome : " + ctotal,300,50);    
    text("Average Outcome : " + (int)avg,500,50);
    text("Current Average Outcome per Die: " + davg,300,30);
    ctotal = 0;
	
}
public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{
	int dx, dy, num;
	Die(int x, int y) //constructor
	{
		dx = x;
		dy = y;
	}
	public void roll()
	{
		num = (int)(Math.random()*6) + 1;
	}
	public void show()
	{
		noStroke();
		fill(255);
		rect(dx,dy,100,100,10);
		fill(0);
		if(num == 1)
		{
			ellipse(dx + 50,dy + 50,18,18);
		}
		else if(num == 2)
		{
			ellipse(dx + 75,dy + 25,18,18);
			ellipse(dx + 25,dy + 75,18,18);
		}
		else if(num == 3)
		{
			ellipse(dx + 50,dy + 50,18,18);
			ellipse(dx + 75,dy + 25,18,18);
			ellipse(dx + 25,dy + 75,18,18);
		}
		else if(num == 4)
		{
			ellipse(dx + 75,dy + 25,18,18);
			ellipse(dx + 25,dy + 75,18,18);
			ellipse(dx + 75,dy + 75,18,18);
			ellipse(dx + 25,dy + 25,18,18);
		}
		else if(num == 5)
		{
			ellipse(dx + 50,dy + 50,18,18);
			ellipse(dx + 75,dy + 25,18,18);
			ellipse(dx + 25,dy + 75,18,18);
			ellipse(dx + 75,dy + 75,18,18);
			ellipse(dx + 25,dy + 25,18,18);
		}
		else if(num == 6)
		{
			ellipse(dx + 75,dy + 25,18,18);
			ellipse(dx + 25,dy + 75,18,18);
			ellipse(dx + 75,dy + 75,18,18);
			ellipse(dx + 25,dy + 25,18,18);
			ellipse(dx + 25,dy + 50,18,18);
			ellipse(dx + 75,dy + 50,18,18);
		}
	}
}












  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
