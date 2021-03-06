/**
 * BarChart -- given an array of integers and a window size, draw a
 *        bar chart representing the data. The bars should spread across
 *        the width of the window.
 */
import wheelsunh.users.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;

public class BarChart extends ShapeGroup
{
   //--------------------- instance variables ----------------------------
   // Since all your code will be in the constructor, these variables do
   //   not actually need to be instance variables.
   // However, these are key variables for the class that we have
   //   pre-defined, so it is convenient to define them here.
   //----------------------------------------------------------------------
   
   private int barW = 20;        // default width; change based on # values
   private int barSpace = 4;     // space between bars
   
   private Color chartColor = Color.CYAN;  // background color
   private Color barColor   = Color.BLUE;    // bar color
   
   private Rectangle chart;    // rectangle defines background of chart
   private Point start;        // used for dragging
   
   //-------------------- constructor -------------------------------
   /**
    * width and height are size of the background for the bar chart.
    *    these are the size of the background rectangle, chart.
    */
   public BarChart( int width, int height, int[] data )
   {
      chart = new Rectangle( 0, 0 );
      add( chart );      
      chart.setColor( chartColor );
      chart.setSize( width, height );      
      ////////////////// add code here //////////////////////////
     for( int i = 0; i < data.length; i++ )
     {
         Rectangle bar1 = new Rectangle( i * ( barW + barSpace + 43 ), height - data[ i ]);
         bar1.setSize( ( width / data.length ) - barSpace , data[i] );
         bar1.setColor( barColor );
         add( bar1 );
     }
         
         
       
      
      
      
   }
    
   ///////////////////////////////////////////////////////////////
   // DO NOT CHANGE ANYTHING BELOW THIS LINE 
   /////////////////////////////////////////////////////////////////
   //------------------ mousePressed -----------------------------
   /**
    * save start point for drag
    */
   public void mousePressed( MouseEvent me )
   {
      start = me.getPoint();
   }
   //----------------- mouseDragged -------------------------------
   /**
    * move by mouse move delta
    */
   public void mouseDragged( MouseEvent me )
   {
      Point here = me.getPoint();
      int dx = here.x - start.x;
      int dy = here.y - start.y;
      
      setLocation( getXLocation() + dx, getYLocation() + dy );
      start = here;
   }  
   //------------------------ main: unit test ----------------------------
   /**
    * This test generates 2 different bar charts, each in its own frame
    */
   public static void main( String[] args )
   {
      Frame f = new Frame();
      
      int[] data1 = { 100, 40, 60, 80, 120, 200, 250, 10, 390 };
      BarChart bc = new BarChart( 600, 400, data1 );
      
      //JOptionPane.showMessageDialog( null, "Ready for another?" );
      
      f = new Frame( 400, 400 );
      
      int[] data2 = { 70, 28, 56 };
      bc = new BarChart( 200, 300, data2 );
   }
}