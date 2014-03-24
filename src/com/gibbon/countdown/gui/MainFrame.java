/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */

package com.gibbon.countdown.gui;

import com.gibbon.countdown.Countdown;
import com.gibbon.countdown.graphic.Graphic;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxUI.ListDataHandler;





/*******************************************************************************
 * Instances of class {@code MainFrame} represent ...
 *
 * @author  André HELLER
 * @version 1.00 — mm/2013
 */
public class MainFrame extends javax.swing.JFrame
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /* Odkaz na jedináčka */
    private static final MainFrame SINGLETON = new MainFrame();

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Odkaz na hlavní komunikační třídu aplikace */
    private final Countdown COUNTDOWN = Countdown.getInstance();

    /** Rozlišení obrazovky */
    private final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    /** URL ikony hlavního okna */
    private final URL FRAME_ICON = Graphic.class.getResource("icon.png");

//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /** Stav vytváření a editace riderů. Budto vytváříme, a nepovolíme změny
     * na již existujících nebo naopak. */
    private String creatingState = "create";

    private String editingRiderSign = null;

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Tovární metoda vrací odkaz na jedináčka.
     *
     * @return odkaz na jedináčka.
     */
    public static MainFrame getInstance()
    {
        return SINGLETON;
    }

    /***************************************************************************
     * Provátní kontruktor zabraňující vytvoření instance.
     *
     * Inicializuje frame a aktualizuje seznam riderů.
     */
    private MainFrame()
    {
        initComponents();

        int screenWidth = (int) SCREEN_SIZE.getWidth();
        int screenHeight = (int) SCREEN_SIZE.getHeight();

        //Najde pozici tak, aby bylo okno vycentruvané.
        int widthCenter = (screenWidth/2)-(this.getWidth()/2);
        int heightCenter = (screenHeight/2)-(this.getWidth()/2);

        setLocation(widthCenter,heightCenter);


        //Nastaví oknu ikonu
        if(FRAME_ICON != null){
            setIconImage(new ImageIcon(FRAME_ICON).getImage());
        }


        refreshRidersList();

        setVisible(true);
    }

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /***************************************************************************
     * Obnoví seznam riderů podle aktuální stavu kolekce. Zároveň z něj vyloučí
     * ridery, který jsou jsou v seznamu pro timer.
     *
     * @return Vrátí pole se seznamem riderů.
     */
    private String[] refreshRidersList()
    {
        String[] ridersArray = COUNTDOWN.ridersToArray("rider");
        String[] timersArray = COUNTDOWN.ridersToArray("timer");
        String[] finalArray = new String[ridersArray.length - timersArray.length];

        int i = 0;

        Rider:
        for(String rider : ridersArray){

            Timer:
            for(String timer : timersArray){
                if(timer.equals(rider)){
                    continue Rider;
                }
            }

            finalArray[i] = rider;
            i++;
        }


        DefaultComboBoxModel listModel = new DefaultComboBoxModel(finalArray);
        riderList.setModel(listModel);

        return ridersArray;
    }


    /***************************************************************************
     * Obnoví seznam riderů podle aktuální stavu kolekce. Zároveň z něj vyloučí
     * ridery, který jsou jsou v seznamu pro timer.
     *
     * @return Vrátí pole se seznamem riderů.
     */
    private void refreshTimerList()
    {
        String[] timersArray = COUNTDOWN.ridersToArray("timer");

        DefaultComboBoxModel listModel = new DefaultComboBoxModel(timersArray);
        timerList.setModel(listModel);
    }


    /***************************************************************************
     * Vyčistí textová pole
     */
    private void clearTextFields()
    {
        firstNameField.setText("");
        lastNameField.setText("");
        countryField.setText("");

        creatingState = "create";
        editingRiderSign = null;
    }

    private void clearTimeValueFields()
    {
        timeValueMinutesField.setText("");
        timeValueSecondsField.setText("");
    }

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

