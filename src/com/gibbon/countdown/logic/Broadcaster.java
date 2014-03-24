/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.logic;

import com.gibbon.countdown.framework.IBroadcaster;
import com.gibbon.countdown.framework.IListener;
import com.gibbon.countdown.framework.IReactable;
import java.util.ArrayList;
import java.util.Collection;





/*******************************************************************************
 * Instances of class {@code Broadcater} represent ...
 *
 * @author  André HELLER
 * @version 1.00 — mm/2013
 * @param <Time>
 */
public class Broadcaster<Time> implements IBroadcaster
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /** Kolekce posluchačů */
    private final Collection<IListener> LISTENERS = new ArrayList();

//== VARIABLE INSTANCE ATTRIBUTES ==============================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public Broadcaster()
    {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Přidá pusluchače do kolekce.
     *
     * @param listener
     */
    @Override
    public void addListener(IListener listener)
    {
        LISTENERS.add(listener);
    }


    /***************************************************************************
     * Upozorní všechny posluchače.
     *
     * @param reacter reacter, kterů způsobil změnu.
     */
    @Override
    public void noticeAll(IReactable reacter)
    {
        for(IListener listener : LISTENERS){
            listener.notice(reacter);
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
//        Broadcater inst = new Broadcater();
//    }
//    /** @param args Command line arguments - not used. */
//    public static void main(String[] args)  {  test();  }
}
