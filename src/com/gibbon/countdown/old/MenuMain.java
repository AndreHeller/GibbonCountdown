/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.old;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;





/*******************************************************************************
 * Instances of class {@code MenuMain} represent ...
 *
 * @author  André HELLER
 * @version 1.00 — mm/2013
 */
public class MenuMain extends JMenu
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /** Položka Nová Hra*/
    private JMenuItem playAgainItem;

    /** Položka Výběru jiné hry */
    private JMenuItem enterNewGameItem;

    /** Položka ukončit hru */
    private JMenuItem stopGameItem;

    /** Položka Ukončit aplikaci */
    private JMenuItem endOfApplicationItem;

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public MenuMain()
    {
        super("Hlavní");
        setMnemonic('H');

        createEndOfAppItem();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Ukončí celou aplikaci.
     */
    private void createEndOfAppItem()
    {
        endOfApplicationItem = new JMenuItem("Konec Hry");
        endOfApplicationItem.setMnemonic('K');
        this.add(endOfApplicationItem);

        endOfApplicationItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }

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
//        MenuMain inst = new MenuMain();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
