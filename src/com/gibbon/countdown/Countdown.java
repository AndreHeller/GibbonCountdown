/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown;

import com.gibbon.countdown.framework.IGUI;
import com.gibbon.countdown.framework.ICountdown;
import com.gibbon.countdown.framework.IListener;
import com.gibbon.countdown.gui.Gui;
import com.gibbon.countdown.logic.Rider;
import com.gibbon.countdown.logic.Time;
import java.util.ArrayList;
import java.util.Collection;





/*******************************************************************************
 * Instances of class {@code Countdown} represent ...
 *
 * @author  André HELLER
 * @version 0.00 — mm/20yy
 */
public final class Countdown implements ICountdown
{
//== CONSTANT CLASS ATTRIBUTES =================================================

    private static final Countdown SINGLETON = new Countdown();

    private static final Collection<Rider> RIDERS = new ArrayList<>();

//== VARIABLE CLASS ATTRIBUTES =================================================

    private static boolean alive = false;

//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    private final IGUI gui = new Gui();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    private Time riderTime1;

    private Time riderTime2;

//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Tovární metoda vracející odkaz jedináčka aplikace.
     *
     * @return odkaz na jedináčka
     */
    public static Countdown getInstance()
    {
        return SINGLETON;
    }

    /***************************************************************************
     * Konstruktor
     */
    private Countdown(){}

//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     *
     *
     * @return
     */
    @Override
    public IGUI getGui(){
        return gui;
    }


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
//        Countdown inst = new Countdown();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
