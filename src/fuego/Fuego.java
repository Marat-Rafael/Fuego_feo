package fuego;

import java.awt.image.BufferedImage;

public class Fuego extends BufferedImage implements Runnable {

    BufferedImage imagen = null;
    boolean mostrar = true;
    private int[][] matriz;

    public Fuego(int width, int height, int imageType) {
        super(width, height, imageType);
        matriz = new int[1000][1000];
    }

    public void crearChispas() {

        for (int i = 0; i < matriz.length; i++) {
            int aux = (int) (Math.random() * 1000);
            if (aux >= 200) {
                matriz[i][matriz[0].length - 1] = 255;
            }
        }
    }

    public void enfriar() {
        for (int i = 0; i < matriz.length; i++) {
            int aux = (int) (Math.random() * 1000);
            if (aux <= 150) {
                matriz[i][matriz[0].length - 1] = 0;
            }
        }
    }

    public void calentar() {
        for (int j = matriz[0].length - 2; j >= 0; j--) {
            for (int i = 1; i < matriz.length - 2; i++) {
                matriz[i][j] = (matriz[i][j + 1] + matriz[i + 1][j + 1] + matriz[i - 1][j + 1]) / 3;
            }
        }
    }

    public void pintarFuego() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int a = 255;
                int r = matriz[i][j];
                int g = 0;
                int b = 0;
                int p = (a << 24) | (r << 16) | (g << 8) | b;
                this.setRGB(i, j, p);
            }
        }
    }

    @Override
    public void run() {
        while (mostrar) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Error interrupted");
            }
            this.crearChispas();
            this.calentar();
            this.enfriar();
            this.pintarFuego();
        }
    }
}
