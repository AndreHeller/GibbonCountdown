/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.gui;


import com.gibbon.countdown.framework.IGUI;
import com.gibbon.countdown.framework.IListener;
import com.gibbon.countdown.framework.IReactable;
import com.gibbon.countdown.graphic.Graphic;
import com.gibbon.countdown.logic.KeyListener;
import com.gibbon.countdown.logic.Keys;
import com.gibbon.countdown.logic.TimeManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/*******************************************************************************
 * Instances of class {@code Gui} represent ...
 *
 * @author  André HELLER
 * @version 0.00 — mm/20yy
 */
public class TimerFrame extends JFrame implements IGUI, IListener
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** Šířka framu */
    private static final int FRAME_WIDTH = 1024;

    /** Výška framu */
    private static final int FRAME_HEIGHT = 768;

    /** Rozlišení obrazovky */
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    /** URL ikony hlavního okna */
    private static final URL FRAME_ICON = Graphic.class.getResource("icon.png");

    /** Výchozí písmo */
    private static final String FRAME_FONT = "Apex New Medium";

    private static final String DIGIT_FONT = "Trebuchet MS";

    /** výchozí popisek */
    private static final String DEFAULT = "Default";

    /** implicitní barva pozadí okna */
    private static final Color FRAME_COLOR = new Color(253, 220, 39);


//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private final TimeManager TIME_MANAGER = TimeManager.getInstance();

    private final JPanel all;

    private final JPanel rider1Panel;

    private final JPanel rider2Panel;

    private final JLabel versusLabel = new JLabel("vs.");

    private final JPanel versusPanel = new JPanel();

    private final JPanel rider1name = new JPanel();

    private final JPanel rider2name = new JPanel();

    private final JPanel rider1time = new JPanel();

    private final JPanel rider2time = new JPanel();

    private final JLabel rider1nameLabel = new JLabel(DEFAULT);

    private final JLabel rider1timeLabel = new JLabel(DEFAULT);

    private final JLabel rider2nameLabel = new JLabel(DEFAULT);

    private final JLabel rider2timeLabel = new JLabel(DEFAULT);


