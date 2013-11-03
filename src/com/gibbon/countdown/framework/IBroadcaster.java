/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.framework;




/*******************************************************************************
 * Instance interfejsu {@code IListener} zajišťují, že je třída schopna přidávat
 * nebo odebírat posluchače a posílat jim zprávy o změně
 *
 * @author  André HELLER
 * @version 1.00 — 07/2013
 */
public interface IBroadcaster
{
//== CONSTATS ==================================================================
//== DECLARED GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Přidá posluchače do kolekce posluchačů.
     *
     * @param listener instance posluchače
     */
    public void addListener(IListener listener);


    /***************************************************************************
     * Odebere poslcuahče z kolecke posluchačů
     *
     * @param listener instance posuchače
     */
    public void removeListener(IListener listener);


    /***************************************************************************
     * Vyčistí kolekci posluchačů
     */
    public void removeAllListeners();


    /***************************************************************************
     * Upozorní všechny posluchače že se stala akce
     */
    public void noticeAll();

//== INHERITED GETTERS AND SETTERS =============================================
//== REMAINING DECLARED METHODS ================================================
//== REMAINING INHERITED METHODS ===============================================
//== EMBEDDED DATA TYPES =======================================================
}
