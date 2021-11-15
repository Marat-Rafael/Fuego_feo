package fuego;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;



/**
 * Creamos clase Ventana que herrede de la clase Canvas
 * @author Rafael
 */
public class Ventana extends Canvas implements Runnable{
    
    private BufferedImage imagen;
    Fuego fuego;

    public Ventana (){
        
        fuego = new Fuego (1000, 1000, 9);
        Thread fuego = new Thread (this.fuego);
        fuego.start();
    }
    
    public void paint(){
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        
        graphics.drawImage(fuego,0,0,1000,1000,null);
        bufferStrategy.show();
    } 

    @Override
    public void run() {
        createBufferStrategy(2);
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Error !");
            }
            this.paint();        
        }
    }
}

