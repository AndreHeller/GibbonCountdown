/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.gibbon.countdown.framework;



/*******************************************************************************
 * Instance rozhraní {@code ICountdown} je pouze jedináček představující logiku
 * celé aplikace. Rozhraní dědí rozhraní {@link IBroadcaster}.
 *
 * @author  André HELLER
 * @version 1.00 — 07/2013
 */
public interface ICountdown
{
//== CONSTATS ==================================================================
//== DECLARED GETTERS AND SETTERS ==============================================


    /***************************************************************************
     * Instance musí umět vráti svoje grafické uživatelské rozhraní
     *
     * @return Grafické uživatelské rozhraní
     */
    public IGUI getGui();

//== INHERITED GETTERS AND SETTERS =============================================
//== REMAINING DECLARED METHODS ================================================
//== REMAINING INHERITED METHODS ===============================================
//== EMBEDDED DATA TYPES =======================================================
}
