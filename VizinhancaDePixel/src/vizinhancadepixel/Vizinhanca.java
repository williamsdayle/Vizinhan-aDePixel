/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vizinhancadepixel;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author willi
 */
public class Vizinhanca {

    BufferedImage imagem;
    int altura = 0;
    int largura = 0;
    BufferedImage imagemFinal;

    public Vizinhanca() throws IOException {
        this.imagem = ImageIO.read(new File("image.jpg"));
        altura = this.imagem.getHeight();
        largura = this.imagem.getWidth();
        this.imagemFinal = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
    }

    public Color getPixelColor(int x, int y) throws AWTException {
        Color c = new Color(imagem.getRGB(x, y));
        return c;
    }

    public void mediaCalc() throws IOException, AWTException {
        int red = 0;
        int blue = 0;
        int green = 0;
        Color aux = null;
        for (int i = 0; i < largura - 1; i++) {
            for (int j = 0; j < altura - 1; j++) {

                try {
                    aux = getPixelColor(i, j);
                    red = aux.getRed();
                    green = aux.getGreen();
                    blue = aux.getBlue();
                    aux = getPixelColor(i + 1, j);
                    red += aux.getRed();
                    green += aux.getGreen();
                    blue += aux.getBlue();
                    aux = getPixelColor(i - 1, j);
                    red += aux.getRed();
                    green += aux.getGreen();
                    blue += aux.getBlue();
                    aux = getPixelColor(i, j - 1);
                    red += aux.getRed();
                    green += aux.getGreen();
                    blue += aux.getBlue();
                    aux = getPixelColor(i, j + 1);
                    red += aux.getRed();
                    green += aux.getGreen();
                    blue += aux.getBlue();
                    int newRed = red / 5;
                    int newGreen = green / 5;
                    int newBlue = blue / 5;
                    Color temp = new Color(newRed, newGreen, newBlue);
                    imagemFinal.setRGB(i, j, temp.getRGB());
                } catch (ArrayIndexOutOfBoundsException ot) {
                    /*if (j == 0) {
                        if(i>0 && i<largura-1){
                            aux = getPixelColor(i - 1, j);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            aux = getPixelColor(i + 1, j);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            aux = getPixelColor(i, j + 1);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            int newRed = red / 3;
                            int newGreen = green / 3;
                            int newBlue = blue / 3;                            
                            Color temp = new Color(newRed, newGreen,newBlue);
                            imagemFinal.setRGB(i, j, temp.getRGB());
                        }
                        if (i == 0) {
                            aux = getPixelColor(i + 1, j);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            aux = getPixelColor(i, j + 1);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            int newRed = red / 3;
                            int newGreen = green / 3;
                            int newBlue = blue / 3;
                            Color temp = new Color(newRed, newGreen, newBlue);
                            imagemFinal.setRGB(i, j, temp.getRGB());
                        }
                        if(i==largura-1){
                        aux = getPixelColor(i - 1, j);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            aux = getPixelColor(i, j + 1);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            int newRed = red / 3;
                            int newGreen = green / 3;
                            int newBlue = blue / 3;
                            Color temp = new Color(newRed, newGreen, newBlue);
                            imagemFinal.setRGB(i, j, temp.getRGB());
                        }
                    } if (j == altura-1) {
                        if (i == 0) {
                            aux = getPixelColor(i + 1, j);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            aux = getPixelColor(i, j - 1);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            int newRed = red / 3;
                            int newGreen = green / 3;
                            int newBlue = blue / 3;
                            Color temp = new Color(newRed, newGreen, newBlue);
                            imagemFinal.setRGB(i, j, temp.getRGB());
                        }
                        if(i==largura-1){
                        aux = getPixelColor(i - 1, j);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            aux = getPixelColor(i, j - 1);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            int newRed = red / 3;
                            int newGreen = green / 3;
                            int newBlue = blue / 3;
                            Color temp = new Color((int)newRed, (int)newGreen, (int)newBlue);
                            imagemFinal.setRGB(i, j, temp.getRGB());
                        }if(i>0 && i<largura-1){
                            aux = getPixelColor(i - 1, j);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            aux = getPixelColor(i + 1, j);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            aux = getPixelColor(i, j - 1);
                            red += aux.getRed();
                            green += aux.getGreen();
                            blue += aux.getBlue();
                            int newRed = red / 3;
                            int newGreen = green / 3;
                            int newBlue = blue / 3;
                            Color temp = new Color(newRed, newGreen, newBlue);
                            imagemFinal.setRGB(i, j, temp.getRGB());
                        }
                                               
                    }
                }*/

            }
            }
        }

        ImageIO.write(imagemFinal, "jpg", new File("NovaImagem.jpg"));
        System.out.println("Imagem processada");

    }

}
