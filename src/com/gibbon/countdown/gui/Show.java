/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.gui;

import com.gibbon.countdown.framework.ICountdown;
import com.gibbon.countdown.logic.Time;
import com.gibbon.countdown.graphic.Graphic;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;





/*******************************************************************************
 * Instances of class {@code Gui} represent ...
 *
 * @author  André HELLER
 * @version 0.00 — mm/20yy
 */
public class Show extends JFrame
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Šířka framu */
    private static final int FRAME_WIDTH = 1024;

    /** Výška framu */
    private static final int FRAME_HEIGHT = 768;

    /** URL ikony hlavního okna */
    private static final URL iconTetroidUrl = Graphic.class.getResource("icon.png");

    /** Rozlišení obrazovky */
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    /** implicitní barva pozadí okna */
    private static final Color FRAME_COLOR = new Color(253, 220, 39);


//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private final Background background = new Background("bg.jpg");


    private final AlphaJPanel topPanel = new AlphaJPanel();

    private final JLabel competion = new JLabel();

    private final JLabel logo = new JLabel(new ImageIcon(Graphic.class.getResource("logo.png")));



    private final AlphaJPanel timePanel = new AlphaJPanel();




    private final AlphaJPanel rider1 = new AlphaJPanel();

    private final JLabel time1 = new JLabel();

    private final JLabel name1 = new JLabel("Philip Bitnar (CZ)");



    private final AlphaJPanel rider2 = new AlphaJPanel();

    private final JLabel time2 = new JLabel();

    private final JLabel name2 = new JLabel("Justyna Wallis (PL)");


    Time time_1;

    Time time_2;

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public Show(ICountdown countdown)
    {
        super();
        setFrame();

        competion.setFont(new Font("Apex New Medium", Font.PLAIN, 60));
        competion.setText("Gibbon Czech Nationals");
        competion.setForeground(Color.BLACK);

        topPanel.add(competion);
        topPanel.add(logo);


        time1.setFont(new Font("Apex New Medium", Font.PLAIN, 100));
        time1.setForeground(Color.BLACK);

        name1.setFont(new Font("Apex New Medium", Font.PLAIN, 50));
        name1.setForeground(Color.BLACK);

        time2.setFont(new Font("Apex New Medium", Font.PLAIN, 100));
        time2.setForeground(Color.BLACK);

        name2.setFont(new Font("Apex New Medium", Font.PLAIN, 50));
        name2.setForeground(Color.BLACK);


        rider1.add(time1);
        rider1.add(name1);

        rider2.add(time2);
        rider2.add(name2);

        timePanel.add(rider1);
        timePanel.add(rider2);

        background.add(topPanel, BorderLayout.NORTH);
        background.add(timePanel, BorderLayout.CENTER);

        add(background);

        pack();
        setVisible(true);

    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================


    /***************************************************************************
     * Nastaví základní vlastnosti hlavního okna aplikce
     */
    private void setFrame()
    {
        setTitle("Gibbon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBackground(FRAME_COLOR);
        setFullScreen(false);

        //Nastaví oknu ikonu
        if(iconTetroidUrl != null){
            setIconImage(new ImageIcon(iconTetroidUrl).getImage());
        }
    }


    /***************************************************************************
     *
     */
    private void setFullScreen(boolean on){

        if(on){
            setLocation(0,0);
            setPreferredSize(SCREEN_SIZE);
            setSize(SCREEN_SIZE);

        }
        else{
            setLocation(centerFrame());
            setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
            setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        }
        setResizable(false);
        setUndecorated(true);

    }


    /***************************************************************************
     *
     * @return
     */
    private Point centerFrame(){
        double width = SCREEN_SIZE.getWidth();
        double height = SCREEN_SIZE.getHeight();
        int widthCenter = (int) (width/2)-(FRAME_WIDTH/2);
        int heightCenter = (int) (height/2)-(FRAME_HEIGHT/2);

        return new Point(widthCenter, heightCenter);
    }


//    /***************************************************************************
//     *
//     */
//    public void infoTimeChanged(){
//        time1.setText(time_1.getTime());
//        time2.setText(time_2.getTime());
//        revalidate();
//        repaint();
//    }

//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================
//
//    /*************************************************************************
//     * Testing method.
//     */
//    public static void test()
//    {
//        Show inst = new Show();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
