/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minijuego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Yair
 */
class Dibujo extends JPanel implements KeyListener {
    JLabel etiqueta;
    String tiempo;
    Timer t2;
    private Rectangle2D img1, img2, img3, img4, img5, img6, img7, img8, img9;
    int x = 320;
    double x1, x2, x3, x4, x5, x6, x7, x8;
    double y1, y2, y3, y4, y5, y6, y7, y8;    
    private boolean f1, f2, f3, f4, f5, f6, f7, f8;
    private int contTiempo,contFig1,contFig2,contFig3,contFig4,contFig5,contFig6,contFig7,contFig8;
    private int[] totales=new int[9];

    BufferedImage image1, image2, image3, image4, image5, image6, image7, image8, image9;

    public Dibujo() {
        this.setPreferredSize(new Dimension(800, 500));
        
        this.setFocusable(true);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setLayout(null);
        
        etiqueta=new JLabel();
        //etiqueta.setBorder();
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Tiempo Restante", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        etiqueta.setOpaque(true);
        etiqueta.setBackground(new Color(59, 190, 209, 200));
        etiqueta.setBounds(600, 50, 180, 60);
        etiqueta.setSize(170, 50);
        this.add(etiqueta);
        
        f1 = true;
        f2 = true;
        f3 = true;

        ObtenerImagenes();

        ObtenerX();

        Timer t = new Timer(30, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Areas();
                Aumentar();
                repaint();

            }
        });
        t.start();
        
        t2 = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                contTiempo++;
                System.out.println(contTiempo);
                etiqueta.setText("00:"+(30-contTiempo));
                
                if (contTiempo==30){
                    t.stop(); 
                    t2.stop();
                    ObtenerLitros();
                    JOptionPane.showMessageDialog(null, "Tu Huella Hidrica es de: "+totales[8]+" Litros");
                    int resp=JOptionPane.showConfirmDialog(null, "¿Deseas volver a jugar?");
                    
                    if(resp==0){
                    ObtenerX();
                    repaint();
                    contTiempo=0;
                    t.start();
                    t2.start();
                    }
                    if(resp==1){
                        System.exit(0);
                    }
                }
                
            }

            
        });
        t2.start();
        

    }

    @Override
    public void paintComponent(Graphics g) {
        ImageIcon fondo=new ImageIcon(getClass().getResource("/imagenes/fondoMinijuego.jpg"));
        g.drawImage(fondo.getImage(),0 , 0 , getWidth(),getHeight(),this);
        setOpaque(false);
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(image1, x, 400, 80, 80, null);

        if (f1) {
            g2.drawImage(image2, (int) x1, (int) y1, 60, 60, null);
        }
        if (f2) {
            g2.drawImage(image3, (int) x2, (int) y2, 60, 60, null);
        }
        if (f3) {
            g2.drawImage(image4, (int) x3, (int) y3, 60, 60, null);
        }
        if (f4) {
            g2.drawImage(image5, (int) x4, (int) y4, 60, 60, null);
        }
        if (f5) {
            g2.drawImage(image6, (int) x5, (int) y5, 60, 60, null);
        }
        if (f6) {
            g2.drawImage(image7, (int) x6, (int) y6, 60, 60, null);
        }
        if (f7) {
            g2.drawImage(image8, (int) x7, (int) y7, 60, 60, null);
        }
        if (f8) {
            g2.drawImage(image9, (int) x8, (int) y8, 60, 60, null);
        }

        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && x > 20) {
            x = x - 30;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && x < 700) {
            x = x + 30;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void ObtenerImagenes() {

        try {
            image1 = ImageIO.read(getClass().getResourceAsStream("/imagenes/tierra.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/imagenes/alimentos.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/imagenes/piscina.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/imagenes/automovil.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/imagenes/trastes.png"));
            image6 = ImageIO.read(getClass().getResourceAsStream("/imagenes/inodoro.png"));
            image7 = ImageIO.read(getClass().getResourceAsStream("/imagenes/plantas.png"));
            image8 = ImageIO.read(getClass().getResourceAsStream("/imagenes/regadera.png"));
            image9 = ImageIO.read(getClass().getResourceAsStream("/imagenes/ropa.png"));

        } catch (IOException ex) {
            System.out.println("Tas mal perrillo");
        }
    }

    public void Areas() {
        img1 = new Rectangle2D.Double(x, 400, 80, 80);
        img2 = new Rectangle2D.Double(x1, y1, 60, 60);
        img3 = new Rectangle2D.Double(x2, y2, 60, 60);
        img4 = new Rectangle2D.Double(x3, y3, 60, 60);
        img5 = new Rectangle2D.Double(x4, y4, 60, 60);
        img6 = new Rectangle2D.Double(x5, y5, 60, 60);
        img7 = new Rectangle2D.Double(x6, y6, 60, 60);
        img8 = new Rectangle2D.Double(x7, y7, 60, 60);
        img9 = new Rectangle2D.Double(x8, y8, 60, 60);
    }

    public void ObtenerX() {
        x1 = Math.random() * 800;
        x2 = Math.random() * 800;
        x3 = Math.random() * 800;
        x4 = Math.random() * 800;
        x5 = Math.random() * 800;
        x6 = Math.random() * 800;
        x7 = Math.random() * 800;
        x7 = Math.random() * 800;
        y1 = 0;
        y2 = -166;
        y3 = -332;
        y4 = 0;
        y5 = -166;
        y6 = -3332;
        y7 = 0;
        y8 = 0;
    }

    public void Aumentar() {

        //Figura1
        if (y1 <= 500 && f1 && !img2.intersects(img1)) {
            y1 += 10;
        } else if (img2.intersects(img1)) {
            contFig1++;
            x1 = Math.random() * 800;
            y1 = -40;
            f1 = false;
            f4 = true;
        } else {
            x1 = Math.random() * 800;
            y1 = -40;
            f1 = false;
            f4 = true;
        }

        //Figura2
        if (y2 <= 500 && f2 && !img3.intersects(img1)) {
            y2 += 10;

        } else if (img3.intersects(img1)) {
            contFig2++;
            x2 = Math.random() * 800;
            y2 = -40;
            f2 = false;
            f5 = true;
        } else {
            x2 = Math.random() * 800;
            y2 = -40;
            f2 = false;
            f5 = true;
        }
        //Figuura3
        if (y3 <= 500 && f3 && !img4.intersects(img1)) {
            y3 += 10;
        } else if (img4.intersects(img1)) {
            contFig3++;
            x3 = Math.random() * 800;
            y3 = -40;
            f3 = false;
            f6 = true;
        } else {
            x3 = Math.random() * 800;
            y3 = -40;
            f3 = false;
            f6 = true;
        }

        //Figura4
        if (y4 <= 500 && f4 && !img5.intersects(img1)) {
            y4 += 10;
        } else if (img5.intersects(img1)) {
            contFig4++;
            x4 = Math.random() * 800;
            y4 = -40;
            f4 = false;
            f7 = true;
        } else {
            x4 = Math.random() * 800;
            y4 = -40;
            f4 = false;
            f7 = true;
        }

        //Figura5
        if (y5 <= 500 && f5 && !img6.intersects(img1)) {
            y5 += 10;
        } else if (img6.intersects(img1)) {
            contFig5++;
            x5 = Math.random() * 800;
            y5 = -40;
            f5 = false;
            f8 = true;
        } else {
            x5 = Math.random() * 800;
            y5 = -40;
            f5 = false;
            f8 = true;
        }

        //Figura6
        if (y6 <= 500 && f6 && !img7.intersects(img1)) {
            y6 += 10;
        } else if (img7.intersects(img1)) {
            contFig6++;
            x6 = Math.random() * 800;
            y6 = -40;
            f6 = false;
            f1 = true;
        } else {
            x6 = Math.random() * 800;
            y6 = -40;
            f6 = false;
            f1 = true;
        }

        //Figura7
        if (y7 <= 500 && f7 && !img8.intersects(img1)) {
            y7 += 10;
        } else if (img8.intersects(img1)) {
            contFig7++;
            x7 = Math.random() * 800;
            y7 = -40;
            f7 = false;
            f2 = true;
        } else {
            x7 = Math.random() * 800;
            y7 = -40;
            f7 = false;
            f2 = true;
        }

        //Figura8
        if (y8 <= 500 && f8 && !img9.intersects(img1)) {
            y8 += 10;
        } else if (img9.intersects(img1)) {
            contFig8++;
            x8 = Math.random() * 800;
            y8 = -40;
            f8 = false;
            f3 = true;
        } else {
            x8 = Math.random() * 800;
            y8 = -40;
            f8 = false;
            f3 = true;
        }
        
        
    }
    
    public void ObtenerLitros(){
            totales[0]=contFig1*1;
            totales[1]=contFig2*50;
            totales[2]=contFig3*20;
            totales[3]=contFig4*3;
            totales[4]=contFig5*5;
            totales[5]=contFig6*2;
            totales[6]=contFig7*9;
            totales[7]=contFig8*10;
            totales[8]=totales[0]+totales[1]+totales[2]+totales[3]+totales[4]+totales[5]+totales[6]+totales[7];
            System.out.println("Frutas/Verduras= "+totales[0]+" Litros");
            System.out.println("Piscina= "+totales[1]+" Litros");
            System.out.println("Automovil= "+totales[2]+" Litros");
            System.out.println("Comida= "+totales[3]+" Litros");
            System.out.println("Inodoro= "+totales[4]+" Litros");
            System.out.println("Regar plantas= "+totales[5]+" Litros");
            System.out.println("Regadera= "+totales[6]+" Litros");
            System.out.println("Ropa= "+totales[7]+" Litros");
            System.out.println("Huella Hidrica= "+totales[8]+" Litros");
            

        }

}
