/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.old;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;





/*******************************************************************************
 * Instances of class {@code MenuRider} represent ...
 *
 * @author  André HELLER
 * @version 1.00 — mm/2013
 */
public class MenuRider extends JMenu
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    private JMenuItem addItem;

    private JMenuItem editItem;

    private JMenuItem removeItem;

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public MenuRider()
    {
        super("Riders");
        setMnemonic('R');

        createAddItem();
        createEditItem();
        createRemoveItem();
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    private void createAddItem(){
        addItem = new JMenuItem("Přidat");
        addItem.setMnemonic('P');
        this.add(addItem);

        addItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }


    private void createEditItem(){
        editItem = new JMenuItem("Upravit");
        editItem.setMnemonic('U');
        this.add(editItem);

        editItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }


    private void createRemoveItem(){
        removeItem = new JMenuItem("Odebrat");
        removeItem.setMnemonic('O');
        this.add(removeItem);

        removeItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet.");
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
//        MenuRider inst = new MenuRider();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
