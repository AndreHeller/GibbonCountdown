/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.gui;


import com.gibbon.countdown.Countdown;
import com.gibbon.countdown.framework.ICountdown;
import com.gibbon.countdown.framework.IGUI;
import com.gibbon.countdown.framework.IListener;
import com.gibbon.countdown.graphic.Graphic;
import com.gibbon.countdown.lang.CZ;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;


import static com.gibbon.countdown.lang.CZ.*;



/*******************************************************************************
 * Instances of class {@code Gui} represent ...
 *
 * @author  André HELLER
 * @version 0.00 — mm/20yy
 */
public class Gui extends JFrame implements IGUI
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

    private final ICountdown countdown = Countdown.getInstance();

    private final JLabel firtsNameLabel = new JLabel(R_FIRSTNAME);

    private final JLabel lastNameLabel = new JLabel(R_LASTNAME);

    private final JLabel countryLabel = new JLabel(R_COUNTRY);


//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public Gui()
    {
        super();
        setFrame();

        


        pack();
        setVisible(true);


    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================


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

//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//== EMBEDDED TYPES AND INNER CLASSES ==========================================
//== TESTING CLASSES AND METHODS ===============================================

//    /*************************************************************************
//     * Testing method.
//     */
//    public static void test()
//    {
//        Gui inst = new Gui();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }


    private void setFrame()
    {
        setTitle("Gibbon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBackground(FRAME_COLOR);
        setLocation(centerFrame());
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        //Nastaví oknu ikonu
        if(iconTetroidUrl != null){
            setIconImage(new ImageIcon(iconTetroidUrl).getImage());
        }
    }

}
