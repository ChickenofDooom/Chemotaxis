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

public class Chemotaxis extends PApplet {

Bacteria [] colony;//declare bacteria variables here   
 public void setup()   
 {     
   size(400,400);
   colony=new Bacteria[15];
   for(int i=0;i<colony.length;i++){
     colony[i]=new Bacteria(200,200);

   }//initialize bacteria variables here   
   textAlign(CENTER);
 }   
 public void draw()   
 {    
   background(0,255,255);
   fill(188,240,167);
     rect(100,150,200,250);
     triangle(100,150,300,150,200,125);
     fill(0);
     textSize(25);
     text("Port-o-Poop",200,180);
     fill(188,240,167);
     rect(125,190,155,205);
     fill(200,200,0);
     rect(190,0,20,50);
     ellipse(200,50,75,100);
     fill(25);
     ellipse(265,275,20,20);
     line(165,50,235,50);
     line(165,30,235,30);
     line(165,70,235,70);
     fill(0,255,0);
     arc(265, 275, 20, 20, PI, 2*PI);

   for (int i=0;i<colony.length;i++){
     colony[i].walk();
     colony[i].show();
   }  
   
 }  
 class Bacteria    
 {     
   int myX,myY,myColor;
   Bacteria(int x,int y){
     myX=x;
     myY=y;
     myColor=(int)((Math.random()*255)+100);
   }  
   public void walk(){
    /* if((Math.random())<0.25){
       myX+=2;
     }
     else if((Math.random())<0.5){
       myX-=2;
     }
     else if((Math.random())<0.75){
       myY+=2;
     }
     else if((Math.random())<1){
       myY-=2;
     }
       */
       myX=myX+(int)((Math.random()*10)-5);
       myY=myY+(int)((Math.random()*10)-5);
     


   }

   public void show(){
   	
     fill(myColor,myColor,0);
     ellipse(myX,myY,10,15);
     stroke(0);
     strokeWeight(2);
     line(myX-4,myY+3,myX+4,myY+3);
     line(myX-4,myY-3,myX+4,myY-3);
     line(myX-2.5f,myY-6.5f,myX-4,myY-15);
     line(myX+2.5f,myY-6.5f,myX+4,myY-15);
    
    
   }
 }    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
