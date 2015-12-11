package util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author alex
 */
public class generateImage {
    
  public generateImage() throws Exception {
    try {
      BufferedImage grid1, grid2, grid3, grid4;
      int startISP = 20;
      int startFirewall= 100;
      int startCore = 300;
      int startAccessSwitch = 500;
      sqlSelect mySelectPath = new sqlSelect();
      String[] myPath = mySelectPath.obtainDataPath();
      File firewall = new File(myPath[1]+"firewall.png");
      File isp = new File(myPath[1]+"router.png");
      File core = new File(myPath[1]+"core.png");
      File accessSwitch = new File(myPath[1]+"accessSwitch.png");

      grid1 = ImageIO.read(isp);
      grid2 = ImageIO.read(firewall);
      grid3 = ImageIO.read(core);
      grid4 = ImageIO.read(accessSwitch);
      
      int min = 1200, width=1200;
      int maxDevices = 4;
      int widthRequired = 57 * maxDevices + maxDevices*30;
      
      if (widthRequired > min)
      {
          width = widthRequired;
      }
      else 
      {
          width = min;
      }
      
      int height = 700;
      
      sqlSelect mySelectISP = new sqlSelect();
      String[] informationISP = mySelectISP.obtainDataISP();
      
      sqlSelect mySelectFirewall = new sqlSelect();
      String[] informationFirewall = mySelectFirewall.obtainDataFirewall();
      
      
      // TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
      // into integer pixels
      BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

      Graphics2D ig2 = bi.createGraphics();


      Font font = new Font("Arial Black", Font.PLAIN, 15);
      ig2.setFont(font);
      
      FontMetrics fontMetrics = ig2.getFontMetrics();
      int stringHeight = fontMetrics.getAscent();
      ig2.setPaint(Color.getHSBColor(27, 1, 1));
      
//ISP drawing      
      ig2.drawImage(grid1, width/2+50, startISP, null);
      int stringWidthISP = fontMetrics.stringWidth(informationISP[2]);
      ig2.drawString(informationISP[2], width/2-stringWidthISP, startISP+15);

//If one firewall
      
      
// If 2 firewalls 
   

//Line from ISP to Firewall      
      ig2.setColor(Color.black);
      ig2.drawLine(width/2+79, startISP+30, width/4+79, startFirewall);
      ig2.drawLine(width/2+79, startISP+30, width/4+79+width/2, startFirewall);
   
      
//Firewall drawing 
      int stringWidthFirewall = fontMetrics.stringWidth(informationFirewall[2]);

      int devicesFirewall = 2;
      
      int[] myXLocationFirewall = getXLocation(devicesFirewall, width);
      
      for (int i = 0; i<devicesFirewall; i++)
      {
       ig2.drawImage(grid2, myXLocationFirewall[i]-57, startFirewall, null);    
      }
      
      
      ig2.drawImage(grid2, width/4+50, startFirewall, null);
      ig2.drawImage(grid2, width/4+50+width/2, startFirewall, null);
      ig2.drawString(informationFirewall[2], width/4-stringWidthFirewall, startFirewall+15);
      
//Line from Firewall to CORE
      ig2.setColor(Color.black);
      ig2.drawLine(width/4+79, startFirewall+30, width/4+79, startCore);
      ig2.drawLine(width/4+79+width/2, startFirewall+30, width/4+79+width/2, startCore);
      
// Core drawing
      ig2.drawImage(grid3, width/4+50, startCore, null);
      ig2.drawImage(grid3, width/4+50+width/2, startCore, null);
      ig2.drawString(informationFirewall[2], width/4-stringWidthFirewall, startCore+15);

//Line from CORE to CORE 
      ig2.drawLine(width/4+107, startCore+15, width/4+50+width/2, startCore+15);
      
//Line from CORE to AccessSwitch
      ig2.setColor(Color.black);
      int accessNumber = width/8;
//To 1-st
      ig2.drawLine(width/4+79, startCore+30, width/8+79, startAccessSwitch);
      ig2.drawLine(width/4+79+width/2, startCore+30, width/8+79, startAccessSwitch);
 
      int accessFirstMidX = width/8+79+(width/4-width/8)/2;
      int accessFirstMidY = startCore + (startAccessSwitch - startCore+30)/2 ;
      ig2.drawRect(accessFirstMidX-50, accessFirstMidY-40, 100, 80);
      
      
//To 2nd
      ig2.drawLine(width/4+79, startCore+30, width/8+79+width/4, startAccessSwitch);
      ig2.drawLine(width/4+79+width/2, startCore+30, width/8+79+width/4, startAccessSwitch);
      int accessSecondMidX = width/4+79 + width/8/2;
      int accessSecondMidY = startCore + (startAccessSwitch - startCore+30)/2 ;
      ig2.drawRect(accessSecondMidX-50, accessSecondMidY-40, 100, 80);


//To 3rd      
      ig2.drawLine(width/4+79, startCore+30, width/8+79+width/2, startAccessSwitch);
      ig2.drawLine(width/4+79+width/2, startCore+30, width/8+79+width/2, startAccessSwitch);
//To 4rd      
      ig2.drawLine(width/4+79, startCore+30, width/8+79+width/2+width/4, startAccessSwitch);
      ig2.drawLine(width/4+79+width/2, startCore+30, width/8+79+width/2+width/4, startAccessSwitch);

      
// AccessSwitch drawing
      
      ig2.drawImage(grid4, width/8+50, startAccessSwitch, null);
      ig2.drawImage(grid4, width/8+50+width/4, startAccessSwitch, null);
      ig2.drawImage(grid4, width/8+50+width/2, startAccessSwitch, null);
      
      ig2.drawImage(grid4, width/8+50+width/2+width/4, startAccessSwitch, null);

      ig2.drawString(informationFirewall[2], width/8-stringWidthFirewall, startAccessSwitch+15);
      int devices = 3;
      
      int[] myXLocation = getXLocation(devices, width);
      
      for (int i = 0; i<devices; i++)
      {
       ig2.drawImage(grid4, myXLocation[i]-57, startAccessSwitch+70, null);    
      }

      int [] getXLocation;
      getXLocation = getLineXLocation(devices, width);
      
      for (int i = 0; i<devices; i++){
          ig2.drawLine(getXLocation[i], startAccessSwitch+30, getXLocation[i], startAccessSwitch+60);
          ig2.drawImage(grid4, getXLocation[i]-28, startAccessSwitch+60,null);
      }
      
      for (int i = 0; i<devices; i++){
          ig2.drawLine(getXLocation[i], startAccessSwitch+90, getXLocation[i], startAccessSwitch+150);
          ig2.drawImage(grid4, getXLocation[i]-28, startAccessSwitch+150,null);
      }

      for (int i =0; i< devices-1; i++)
      {
          for (int k=i; k < devices; k++)
          {
          ig2.drawLine(getXLocation[i], startAccessSwitch+90, getXLocation[i+1], startAccessSwitch+150);
         
          }
      }

      
      
      ImageIO.write(bi, "PNG", new File(myPath[1]+"hardwareTopology.png"));

    } catch (IOException ie) {
      throw new IOException("Issue"+ie);
    }

  }  
  
  private int [] getLineXLocation (int devices, int width)
  {
      int [] lineXLocation = new int[devices];
      int position = width/devices-29;
      for (int i = 0; i<devices; i++)
      {
          lineXLocation[i] = position*(i+1);
      }
      
      
      return lineXLocation;
  }
    


public int [] getXLocation (int devices, int width)
{
    int [] xLocation = new int[devices];
    
    int number = width/devices;
    
    for (int i = 0; i <devices; i++)
    {
        xLocation[i] = number*(i+1);
        
    }
    
    return xLocation;
}
}

