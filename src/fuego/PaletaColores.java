
package fuego;

import java.awt.Color;

public class PaletaColores {
  
    public final int alfa = 255;
   
    int[][] matriz;

    public PaletaColores() {
        matriz = new int [1000][1000];    
    }
    
    public void addTargetColor (Color color){
            int a = alfa; 
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            int p = (a<<24) | (r<<16) | (g<<8) | b;

    }
    
}
