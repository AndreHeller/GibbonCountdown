/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.old;

import com.gibbon.countdown.Countdown;
import com.gibbon.countdown.graphic.Graphic;
import com.gibbon.countdown.logic.Rider;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;





/*******************************************************************************
 * Instances of class {@code Admin} represent ...
 *
 * @author  André HELLER
 * @version 1.00 — mm/2013
 */
public class Admin
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Odkaz na jedináčka */
    private static final Admin SINGLETON = new Admin();

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Hlavní okno aplikace */
    private final JFrame FRAME = new JFrame("Gibbon slacklines - Competition Counter");

    /** Výchozí velikost okna */
    private final Dimension FRAME_SIZE = new Dimension(640, 480);

    /** Rozlišení obrazovky */
    private final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    /** URL ikony hlavního okna */
    private final URL FRAME_ICON = Graphic.class.getResource("icon.png");

    /** Výchozí písmo */
    private final String FRAME_FONT = "Apex New Medium";

//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    private final JPanel mainPanel = new JPanel();

    private final JPanel westPanel = new JPanel();

    private JPanel riderListPanel = new JPanel();

    private JList riderList = new JList();

    private final JPanel formPanel = new JPanel();

    private final JTextField firstNameField = new JTextField();

    private final JTextField lastNameField = new JTextField();

    private final JTextField countryField = new JTextField();

    private final JLabel firstNameLabel = new JLabel("Jméno");

    private final JLabel lastNameLabel = new JLabel("Příjmení");

    private final JLabel countryLabel = new JLabel("Země");

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Tovární metoda vrací odkaz an jedináčka.
     *
     * @return odkaz na jedináčka
     */
    public static Admin getInstance()
    {
        return SINGLETON;
    }

    /***************************************************************************
     *
     */
    private Admin()
    {
        setFrame();
        setMenu();

        mainPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        mainPanel.setAlignmentX(JPanel.TOP_ALIGNMENT);



        JPanel firstNamePanel = new JPanel();
        JPanel lastNamePanel = new JPanel();
        JPanel countryPanel = new JPanel();

        firstNameField.setColumns(15);
        lastNameField.setColumns(15);
        countryField.setColumns(15);

        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameField);
        firstNamePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameField);
        lastNamePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

        countryPanel.add(countryLabel);
        countryPanel.add(countryField);
        countryPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.add(firstNamePanel);
        formPanel.add(lastNamePanel);
        formPanel.add(countryPanel);

        westPanel.add(formPanel);

        mainPanel.add(westPanel);




        //refreshRidersList();

        JScrollPane scrollpane = new JScrollPane(riderList);
        riderListPanel.add(scrollpane);
        scrollpane.setPreferredSize(new Dimension(FRAME_SIZE.width/3, FRAME_SIZE.height/100*99));

        mainPanel.add(riderListPanel, BorderLayout.CENTER);


        FRAME.add(mainPanel);

        FRAME.pack();
        FRAME.setVisible(true);
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Nastaví všechny vlasnosti framu.
     */
    private void setFrame()
    {
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int screenWidth = (int) SCREEN_SIZE.getWidth();
        int screenHeight = (int) SCREEN_SIZE.getHeight();

        int width = (int) FRAME_SIZE.getWidth();
        int height = (int) FRAME_SIZE.getHeight();

        // Zkontroluje zda není okno větší než obrazovka
        if(screenWidth < width){
            width = screenWidth;
        }
        if(screenHeight < height){
            height = screenHeight;
        }

        //FRAME.setPreferredSize(new Dimension(width, height));

        //Najde pozici tak, aby bylo okno vycentruvané.
        int widthCenter = (screenWidth/2)-(width/2);
        int heightCenter = (screenHeight/2)-(height/2);

        FRAME.setLocation(widthCenter,heightCenter);

        FRAME.setResizable(true);
        FRAME.setUndecorated(false);

        //Nastaví oknu ikonu
        if(FRAME_ICON != null){
            FRAME.setIconImage(new ImageIcon(FRAME_ICON).getImage());
        }
    }


    private void setMenu()
    {
        JMenuBar menuBar = new JMenuBar();

        MenuMain menuMain = new MenuMain();
        MenuRider menuRider = new MenuRider();
        MenuAbout menuAbout = new MenuAbout();

        menuBar.add(menuMain);
        menuBar.add(menuRider);
        menuBar.add(menuAbout);

        FRAME.setJMenuBar(menuBar);
    }


    /*private String[] refreshRidersList()
    {
        Map<String, Rider> riders = Countdown.getInstance().getRiders();
        Set<String> keys = riders.keySet();

        String[] ridersArray = new String[riders.size()];
        int i = 0;

        for(String key : keys){
            ridersArray[i] = riders.get(key).getSign();
            i++;
        }

        DefaultComboBoxModel listModel = new DefaultComboBoxModel(ridersArray);
        riderList.setModel(listModel);

        return ridersArray;
    }*/


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
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
//        Admin inst = new Admin();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
