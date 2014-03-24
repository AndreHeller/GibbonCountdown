/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.logic;

import com.gibbon.countdown.framework.IBroadcaster;
import com.gibbon.countdown.framework.IListener;
import com.gibbon.countdown.framework.IReactable;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;





/*******************************************************************************
 * Instances of class {@code KeyListener} represent ...
 *
 * @author  André HELLER
 * @version 1.00 — mm/2013
 */
public class KeyListener implements java.awt.event.KeyListener, IBroadcaster
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    /** odkaz na jedináčka */
    private static final KeyListener SINGLETON = new KeyListener();

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Kolekce posluchačů */
    private final Collection<IListener> LISTENERS = new ArrayList<IListener>();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Tovární metoda vrací odkaz na jedináčka
     *
     * @return odkaz na jedináčka
     */
    public static KeyListener getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * privátní kontruktor zabraňující vytvoření instance
     */
    private KeyListener()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Událost při stisku klávesy.
     *
     * @param e vyvolaná událost.
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        switch(keyCode){
            case KeyEvent.VK_ESCAPE: noticeAll(Keys.VK_ESCAPE);break;
            case KeyEvent.VK_S: noticeAll(Keys.VK_S);break;
            case KeyEvent.VK_K: noticeAll(Keys.VK_K);break;
        }

    }



    @Override
    public void keyTyped(KeyEvent e)
    {

    }


    @Override
    public void keyReleased(KeyEvent e)
    {
        
    }


    /***************************************************************************
     * Přidá listenera do kolekce posluchačů
     *
     * @param listener posluchač
     */
    @Override
    public void addListener(IListener listener)
    {
        LISTENERS.add(listener);
    }


    /***************************************************************************
     * Uporozní všechny posluchače.
     *
     * @param informant
     */
    @Override
    public void noticeAll(IReactable informant)
    {
        for(IListener listener : LISTENERS){
            listener.notice(informant);
        }
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
//        KeyListener inst = new KeyListener();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