//##############################################################################
//== GENERATED METHOD ==========================================================

    /***************************************************************************
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        profilePanel = new javax.swing.JPanel();
        lastNameField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        countryLabel = new javax.swing.JLabel();
        countryField = new javax.swing.JTextField();
        btnSaveChanges = new javax.swing.JButton();
        riderListPanel = new javax.swing.JPanel();
        riderListScrollPane = new javax.swing.JScrollPane();
        riderList = new javax.swing.JList<String>();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdd = new javax.swing.JButton();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();
        timerTitlePanel = new javax.swing.JPanel();
        timerTitleLabel = new javax.swing.JLabel();
        timerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        timerList = new javax.swing.JList<String>();
        timeValueLabel = new javax.swing.JLabel();
        timeValueMinutesField = new javax.swing.JFormattedTextField();
        btnStart = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        timeValueSecondsField = new javax.swing.JFormattedTextField();
        timerValueMinutesLabel = new javax.swing.JLabel();
        timerValueSecondsLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuMain = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        itemEnd = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenu();
        itemAuthors = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gibbon Slacklines");
        setBackground(java.awt.Color.orange);
        setBounds(new java.awt.Rectangle(25, 50, 300, 500));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("MainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(608, 530));

        firstNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        firstNameLabel.setLabelFor(lastNameField);
        firstNameLabel.setText("Jméno:");

        lastNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lastNameLabel.setLabelFor(firstNameField);
        lastNameLabel.setText("Příjmení:");

        countryLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        countryLabel.setLabelFor(countryField);
        countryLabel.setText("Země:");

        btnSaveChanges.setText("Uložit změny");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSaveChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(profilePanelLayout.createSequentialGroup()
                        .addComponent(countryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSaveChanges, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(countryField))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countryLabel)
                    .addComponent(countryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSaveChanges)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        riderList.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Philip Bitnar (CZ", "JustynaWallis (PL)" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        riderList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        riderListScrollPane.setViewportView(riderList);

        btnEdit.setText("Upravit");
        btnEdit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Odstranit");
        btnDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("Přidat na seznam");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout riderListPanelLayout = new javax.swing.GroupLayout(riderListPanel);
        riderListPanel.setLayout(riderListPanelLayout);
        riderListPanelLayout.setHorizontalGroup(
            riderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(riderListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(riderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(riderListPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(riderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(riderListPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(riderListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        riderListPanelLayout.setVerticalGroup(
            riderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, riderListPanelLayout.createSequentialGroup()
                .addContainerGap(352, Short.MAX_VALUE)
                .addGroup(riderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnAdd))
            .addGroup(riderListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(riderListPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(riderListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(69, Short.MAX_VALUE)))
        );

        titleLabel.setFont(new java.awt.Font("Apex New Medium", 0, 24)); // NOI18N
        titleLabel.setText("Vytvoření nového ridera");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        timerTitleLabel.setFont(new java.awt.Font("Apex New Medium", 0, 24)); // NOI18N
        timerTitleLabel.setText("Timer");

        javax.swing.GroupLayout timerTitlePanelLayout = new javax.swing.GroupLayout(timerTitlePanel);
        timerTitlePanel.setLayout(timerTitlePanelLayout);
        timerTitlePanelLayout.setHorizontalGroup(
            timerTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timerTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timerTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        timerTitlePanelLayout.setVerticalGroup(
            timerTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(timerTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        timerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(timerList);

        timeValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        timeValueLabel.setLabelFor(timeValueMinutesField);
        timeValueLabel.setText("Čas:");

        timeValueMinutesField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnStartActionPerformed(evt);
            }
        });

        btnRemove.setText("Odebrat ze seznamu");
        btnRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveActionPerformed(evt);
            }
        });

        timeValueSecondsField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        timerValueMinutesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerValueMinutesLabel.setLabelFor(timeValueMinutesField);
        timerValueMinutesLabel.setText("Minuty");

        timerValueSecondsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerValueSecondsLabel.setLabelFor(timeValueSecondsField);
        timerValueSecondsLabel.setText("Vteřiny");

        javax.swing.GroupLayout timerPanelLayout = new javax.swing.GroupLayout(timerPanel);
        timerPanel.setLayout(timerPanelLayout);
        timerPanelLayout.setHorizontalGroup(
            timerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(timerPanelLayout.createSequentialGroup()
                        .addComponent(timeValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(timerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemove)
                            .addGroup(timerPanelLayout.createSequentialGroup()
                                .addGroup(timerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(timerValueMinutesLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                    .addComponent(timeValueMinutesField, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(timerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(timeValueSecondsField, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                    .addComponent(timerValueSecondsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9)
                                .addComponent(btnStart)))))
                .addContainerGap())
        );
        timerPanelLayout.setVerticalGroup(
            timerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timerPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(timerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, timerPanelLayout.createSequentialGroup()
                        .addGroup(timerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeValueLabel)
                            .addComponent(timeValueMinutesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeValueSecondsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(timerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timerValueMinutesLabel)
                            .addComponent(timerValueSecondsLabel)))
                    .addComponent(btnStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        menuMain.setText("Hlavní");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Multi-monitor mód");
        jCheckBoxMenuItem1.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                itemMultiMonitorStateChanged(evt);
            }
        });
        menuMain.add(jCheckBoxMenuItem1);

        itemEnd.setMnemonic('U');
        itemEnd.setText("Ukončit");
        itemEnd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                itemEndActionPerformed(evt);
            }
        });
        menuMain.add(itemEnd);

        menuBar.add(menuMain);

        menuAbout.setMnemonic('O');
        menuAbout.setText("O aplikaci");

        itemAuthors.setText("Tvůrci");
        itemAuthors.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                itemAuthorsActionPerformed(evt);
            }
        });
        menuAbout.add(itemAuthors);

        menuBar.add(menuAbout);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timerTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(riderListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(riderListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(timerTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

//== ADT EVENT METHODS =========================================================

    /***************************************************************************
     * Tlačítko pro uložení změn v textovém formuláři. Zjistí stav, zda se
     * opravujú údaje nebo vytváří nový rider a podle toho jedná.
     *
     * Nakonec obnoví seznam riderů a vyčistí textové pole.
     *
     * @param evt vyvolaná událost.
     */
    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaveChangesActionPerformed
    {//GEN-HEADEREND:event_btnSaveChangesActionPerformed

        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String country = countryField.getText().trim();

        // Zjistitm zda uživatel vyplnil políčka
        if(firstName.equals("") ||
           lastName.equals("") ||
           country.equals("")){
            JOptionPane.showMessageDialog(this,"Musíte zadat všechny údaje!","Špatně zadané údaje",JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Zjistím zda v žádnm políčku není více slov
        if(firstName.contains(" ") ||
           lastName.contains(" ") ||
           country.contains(" ")){
            JOptionPane.showMessageDialog(this,"Žádný údaj nesmí obsahovat mezery!","Špatně zadané údaje",JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pokud se jedná o úpravu
        if(creatingState.equals("edit")){
            COUNTDOWN.deleteRider(editingRiderSign);
            if(!COUNTDOWN.createRider(firstName, lastName, country)){
                JOptionPane.showMessageDialog(this,"Tento rider je již existuje!","Špatně zadané údaje",JOptionPane.ERROR_MESSAGE);
                COUNTDOWN.createRider(editingRiderSign);
                return;
            }

        }
        // Jde o nové vytvoření
        else if(!(COUNTDOWN.createRider(firstName, lastName, country) && creatingState.equals("create"))){
            JOptionPane.showMessageDialog(this,"Tento rider je již existuje!","Špatně zadané údaje",JOptionPane.ERROR_MESSAGE);
            return;

        }

        refreshRidersList();
        clearTextFields();
    }//GEN-LAST:event_btnSaveChangesActionPerformed


    /***************************************************************************
     * Tlačítko pro úravu dat ridera. Zjistí jaký rider je vybraný a zobrazí
     * ho v editačním formuláři.
     *
     * @param evt vyvolaná událost.
     */
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEditActionPerformed
    {//GEN-HEADEREND:event_btnEditActionPerformed
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String country = countryField.getText();

        // Zkontroluje zda nejsou ve formuláři nějaké hodnoty
        if(firstName.matches(".+") ||
           lastName.matches(".+") ||
           country.matches(".+")){

            //Zeptá se uživatele, zda chce tuto akci skutečně udělat
            int decide = JOptionPane.showConfirmDialog(this, "Opravdu chcete přepsat hodnoty ve formuláři?\nVaše změny nebudou uloženy.", "Formulář není prázdný", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(decide == 1 || decide == -1){
                //Uživatel si to rozmyslel.
                return;
            }
        }

        String sign = riderList.getSelectedValue();
        if(sign == null){
            JOptionPane.showMessageDialog(this, "Musíte nejprve vybrat ridera, kterého chcete upravovat!", "Nebyl vybrán rider", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] values = sign.split(" ");

        firstNameField.setText(values[0]);
        lastNameField.setText(values[1]);
        countryField.setText(values[2].replace("(", "").replace(")", "").trim());

        creatingState = "edit";
        editingRiderSign = sign;
    }//GEN-LAST:event_btnEditActionPerformed


    /***************************************************************************
     * Tlačítko pro odstranění ridera. Odstraní ridera z kolekce a
     * následně aktualizuje celý seznam.
     *
     * @param evt vyvolaná událost.
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteActionPerformed
    {//GEN-HEADEREND:event_btnDeleteActionPerformed
        String selectedRiderSign = riderList.getSelectedValue();

        // Uživatel nevybral žádného ridera
        if(selectedRiderSign == null){
            JOptionPane.showMessageDialog(this, "Musíte nejprve vybrat ridera, kterého chcete odstranit!", "Nebyl vybrán rider", JOptionPane.ERROR_MESSAGE);
            return;
        }


        int decide = JOptionPane.showConfirmDialog(this, "Opravdu chcete odstranit ridera " + selectedRiderSign + "?", "Odstranění ridera", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Uživatel potvrdil a rider byl úspěšně odstraněn
        if(decide == 0 && COUNTDOWN.deleteRider(selectedRiderSign)){
            refreshRidersList();
        }
        else if(decide == 0){
            JOptionPane.showMessageDialog(this, "Tento rider neexistuje!", "Neexistující rider", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed


    /***************************************************************************
     * Tlačítko pro přidání ridera do seznamu timeru.
     *
     * @param evt vyvolaná událost
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddActionPerformed
    {//GEN-HEADEREND:event_btnAddActionPerformed
        String selectedRiderSign = riderList.getSelectedValue();

        // Uživatel nevybral žádného ridera
        if(selectedRiderSign == null){
            JOptionPane.showMessageDialog(this, "Musíte nejprve vybrat ridera, kterého chcete odstranit!", "Nebyl vybrán rider", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!COUNTDOWN.addRiderToBattle(selectedRiderSign)){
            JOptionPane.showMessageDialog(this,"Tento rider je již existuje!","Špatně zadané údaje",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(timerList.getModel().getSize() >= 2){
            JOptionPane.showMessageDialog(this,"V Battlu mohou být pouze dva rideři!","Battle už je plný.",JOptionPane.ERROR_MESSAGE);
            return;
        }

        refreshTimerList();
        refreshRidersList();
    }//GEN-LAST:event_btnAddActionPerformed


    /***************************************************************************
     * Tlačítko pro odebrání rider z timerlistu
     *
     * @param evt vyvolaná událost
     */
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemoveActionPerformed
    {//GEN-HEADEREND:event_btnRemoveActionPerformed
        String selectedRiderSign = timerList.getSelectedValue();

        // Uživatel nevybral žádného ridera
        if(selectedRiderSign == null){
            JOptionPane.showMessageDialog(this, "Musíte nejprve vybrat ridera, kterého chcete odstranit!", "Nebyl vybrán rider", JOptionPane.ERROR_MESSAGE);
            return;
        }

        COUNTDOWN.removeRiderFromBattle(selectedRiderSign);

        refreshTimerList();
        refreshRidersList();
    }//GEN-LAST:event_btnRemoveActionPerformed


    /***************************************************************************
     * Tlačítko pro spuštění časomíry.
     *
     * @param evt vyvolaná událost
     */
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnStartActionPerformed
    {//GEN-HEADEREND:event_btnStartActionPerformed
        String minutes = timeValueMinutesField.getText().trim();
        String seconds = timeValueSecondsField.getText().trim();

        if(minutes.equals("") || seconds.equals("")){
            JOptionPane.showMessageDialog(this,"Musíte zadat všechny údaje!","Špatně zadané údaje",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!COUNTDOWN.isBattleFull()){
            JOptionPane.showMessageDialog(this,"V seznamu timeru musí být dva rideři!","Špatný počet Rider",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!COUNTDOWN.startBattle(minutes,seconds)){
            JOptionPane.showMessageDialog(this,"Jeden Battle aktuálě běží.\nNemůžete spouštět další.","Battle už běží",JOptionPane.ERROR_MESSAGE);
            return;
        }

        clearTimeValueFields();
    }//GEN-LAST:event_btnStartActionPerformed


    /***************************************************************************
     * Položka Menu - Tvůrci Zobrazí inforace o aplikaci.
     *
     * @param evt vyvolaná událost
     */
    private void itemAuthorsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_itemAuthorsActionPerformed
    {//GEN-HEADEREND:event_itemAuthorsActionPerformed
        JOptionPane.showMessageDialog(this, "Autor aplikace:\nAndré Heller\n\n\nCopyright 2014\nGibbon Slacklines", "O aplikaci", JOptionPane.PLAIN_MESSAGE, null);
    }//GEN-LAST:event_itemAuthorsActionPerformed


    /***************************************************************************
     * Položka menu Ukončit aplikaci.
     *
     * @param evt vyvolaná událost
     */
    private void itemEndActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_itemEndActionPerformed
    {//GEN-HEADEREND:event_itemEndActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemEndActionPerformed

    private void itemMultiMonitorStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_itemMultiMonitorStateChanged
    {//GEN-HEADEREND:event_itemMultiMonitorStateChanged
        if(evt.getStateChange() == ItemEvent.DESELECTED){
            COUNTDOWN.setMonitorMode("single");
        }
        else {
            COUNTDOWN.setMonitorMode("multi");
        }
    }//GEN-LAST:event_itemMultiMonitorStateChanged



//== GENERATED ATTRIBUTES ======================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JButton btnStart;
    private javax.swing.JTextField countryField;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JMenuItem itemAuthors;
    private javax.swing.JMenuItem itemEnd;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuMain;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JList<String> riderList;
    private javax.swing.JPanel riderListPanel;
    private javax.swing.JScrollPane riderListScrollPane;
    private javax.swing.JSeparator separator;
    private javax.swing.JLabel timeValueLabel;
    private javax.swing.JFormattedTextField timeValueMinutesField;
    private javax.swing.JFormattedTextField timeValueSecondsField;
    private javax.swing.JList<String> timerList;
    private javax.swing.JPanel timerPanel;
    private javax.swing.JLabel timerTitleLabel;
    private javax.swing.JPanel timerTitlePanel;
    private javax.swing.JLabel timerValueMinutesLabel;
    private javax.swing.JLabel timerValueSecondsLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables

}


