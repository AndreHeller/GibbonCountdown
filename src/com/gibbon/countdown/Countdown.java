/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown;

import com.gibbon.countdown.framework.IGUI;
import com.gibbon.countdown.framework.IListener;
import com.gibbon.countdown.framework.IReactable;
import com.gibbon.countdown.gui.Gui;





/*******************************************************************************
 * Instances of class {@code Countdown} represent ...
 *
 * @author  André HELLER
 * @version 0.00 — mm/20yy
 */
public class Countdown implements IListener
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    private static boolean alive = false;

//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private final IGUI gui = new Gui();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public Countdown()
    {

    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     *
     *
     * @return
     */
    public IGUI getGui(){
        return gui;
    }
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    @Override
    public void addListener(IReactable reactant)
    {
        LISTENERES.add(reactant);
    }


    @Override
    public void removeListener(IReactable reactant)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void noticeAll()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
//        Countdown inst = new Countdown();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