//== VARIABLE INSTANCE ATTRIBUTES ==============================================
    private TimeManager tm;
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public TimerFrame()
    {
        super();
        setFrame();

        all = new JPanel();
        all.setLayout(new BorderLayout());


        rider1Panel = setRiderPanel(rider1name, rider1nameLabel, rider1time, rider1timeLabel);
        rider2Panel = setRiderPanel(rider2name, rider2nameLabel, rider2time, rider2timeLabel,BorderLayout.NORTH);


        versusLabel.setFont(new Font(FRAME_FONT, Font.BOLD, 35));
        versusPanel.add(versusLabel);
        versusPanel.setBackground(null);


        all.add(rider1Panel, BorderLayout.NORTH);
        all.add(versusPanel, BorderLayout.CENTER);
        all.add(rider2Panel, BorderLayout.SOUTH);
        all.setBackground(null);

        add(all, BorderLayout.CENTER);

        pack();
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    public void setTimerManager(TimeManager tm)
    {
        this.tm = tm;
    }

    /***************************************************************************
     * Nastaví veškeré vlasnosti framu
     */
    private void setFrame()
    {
        setTitle("Gibbon");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        placeFrame(FRAME_WIDTH,FRAME_HEIGHT, true);

        getContentPane().setBackground(FRAME_COLOR);

        //Nastaví oknu ikonu
        if(FRAME_ICON != null){
            setIconImage(new ImageIcon(FRAME_ICON).getImage());
        }

        // Nastaví posluchače kláves a přihlási se u něj jako posluchač
        addKeyListener(KeyListener.getInstance());
        KeyListener.getInstance().addListener(this);
    }

    /***************************************************************************
     * Nastaví velikost a umístění okna.
     *
     * @return pozice okna, aby bylo vycentrováno na obrazovce.
     */
    private void placeFrame(int width, int height, boolean fullScreen){
        if(fullScreen){
            setLocation(-1920,0);
            setPreferredSize(SCREEN_SIZE);
            setSize(SCREEN_SIZE);
            setResizable(false);
            setUndecorated(true);
        }
        else {
            int screenWidth = (int) SCREEN_SIZE.getWidth();
            int screenHeight = (int) SCREEN_SIZE.getHeight();

            // Zkontroluje zda není okno větší než obrazovka
            if(screenWidth < width){
                width = screenWidth;
            }
            if(screenHeight < height){
                height = screenHeight;
            }

            setPreferredSize(new Dimension(width, height));

            //Najde pozici tak, aby bylo okno vycentruvané.
            int widthCenter = (screenWidth/2)-(width/2);
            int heightCenter = (screenHeight/2)-(height/2);

            setLocation(widthCenter,heightCenter);

            setResizable(true);
            setUndecorated(false);
        }
    }


    /***************************************************************************
     *
     * @param name
     * @param nameLabel
     * @param time
     * @param timeLabel
     * @return
     */
    private JPanel setRiderPanel(JPanel name, JLabel nameLabel, JPanel time, JLabel timeLabel){
        return setRiderPanel(name, nameLabel, time, timeLabel, BorderLayout.SOUTH);
    }


    /***************************************************************************
     * Vytvoří kompletní panel pro jednoho ridera.
     *
     * @param name
     * @param nameLabel
     * @param time
     * @param timeLabel
     * @param direction umístení jména. V úvahu přichází konstanty BorderLayout.NORTH.
     * @return
     */
    private JPanel setRiderPanel(JPanel name, JLabel nameLabel, JPanel time, JLabel timeLabel, String direction)
    {
        JPanel rider = new JPanel(new BorderLayout());

        name.setBackground(null);
        nameLabel.setBackground(null);
        time.setBackground(null);
        timeLabel.setBackground(null);

        timeLabel.setFont(new Font(DIGIT_FONT, Font.PLAIN, 330));
        nameLabel.setFont(new Font(FRAME_FONT, Font.PLAIN, 100));

        name.add(nameLabel);
        time.add(timeLabel);

        if(direction.equals(BorderLayout.NORTH)){
            rider.add(name, BorderLayout.NORTH);
        }
        else {
            rider.add(name, BorderLayout.SOUTH);
        }

        rider.add(time,BorderLayout.CENTER);

        rider.setBackground(null);

        return rider;
    }


    /***************************************************************************
     * Upraví velikost a umístění okna do režimu fullscreen nebo naopak.
     */
    private void setFullScreen(boolean on){
        placeFrame(FRAME_WIDTH, FRAME_HEIGHT, on);
        throw new UnsupportedOperationException("Not yet");
    }


    /***************************************************************************
     * Inicializuje GUI, nastavípopisky jmena a časů.
     *
     * @param name1
     * @param name2
     * @param time1
     * @param time2
     */
    public void initialize(String name1, String name2,
                                        String time1, String time2){
        rider1nameLabel.setText(name1);
        rider1timeLabel.setText(time1);
        rider2nameLabel.setText(name2);
        rider2timeLabel.setText(time2);

        setVisible(true);

    }

    public void changeTime(int id, String time){
        switch(id){
            case 0 :
                rider1timeLabel.setText(time);
                break;
            case 1:
                rider2timeLabel.setText(time);
                break;
        }
    }


    /***************************************************************************
     * Zviditelní a zneviditelní okno.
     */
    public void setVisibility()
    {
        setVisible(!isVisible());
    }


    /***************************************************************************
     *
     * @param type
     */
    public void setMonitorMode(String type)
    {
        switch(type){
            case "multi" :
                setLocation(-1920, getLocation().y);
                break;
            case "single" :
                setLocation(0, getLocation().y);
                break;
        }
    }


    /***************************************************************************
     * Metoda kterou volá vysílač key listeneru.
     *
     * @param informant Striknutá klávesa {@link Keys}
     */
    @Override
    public void notice(IReactable informant)
    {
        Keys key = (Keys) informant;
        switch(key){
            case VK_ESCAPE :
                setVisibility();
                tm.cancelTimes();
                break;
            case VK_S :
                tm.startTime("first");
                break;
            case VK_K :
                tm.startTime("second");
                break;

        }
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

}
