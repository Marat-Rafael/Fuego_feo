package fuego;

import java.awt.GridLayout;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main_fuego extends JFrame{
    
    Ventana ventana;
    Thread thread;

    public static void main(String[] args) {
        
        Main_fuego main_fuego = new Main_fuego();
        
    }
    
    public Main_fuego (){
        
        this.setLayout(new GridLayout());
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout());
        ventana = new Ventana();
        jpanel.add(ventana);
        this.add (jpanel);
        this.setSize(1000,1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        thread = new Thread(ventana);
        thread.start();

    }
}
